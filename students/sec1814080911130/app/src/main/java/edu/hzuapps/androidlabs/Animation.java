package edu.hzuapps.androidlabs;

import java.util.List;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * 动画绘制类
 */
public class Animation {
	boolean isEnd = false;//动画是否播放完毕
	int num;//当前播放的动画
	List<Bitmap> list;


	public Animation(List<Bitmap> list){
		this.list = list;
		num = 0;
	}


	/**
	 * 开始播放动画，每次显示一张，当所有图片播放完毕后，修改标志位和播放的位置
	 * @param canvas 画布
	 * @param paint 画笔
	 * @param x 播放动画位置的横坐标
	 * @param y 播放动画位置的纵坐标
	 */
	public void start(Canvas canvas,Paint paint, int x, int y){
		if(num<list.size()){
			canvas.drawBitmap(list.get(num), x, y, paint);
			num++;
		}else{
			num = 0;
			isEnd = true;
		}
	}
}
