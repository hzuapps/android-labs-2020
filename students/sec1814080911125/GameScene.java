package edu.hzuapps.androidlabs;

import com.orange.content.SceneBundle;
import com.orange.entity.scene.Scene;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameScene extends Scene {
    /**块的宽**/
    private float blockWidth = 0;
    /**块的高**/
    private float blockHight = 0;
    /**用于装当前所有生成但未被删除的block**/
    private List<Block[]> blockList;
    /**当前生成的块的行数**/
    private int linesLength = 5;

    @Override
    public void onSceneCreate(SceneBundle bundle) {
        super.onSceneCreate(bundle);
        // 镜头里显示的是4*4的块，所以用镜头宽的四分之一作为块宽
        blockWidth = this.getCameraWidth() / 4;
        blockHight = this.getCameraHeight() / 4;

        this.blockList = new ArrayList<Block[]>();
        initView();
    }

    private void initView() {
        // 初始化blocks
        initBlocks();
    }

    /**初始化blocks**/
    private void initBlocks() {
        Random mRandom = new Random();

        int blackIndex = 0;
        // 初始blocks,先创建4*5表格，使用时候再一行行增加
        for (int row = 0; row < linesLength; row++) {// 行
            // 一行blocks
            Block[] rowBolcks = new Block[4];
            // 随机一个黑块所在位置
            blackIndex = mRandom.nextInt(4);
            for (int column = 0; column < 4; column++) {// 列
                rowBolcks[column] = new Block(this, row, column, blockWidth,
                        blockHight, blackIndex, getVertexBufferObjectManager());
                this.attachChild(rowBolcks[column]);
            }
            blockList.add(rowBolcks);
        }
    }

}