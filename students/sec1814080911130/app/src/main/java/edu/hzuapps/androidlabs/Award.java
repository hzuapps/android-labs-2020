package edu.hzuapps.androidlabs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import edu.hzuapps.androidlabs.util.SharedPreferencesUtils;

import org.greenrobot.eventbus.EventBus;

import edu.hzuapps.androidlabs.constant.PlaneConstant;
import edu.hzuapps.androidlabs.event.OnCoinIncreaseEvent;

/**
 * 奖励对象
 */
public class Award {
    Context context;
    int nowX;
    int nowY;
    int screenWidth;
    int screenHeight;
    int width;
    int height;
    //	Bitmap[] awardPics = new Bitmap[5];
    List<Bitmap> awardPics = new ArrayList<>();
    int style;//奖励的类型
    int STEPX = 5;
    int STEPY = -5;
    boolean state = false;

    public Award(Context context, int screenWidth, int screenHeight) {
        this.context = context;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        awardPics.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.addbomb)); // 增加一颗炸弹
        awardPics.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.addhealth)); // 增加生命值
        awardPics.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.addlife)); // 增加一条生命
        awardPics.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.addpower)); // 增加子弹强度和子弹数目
        awardPics.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.addcoin)); // 增加金币数目
        awardPics.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.add_defense));// 增加防护罩
        awardPics.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.addmaxlife)); // 让当前生命上限翻倍
        awardPics.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.addattackspeed)); // 增加攻速
        awardPics.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.addcoin1)); // 增加5000金币
        width = awardPics.get(0).getWidth();
        height = awardPics.get(0).getHeight();
    }

    public void move(Canvas canvas, Paint paint) {
        impact();//碰撞检测
        if (state) {
            //移动
            if (nowX < 0) STEPX = Math.abs(STEPX);
            if (nowX > screenWidth - width) STEPX = - Math.abs(STEPX);

            nowY -= STEPY;
            nowX += STEPX;
            canvas.drawBitmap(awardPics.get(style), nowX, nowY, paint);
        } else {
            //重置
            reset();
        }

        if (nowY > screenHeight) {
            state = false;
        }
    }

    private void impact() {
        if (state && FightingView.plane.state == 1) {
            if ((nowX > FightingView.plane.nowX && nowX < (FightingView.plane.nowX + FightingView.plane.width) && nowY > FightingView.plane.nowY && nowY < (FightingView.plane.nowY + FightingView.plane.height))
                    || ((nowX + width) > FightingView.plane.nowX && (nowX + width) < (FightingView.plane.nowX + FightingView.plane.width) && nowY > FightingView.plane.nowY && nowY < (FightingView.plane.nowY + FightingView.plane.height))
                    || (nowX > FightingView.plane.nowX && nowX < (FightingView.plane.nowX + FightingView.plane.width) && (nowY + height) > FightingView.plane.nowY && (nowY + height) < (FightingView.plane.nowY + FightingView.plane.height))
                    || ((nowX + width) > FightingView.plane.nowX && (nowX + width) < (FightingView.plane.nowX + FightingView.plane.width) && (nowY + height) > FightingView.plane.nowY && (nowY + height) < (FightingView.plane.nowY + FightingView.plane.height))) {
                state = false;
                switch (style) {
                    case 0:
                        // 增加炸弹数目
                        FightingView.plane.bomb++;
                        break;
                    case 1:
                        if (FightingView.plane.health < 100) { // 增加飞机血量
                            FightingView.plane.health += 30;
                        }
                        break;
                    case 2:
                        // 增加飞机生命值
                        FightingView.plane.lives++;
                        break;
                    case 3: // 增加飞机子弹伤害并改变飞机的子弹状态
//						if(FightingView.plane.bullets.get(0).damage < 50){
//							for(Bullet bullet:FightingView.plane.bullets){
//								bullet.damage += 10;
//							}
//						}
//						// 设置飞机的子弹数目只要小于10，就可以增进子弹数目和子弹强度
//						if(FightingView.plane.shotStyle < 10)
//							FightingView.plane.shotStyle ++;
                        for (Bullet bullet : FightingView.plane.bullets) {
                            bullet.damage *= 2; // 子弹伤害翻倍
                        }
                        if (FightingView.plane.shotStyle < 5) {
                            FightingView.plane.shotStyle++;
                        }
                        break;
                    case 4:
                        // 金币增加1000
                        int coinNumber = (int) SharedPreferencesUtils.getParam(context, PlaneConstant.COIN_NUMBER, 0);
                        SharedPreferencesUtils.setParam(context, PlaneConstant.COIN_NUMBER, 1000 + coinNumber);
                        EventBus.getDefault().post(new OnCoinIncreaseEvent());
                        break;
                    case 5:
                        FightingView.plane.shield = 100; // 增加一个能够抵挡100伤害的盾
                        break;
                    case 6:
                        // 当前生命上限翻倍
                        FightingView.plane.health *= 2;
                        break;
                    case 7:
                        // 增加攻速
                        if (FightingView.plane.shotInterval > 5)
                            FightingView.plane.shotInterval -= 2;
                        break;
                    case 8:
                        // 增加5000金币
                        int coinNumber1 = (int) SharedPreferencesUtils.getParam(context, PlaneConstant.COIN_NUMBER, 0);
                        SharedPreferencesUtils.setParam(context, PlaneConstant.COIN_NUMBER, 5000 + coinNumber1);
                        EventBus.getDefault().post(new OnCoinIncreaseEvent());
                        break;
                    case 9:
                        // 获得一辆新战机
                        break;
                }
            }
        }
    }

    private void reset() {
        Random random = new Random();
        nowX = Math.abs(random.nextInt() % (screenWidth - width / 2) + 1);
        nowY = -Math.abs(random.nextInt() % (screenHeight));
        style = Math.abs(random.nextInt() % awardPics.size());
//		style = 5;
        state = false;
    }

    /**
     * reset when boss died
     *
     * @param dx
     * @param dy
     */
    public void reset(int dx, int dy) {
        Random random = new Random();
        nowX = dx;
        nowY = dy;
        style = Math.abs(random.nextInt() % awardPics.size());
//		style = 5;
        state = true;
    }
}
