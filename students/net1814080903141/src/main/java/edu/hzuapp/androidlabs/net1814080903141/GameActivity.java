package edu.hzuapp.androidlabs.net1814080903141;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements GestureDetector.OnGestureListener{

    private final int UP = 0;
    private final int DOWN = 1;
    private final int LEFT = 2;
    private final int RIGHT = 3;
    ArrayList<Pair<Integer, Integer>> blankPairs;
    HashMap<Integer, Integer> correspondingColor;
    private Button btnrestart;
    private Button btnhelp;
    private Button btnexit;
    boolean isGame;
    SharedPreferences sharedPreferences;
    private TextView scoreTextView;
    private TextView bestTextView;
    private long score;
    private long best;
    private GestureDetectorCompat gestureDetectorCompat;
    private TextView[][] cellTextViewMatrix;
    private int[][] cellValueMatrix;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game);

        scoreTextView =  findViewById(R.id.tscore);
        bestTextView =findViewById(R.id.tbest);
        gestureDetectorCompat=new GestureDetectorCompat(this,this);
        score = 0;
        scoreTextView.setText("" + score);
        cellTextViewMatrix = new TextView[][]{
                {findViewById(R.id.cell1),  findViewById(R.id.cell2),  findViewById(R.id.cell3),  findViewById(R.id.cell4)},
                {findViewById(R.id.cell5),  findViewById(R.id.cell6),  findViewById(R.id.cell7),  findViewById(R.id.cell8)},
                {findViewById(R.id.cell9),  findViewById(R.id.cell10), findViewById(R.id.cell11), findViewById(R.id.cell12)},
                {findViewById(R.id.cell13), findViewById(R.id.cell14), findViewById(R.id.cell15), findViewById(R.id.cell16)}
        };
        cellValueMatrix = new int[][]{{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        blankPairs = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++)
                blankPairs.add(new Pair<>(i, j));
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++)
                fillCellTextView(cellTextViewMatrix[i][j], cellValueMatrix[i][j]);
        }
        fillRandomNo();
        fillRandomNo();
        btnrestart= findViewById(R.id.btnrestart);
        isGame = true;
        sharedPreferences = this.getSharedPreferences("edu.hzuapp.androidlabs.net1814080903141", MODE_PRIVATE);
        best = sharedPreferences.getLong("best", 0);
        bestTextView.setText("" + best);
        correspondingColor = new HashMap<>();
        correspondingColor.put(0, Color.argb(1, 220, 0, 0));

        // 游戏帮助
         btnhelp= findViewById(R.id.btnshelp);
        final GameActivity thisActivity=this;
        btnhelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog= new AlertDialog.Builder(thisActivity);
                dialog.setTitle("游戏玩法：");
                dialog.setMessage("玩家每次可以选择上下左右其中一个方向去滑动，每滑动一次，" +
                        "所有的数字方块就会往滑动的方向靠拢外，在空白的地方会随机出现一个数字方块，相同数字的方块在靠拢、相撞时会相加。");
                dialog.setNegativeButton("继续玩!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.show();
            }

        });

                //重新开始游戏
                btnrestart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder dialog = new AlertDialog.Builder(thisActivity);
                        dialog.setTitle("提示：");
                        dialog.setMessage("你确定要重新开始？");
                        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                blankPairs.clear();
                                thisActivity.restart();
                            }
                        });
                        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        dialog.show();
                    }
                });

        //退出游戏
        btnexit=findViewById(R.id.btnexit);
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog1=new AlertDialog.Builder(thisActivity);
                dialog1.setTitle("提示：");
                dialog1.setMessage("你确定要离开？");
                dialog1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                });
                dialog1.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog1.show();
            }
        });

    }


    //重新游戏
    public void restart() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cellValueMatrix[i][j] = 0;
                fillCellTextView(cellTextViewMatrix[i][j], cellValueMatrix[i][j]);
                blankPairs.add(new Pair<>(i, j));
            }
        }
        isGame = true;
        score = 0;
        scoreTextView.setText("" + score);
        best = sharedPreferences.getLong("best", 0);
        bestTextView.setText("" + best);
        fillRandomNo();
        fillRandomNo();
    }

    //游戏结束
    boolean isGameOver() {
        if (cellValueMatrix[0][0] == 0)
            return false;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                if (cellValueMatrix[i][j] == 0 || cellValueMatrix[i][j] == cellValueMatrix[i][j - 1])
                    return false;
            }
        }
        for (int j = 0; j < 4; j++) {
            for (int i = 1; i < 4; i++) {
                if (cellValueMatrix[i][j] == 0 || cellValueMatrix[i][j] == cellValueMatrix[i - 1][j])
                    return false;
            }
        }
        return true;
    }

    //添加数字
    void fillRandomNo() {
        if (blankPairs.isEmpty())
            return;
        Random random = new Random();
        int randomIndex = random.nextInt(blankPairs.size());
        Pair<Integer, Integer> randomBlankCell = blankPairs.get(randomIndex);
        int x = randomBlankCell.first;
        int y = randomBlankCell.second;
        blankPairs.remove(randomIndex);
        int fillValue = random.nextInt(2);
        if (fillValue == 0)
            cellValueMatrix[x][y] = 2;
        else
            cellValueMatrix[x][y] = 4;
        fillCellTextView(cellTextViewMatrix[x][y], cellValueMatrix[x][y]);
    }

    //格子颜色
    void fillCellTextView(TextView textView, int num) {
        if (num == 0)
            textView.setText(" ");
        else
            textView.setText("" + num);
        switch (num) {
            case 0:
                textView.setBackgroundColor(Color.LTGRAY);
                textView.setTextColor(Color.BLACK);
                break;
            case 2:
                textView.setBackgroundColor(Color.rgb(240, 240, 240));
                textView.setTextColor(Color.BLACK);
                break;
            case 4:
                textView.setBackgroundColor(Color.rgb(255, 255, 224));
                textView.setTextColor(Color.BLACK);
                break;
            case 8:
                textView.setBackgroundColor(Color.rgb(255, 200, 100));
                textView.setTextColor(Color.WHITE);
                break;
            case 16:
                textView.setBackgroundColor(Color.rgb(255, 140, 30));
                textView.setTextColor(Color.WHITE);
                break;
            case 32:
                textView.setBackgroundColor(Color.rgb(255, 100, 65));
                textView.setTextColor(Color.WHITE);
                break;
            case 64:
                textView.setBackgroundColor(Color.rgb(250, 80, 100));
                textView.setTextColor(Color.WHITE);
                break;
            case 128:
                textView.setBackgroundColor(Color.rgb(255, 220, 0));
                textView.setTextColor(Color.WHITE);
                break;
            case 256:
                textView.setBackgroundColor(Color.rgb(240, 240, 0));
                textView.setTextColor(Color.BLACK);
                break;
            case 512:
                textView.setBackgroundColor(Color.rgb(245, 245, 0));
                textView.setTextColor(Color.BLACK);
                break;
            case 1024:
                textView.setBackgroundColor(Color.rgb(250, 250, 0));
                textView.setTextColor(Color.BLACK);
                break;
            case 2048:
                textView.setBackgroundColor(Color.rgb(255, 255, 0));
                textView.setTextColor(Color.BLACK);
                break;
            default:
                textView.setBackgroundColor(Color.rgb(255, 255, 0));
                textView.setTextColor(Color.BLACK);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    //向上
    private void onSwipeUp() {
        if (!isGame)
            return;
        boolean onSwipeUpChange = false;
        for (int j = 0; j < 4; j++) {
            for (int i = 1; i < 4; i++) {
                if (cellValueMatrix[i][j] == 0)
                    continue;
                int k = i - 1;
                while (k >= 0 && cellValueMatrix[k][j] == 0)
                    k--;
                if (k == -1 || (cellValueMatrix[k][j] != cellValueMatrix[i][j] && (k + 1) != i)) {
                    cellValueMatrix[k + 1][j] = cellValueMatrix[i][j];
                    onSwipeUpChange = true;
                    blankPairs.remove(new Pair<>(k + 1, j));
                    cellValueMatrix[i][j] = 0;
                } else if (cellValueMatrix[k][j] == cellValueMatrix[i][j]) {
                    cellValueMatrix[k][j] += cellValueMatrix[i][j];
                    onSwipeUpChange = true;
                    score += 2 * cellValueMatrix[i][j];
                    scoreTextView.setText("" + score);
                    cellValueMatrix[i][j] = 0;
                }
            }
            for (int i = 0; i < 4; i++) {
                fillCellTextView(cellTextViewMatrix[i][j], cellValueMatrix[i][j]);
                if (cellValueMatrix[i][j] == 0 && !blankPairs.contains(new Pair<Integer, Integer>(i, j)))
                    blankPairs.add(new Pair<>(i, j));
            }
        }
        if (onSwipeUpChange)
            fillRandomNo();
        if (isGameOver()) {
            best = sharedPreferences.getLong("best", 0);
            if (score > best)
                sharedPreferences.edit().putLong("best", score).apply();
            Toast.makeText(getApplicationContext(), "Game Over", Toast.LENGTH_SHORT).show();
            isGame = false;
            saveRecord();
           btnrestart.setVisibility(View.VISIBLE);
        }
    }

    //向下
    private void onSwipeDown() {
        if (!isGame)
            return;
        boolean onSwipeDownChange = false;
        for (int j = 0; j < 4; j++) {
            for (int i = 2; i >= 0; i--) {
                if (cellValueMatrix[i][j] == 0)
                    continue;
                int k = i + 1;
                while (k <= 3 && cellValueMatrix[k][j] == 0)
                    k++;
                if (k == 4 || (cellValueMatrix[k][j] != cellValueMatrix[i][j] && (k - 1) != i)) {
                    onSwipeDownChange = true;
                    cellValueMatrix[k - 1][j] = cellValueMatrix[i][j];
                    blankPairs.remove(new Pair<>(k - 1, j));
                    cellValueMatrix[i][j] = 0;
                } else if (cellValueMatrix[k][j] == cellValueMatrix[i][j]) {
                    onSwipeDownChange = true;
                    cellValueMatrix[k][j] += cellValueMatrix[i][j];
                    score += 2 * cellValueMatrix[i][j];
                    scoreTextView.setText("" + score);
                    cellValueMatrix[i][j] = 0;
                }
            }
            for (int i = 0; i < 4; i++) {
                fillCellTextView(cellTextViewMatrix[i][j], cellValueMatrix[i][j]);
                if (cellValueMatrix[i][j] == 0 && !blankPairs.contains(new Pair<>(i, j)))
                    blankPairs.add(new Pair<>(i, j));
            }
        }
        if (onSwipeDownChange)
            fillRandomNo();
        if (isGameOver()) {
            best = sharedPreferences.getLong("best", 0);
            if (score > best)
                sharedPreferences.edit().putLong("best", score).apply();
            Toast.makeText(getApplicationContext(), "Game Over", Toast.LENGTH_SHORT).show();
            isGame = false;
            saveRecord();
            btnrestart.setVisibility(View.VISIBLE);
        }
    }

    //向左
    private void onSwipeLeft() {
        if (!isGame)
            return;
        boolean onSwipeLeftChange = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                if (cellValueMatrix[i][j] == 0)
                    continue;
                int k = j - 1;
                while (k >= 0 && cellValueMatrix[i][k] == 0)
                    k--;
                if (k == -1 || (cellValueMatrix[i][k] != cellValueMatrix[i][j] && (k + 1) != j)) {
                    onSwipeLeftChange = true;
                    cellValueMatrix[i][k + 1] = cellValueMatrix[i][j];
                    blankPairs.remove(new Pair<>(i, k + 1));
                    cellValueMatrix[i][j] = 0;
                } else if (cellValueMatrix[i][k] == cellValueMatrix[i][j]) {
                    onSwipeLeftChange = true;
                    cellValueMatrix[i][k] += cellValueMatrix[i][j];
                    score += 2 * cellValueMatrix[i][j];
                    scoreTextView.setText("" + score);
                    cellValueMatrix[i][j] = 0;
                }
            }
            for (int j = 0; j < 4; j++) {
                fillCellTextView(cellTextViewMatrix[i][j], cellValueMatrix[i][j]);
                if (cellValueMatrix[i][j] == 0 && !blankPairs.contains(new Pair<>(i, j)))
                    blankPairs.add(new Pair<>(i, j));
            }
        }
        if (onSwipeLeftChange)
            fillRandomNo();
        if (isGameOver()) {
            best = sharedPreferences.getLong("best", 0);
            if (score > best)
                sharedPreferences.edit().putLong("best", score).apply();
            Toast.makeText(getApplicationContext(), "Game Over", Toast.LENGTH_SHORT).show();
            isGame = false;
            saveRecord();
            btnrestart.setVisibility(View.VISIBLE);
        }
    }

    //向右
    private void onSwipeRight() {
        if (!isGame)
            return;
        boolean onSwipeRightChange = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j >= 0; j--) {
                if (cellValueMatrix[i][j] == 0)
                    continue;
                int k = j + 1;
                while (k <= 3 && cellValueMatrix[i][k] == 0)
                    k++;
                if (k == 4 || (cellValueMatrix[i][k] != cellValueMatrix[i][j] && (k - 1) != j)) {
                    onSwipeRightChange = true;
                    cellValueMatrix[i][k - 1] = cellValueMatrix[i][j];
                    blankPairs.remove(new Pair<>(i, k - 1));
                    cellValueMatrix[i][j] = 0;
                } else if (cellValueMatrix[i][k] == cellValueMatrix[i][j]) {
                    onSwipeRightChange = true;
                    cellValueMatrix[i][k] += cellValueMatrix[i][j];
                    score += 2 * cellValueMatrix[i][j];
                    scoreTextView.setText("" + score);
                    cellValueMatrix[i][j] = 0;
                }
            }
            for (int j = 0; j < 4; j++) {
                fillCellTextView(cellTextViewMatrix[i][j], cellValueMatrix[i][j]);
                if (cellValueMatrix[i][j] == 0 && !blankPairs.contains(new Pair<>(i, j)))
                    blankPairs.add(new Pair<>(i, j));
            }
        }
        if (onSwipeRightChange)
            fillRandomNo();
        if (isGameOver()) {
            best = sharedPreferences.getLong("best", 0);
            if (score > best)
                sharedPreferences.edit().putLong("best", score).apply();
            Toast.makeText(getApplicationContext(), "Game Over", Toast.LENGTH_SHORT).show();
            isGame = false;
            saveRecord();
            btnrestart.setVisibility(View.VISIBLE);
        }
    }

    //获得滑动方向
    int getDirection(double x1, double y1, double x2, double y2) {
        if (Math.abs(y2 - y1) > Math.abs(x2 - x1)) {
            if (y2 > y1)
                return DOWN;
            else
                return UP;
        } else {
            if (x2 > x1)
                return RIGHT;
            else
                return LEFT;
        }
    }

    //屏幕手势滑动
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        int dir = getDirection(e1.getX(), e1.getY(), e2.getX(), e2.getY());
        if (dir == UP)
            onSwipeUp();
        else if (dir == DOWN)
            onSwipeDown();
        else if (dir == LEFT)
            onSwipeLeft();
        else
            onSwipeRight();
        return true;
    }

    //保存记录
    private void saveRecord() {
        String score = ((TextView) findViewById(R.id.tscore)).getText().toString();
        String best = ((TextView) findViewById(R.id.tbest)).getText().toString();

        // 插入新记录
        ContentValues record = new ContentValues();
        //book.put("name", name); // Map <- Key:Value
        record.put(ContentProviderOfRecords.SCORE,score);
        record.put(ContentProviderOfRecords.BEST, best);

        Uri uri = getContentResolver() // 执行插入操作
                .insert(ContentProviderOfRecords.CONTENT_URI, record);

        Toast.makeText(getBaseContext(), //
                "保存成功! \n" + uri.toString(), Toast.LENGTH_LONG).show();

        this.showRecordInfo("",best); // 清除内容
    }

    private void showRecordInfo(String score, String best) {
        ((TextView) findViewById(R.id.tscore)).setText(score);
        ((TextView) findViewById(R.id.tbest)).setText(best);
    }
    ////// Of No use
    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

}


