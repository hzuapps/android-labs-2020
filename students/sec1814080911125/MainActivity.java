package edu.hzuapps.androidlabs;

import android.os.Bundle;

import com.orange.engine.camera.ZoomCamera;
import com.orange.engine.options.PixelPerfectEngineOptions;
import com.orange.engine.options.PixelPerfectMode;
import com.orange.engine.options.ScreenOrientation;
import com.orange.ui.activity.GameActivity;

public class MainActivity extends GameActivity {
    @Override
    protected void onCreate(Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);

    }

    @Override
    protected PixelPerfectEngineOptions onCreatePixelPerfectEngineOptions() {
        PixelPerfectEngineOptions pixelPerfectEngineOptions = new PixelPerfectEngineOptions(
                this, ZoomCamera.class);
        pixelPerfectEngineOptions
                .setScreenOrientation(ScreenOrientation.PORTRAIT_FIXED); // 设置竖屏
        pixelPerfectEngineOptions
                .setPixelPerfectMode(PixelPerfectMode.CHANGE_HEIGHT);// 适配模式,这里设置为“保持宽度不变，改变高”
        pixelPerfectEngineOptions.setDesiredSize(ConstantUtil.DESIRED_SIZE);// 参考尺寸

        return pixelPerfectEngineOptions;
    }

    @Override
    protected void onLoadResources() {
    }

    @Override
    protected void onLoadComplete() {
        this.startScene(GameScene.class);// 启动游戏场景
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}