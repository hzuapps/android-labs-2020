package edu.hzuapps.androidlabs;

import com.orange.entity.primitive.Rectangle;
import com.orange.opengl.vbo.VertexBufferObjectManager;
import com.orange.util.color.Color;

public class Block extends Rectangle {
    // 游戏场景
    private GameScene mGameScene;
    // 此block的颜色类型，白色还是黑色？
    private int colorType;
    // block 所在的行
    private int row;
    // block 所在的列
    private int column;

    /**
     * 构造器1,初始化blocks时用到
     * @param pGameScene 游戏场景
     * @param row block所在的行
     * @param column block所在的列
     * @param pWidth block的宽
     * @param pHeight block的高
     * @param blackIndex 用来确定是否是黑块，如果blackIndex == column时设为黑块
     * @param pVertexBufferObjectManager
     */
    public Block(GameScene pGameScene, int row, int column, float pWidth,
                 float pHeight, int blackIndex,
                 VertexBufferObjectManager pVertexBufferObjectManager) {
        super(column * pWidth, (3 - row) * pHeight, pWidth - 1, pHeight - 1,
                pVertexBufferObjectManager);
        this.mGameScene = pGameScene;
        this.row = row;
        this.column = column;
        // 初始化block的颜色数据,是白块还是黑块?
        initBlockData(column, blackIndex);
    }

    /**
     * 构造器2,新增blocks时用到
     * @param pGameScene 游戏场景
     * @param column block所在的列
     * @param pWidth block的宽
     * @param pHeight block的高
     * @param blackIndex 来确定是否是黑块，如果blackIndex == column时设为黑块
     * @param pVertexBufferObjectManager
     */
    public Block(GameScene pGameScene, int column, float pWidth, float pHeight,
                 int blackIndex, VertexBufferObjectManager pVertexBufferObjectManager) {
        super(column * pWidth, 0, pWidth - 1, pHeight - 1,
                pVertexBufferObjectManager);
        this.mGameScene = pGameScene;
        this.column = column;
        // 初始化block的颜色数据,是白块还是黑块?
        initBlockData(column, blackIndex);
    }

    /**
     * 初始化block的颜色数据,是白块还是黑块?
     * @param column
     * @param blackIndex
     */
    private void initBlockData(int column, int blackIndex) {
        if (blackIndex == column) {
            // 设置为黑块
            this.setColor(Color.BLACK);
            this.colorType = ConstantUtil.COLOR_BLACK;
        } else {
            // 设置为白块
            this.setColor(Color.WHITE);
            this.colorType = ConstantUtil.COLOR_WHITE;
        }
    }

}
