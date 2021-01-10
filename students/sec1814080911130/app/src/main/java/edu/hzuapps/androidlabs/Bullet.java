package edu.hzuapps.androidlabs;

import java.util.List;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.Log;
import edu.hzuapps.androidlabs.util.LogUtil;
import edu.hzuapps.androidlabs.util.SharedPreferencesUtils;

import edu.hzuapps.androidlabs.application.BaseApplication;
import edu.hzuapps.androidlabs.constant.PlaneConstant;

/**
 * 子弹实体类
 */
public class Bullet {
	private static final String TAG = "Bullet";
	public int damage;//子弹的威力
	public int style;//子弹的运动方式

	public int nowX;//子弹当前的位置
	public int nowY;

	public Bitmap bulletPic;//子弹的样子

	public int width;//子弹的宽
	public int height;//子弹的高
	public int step;//子弹的速度
	public int state;//子弹的状态,0：死亡爆炸状态，1：生存状态，2：可被重置状态

	private int rotation; // 子弹的旋转角度，初始为0，轴向朝手机屏幕的正上方

	public Animation animation;
	List<Plane> enemys;
	Boss boss;

	public boolean 	belongTo = true;//当前子弹属于谁，true时属于主角飞机，false属于敌机

	public Bullet(Bitmap bulletPic, List<Bitmap> destroyPics){
		this.bulletPic = bulletPic;
		animation = new Animation(destroyPics);
		damage = 10;
		style = 0;
		step = 10;
		state = 2;
		rotation = 0;
		width = bulletPic.getWidth();
		height = bulletPic.getHeight();
	}

	private Matrix matrix = new Matrix();
	/**
	 * 移动子弹,子弹状态为0时爆炸，1时移动
	 * @param canvas 画布
	 * @param paint 画笔
	 * @param screenWidth 屏幕的宽
	 * @param screenHeight 屏幕的高
	 */
	public void move(Canvas canvas, Paint paint, int screenWidth, int screenHeight){
		impact();//碰撞检测

		//移动子弹，状态为0时爆炸，为1时移动
		if(state == 0){
			if(animation.num < animation.list.size())
				animation.start(canvas, paint, nowX, nowY);
			else{
				state = 2;
				animation.isEnd = false;
			}
		}else if(state == 1){
			switch(style){
				case 1://直线向上移动
					nowY -= step;
					break;
				case 2://斜向左上移动
					nowY -= step;
					nowX -= step/3;
					rotation = - 20;
					break;
				case 3://斜向右上移动
					nowY -= step;
					nowX += step/3;
					rotation = 20;
					break;
				case 4: // 斜向较右上移动
					nowY -= step;
					nowX += step/2;
					rotation = 35;
					break;
				case 5: // 斜向较左上移动
					nowY -= step;
					nowX -=step/2;
					rotation = -35;
					break;
			}
			matrix.setRotate(rotation);
			matrix.postTranslate(nowX, nowY);
			LogUtil.d(TAG, "当前子弹的旋转角度为:" + rotation);
			canvas.drawBitmap(bulletPic, matrix, paint);
//			canvas.drawBitmap(bulletPic, nowX, nowY, paint);
		}

		//子弹超出屏幕时，状态置2
		if(nowY < 0 || nowY > screenHeight || nowX < 0 || nowX > screenWidth){
			state = 2;
		}
	}

    /**
     * 改变子弹的样式
     * @param bulletPic
     */
    public void changleBulletPic(Bitmap bulletPic) {
	    this.bulletPic = bulletPic;
    }

	/**
	 * 子弹的碰撞检测，与敌机和boss碰撞,碰撞时更改子弹的状态为0，同时减去敌机和boss的相应血量
	 */
	public void impact(){
		// 主机子弹对敌机的碰撞检测
		for(Plane enemy:enemys){
			if(enemy.state == 1 && state == 1){
				int offsetX = 10;
				int offsetY = 20;
				if((nowX > enemy.nowX + offsetX && nowX < (enemy.nowX + enemy.width - offsetX) && nowY > enemy.nowY + offsetY && nowY < (enemy.nowY + enemy.height - offsetY))
						|| ((nowX+width) > enemy.nowX + offsetX && (nowX+width) < (enemy.nowX + enemy.width - offsetX) && (nowY + height) > enemy.nowY + offsetY && (nowY + height) < (enemy.nowY + enemy.height - offsetY))){
					state = 0;
					if (FightingView.plane.shield > 0) {
					    FightingView.plane.shield -= damage;
                    } else {
					    FightingView.plane.shield = 0;
                        enemy.health -= damage;
                    }
					if(enemy.health <= 0 && PlayActivity.soundFlag){
						PlayActivity.bombMusic.start();
					}

					if(belongTo){
						FightingView.enemyDestroyedNum++;
						switch (FightingView.round) {
							case 1:
								FightingView.score += 10;
								break;
							case 2:
								FightingView.score += 20;
								break;
							case 3:
								FightingView.score += 30;
								break;
							case 4:
								FightingView.score += 40;
								break;
							case 5:
								FightingView.score += 50;
								break;
						}
						FightingView.score += 10;
						Log.i("wy", "命中敌机!敌机血量:"+enemy.health+",消灭敌机输:"+FightingView.enemyDestroyedNum);
					}else{
						Log.i("wy", "被命中!血量:"+enemy.health);
					}
				}
			}
		}

		// 主机对Boss机的碰撞检测
		if(belongTo){
			if(boss.state == 1 && state == 1){
				if((nowX > boss.nowX && nowX < (boss.nowX + boss.width) && nowY > boss.nowY && nowY < (boss.nowY + boss.height))
						|| ((nowX+width) > boss.nowX && (nowX+width) < (boss.nowX + boss.width) && (nowY + height) > boss.nowY && (nowY + height) < (boss.nowY + boss.height))){
					boss.health -= damage;
					if(boss.health <= 0 && PlayActivity.soundFlag){
						switch (FightingView.round) {
							case 1:
								// 金币数+2000
								int coinNumber = (int) SharedPreferencesUtils.getParam(BaseApplication.getContext(), PlaneConstant.COIN_NUMBER, 0);
								SharedPreferencesUtils.setParam(BaseApplication.getContext(), PlaneConstant.COIN_NUMBER, 2000 + coinNumber);
								FightingView.score += 500;
								break;
							case 2:
								// 金币数+4000
								int coinNumber1 = (int) SharedPreferencesUtils.getParam(BaseApplication.getContext(), PlaneConstant.COIN_NUMBER, 0);
								SharedPreferencesUtils.setParam(BaseApplication.getContext(), PlaneConstant.COIN_NUMBER, 4000 + coinNumber1);
								FightingView.score += 1000;
								break;
							case 3:
								FightingView.score += 2000;
								// 金币数+10000
								int coinNumber2 = (int) SharedPreferencesUtils.getParam(BaseApplication.getContext(), PlaneConstant.COIN_NUMBER, 0);
								SharedPreferencesUtils.setParam(BaseApplication.getContext(), PlaneConstant.COIN_NUMBER, 10000 + coinNumber2);
								break;
							case 4:
								// 金币数+20000
								int coinNumber3 = (int) SharedPreferencesUtils.getParam(BaseApplication.getContext(), PlaneConstant.COIN_NUMBER, 0);
								SharedPreferencesUtils.setParam(BaseApplication.getContext(), PlaneConstant.COIN_NUMBER, 20000 + coinNumber3);
								FightingView.score += 5000;
								break;
							case 5:
								// 金币数+50000
								int coinNumber4 = (int) SharedPreferencesUtils.getParam(BaseApplication.getContext(), PlaneConstant.COIN_NUMBER, 0);
								SharedPreferencesUtils.setParam(BaseApplication.getContext(), PlaneConstant.COIN_NUMBER, 50000 + coinNumber4);

								FightingView.score += 10000;
								break;
						}
						PlayActivity.bombMusic.start();
					}
					state = 0;
					Log.i("wy", "命中boss!血量:"+boss.health);
				}
			}
		}
	}

	/**
	 * 重置子弹
	 * @param planeX 飞机当前的位置的X坐标
	 * @param planeY 飞机当前的位置的Y坐标
	 * @param style 子弹运行的模式
	 */
	public void reset(int planeX,int planeY,int style){
		state = 1;
		if(belongTo){
			nowX = planeX - width/2;
			nowY = planeY + height;
		}
		else{
			nowX = planeX + width/2;
			nowY = planeY + 40;
		}
		this.rotation = 0;
		this.style = style;
	}
}