package edu.hzuapps.androidlabs;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Paint.Style;
import edu.hzuapps.androidlabs.util.LogUtil;

import org.greenrobot.eventbus.EventBus;

import edu.hzuapps.androidlabs.constant.TestConstant;
import edu.hzuapps.androidlabs.event.OnBossDiedEvent;

public class Boss extends Plane {

	public int STEPX = 5;//
	int maxHealth = 1;
	public Boss(Context context, int screenWidth, int screenHeight,
				Bitmap[] planePics) {
		super(context, screenWidth, screenHeight, planePics);
		// TODO Auto-generated constructor stub
		shotStyle = 1;
		health = 1000;
		lives = 1;
		state = 2;
		STEP = 10;

		//改变子弹的属性
		for(Bullet bullet:bullets){
			bullet.state = 2;
			bullet.belongTo = false;
			bullet.step = -10;
			bullet.bulletPic = BitmapFactory.decodeResource(context.getResources(), R.drawable.bossbullet);
		}
	}

	public void changeBossBulletPic(int id) {
		for (Bullet bullet : bullets) {
			bullet.bulletPic = BitmapFactory.decodeResource(context.getResources(), id);
		}
	}


	@Override
	public void move(Canvas canvas, Paint paint, int moveToX, int moveToY) {
		// TODO Auto-generated method stub
		impact();//碰撞检测
		if(health <= 0){
			if(!animation.isEnd)
				animation.start(canvas, paint, nowX, nowY);

			else{
				state = 2;
				animation.isEnd = false;
			}
			// 这里要生成奖励
			LogUtil.d(TestConstant.AWARD_TEST, "Boss 已死");
			EventBus.getDefault().post(new OnBossDiedEvent());
		}else{
			//画血条
			Rect rect = new Rect(0, 0, screenWidth*health/maxHealth, 10);
			paint.setColor(Color.RED);
			paint.setStyle(Style.FILL);
			canvas.drawRect(rect, paint);

			switch(moveStyle){
				case 0://boss移动轨迹
					if (nowX < 0 - width / 2) STEP = Math.abs(STEP);
					if (nowX > screenWidth - width / 2) STEP = - Math.abs(STEP);
					nowX += STEP;
					break;
				case 1://boos移动轨迹
					if (nowX < 0 - width / 2) STEP = Math.abs(STEP);
					if (nowX > screenWidth - width / 2) STEP = - Math.abs(STEP);
					nowX += STEP;

					if(nowY <= 0 || nowY >= 300){
						STEPX = -STEPX;
					}
					nowY += STEPX;
					break;
			}

			canvas.drawBitmap(planePics[0], nowX, nowY, paint);
		}

		//子弹移动
		bulletsMove(canvas,paint, 2);
	}

	/**
	 * Boss对本机的碰撞检测     【FIXME 第三关的Boss的碰撞检测出现了问题】
	 */
	public void impact() {
		for(Plane enemy:enemys){
			if(enemy.state == 1){
				if((nowX > enemy.nowX && nowX < (enemy.nowX + enemy.width) && nowY > enemy.nowY && nowY < (enemy.nowY + enemy.height))
						|| ((nowX + width) > enemy.nowX && (nowX + width) < (enemy.nowX + enemy.width) && nowY > enemy.nowY && nowY < (enemy.nowY + enemy.height))
						|| (nowX > enemy.nowX && nowX < (enemy.nowX + enemy.width) && (nowY + height) > enemy.nowY && (nowY + height) < (enemy.nowY + enemy.height))
						|| ((nowX+width) > enemy.nowX && (nowX+width) < (enemy.nowX + enemy.width) && (nowY + height) > enemy.nowY && (nowY + height) < (enemy.nowY + enemy.height))){
					health -= 10;
					enemy.health -= 10;
					if(enemy.health <= 0 && PlayActivity.soundFlag){
						PlayActivity.bombMusic.start();
					}
				}
			}
		}
	}

	@Override
	public void reset(){
		nowY = 100;
		nowX = (screenWidth - width)/2;
		state = 1;
		STEP = 10;
		health = 1;
	}

}