package edu.hzuapps.androidlabs.Sec1814080911138;

/* 首先我们先往项目里添加一个画折线图需要的依赖包hellocharts-library-1.5.8.jar */
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.ChartData;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.Chart;
import lecho.lib.hellocharts.view.LineChartView;
public class ChartActivity extends AppCompatActivity {

}
    private LineChartView mChart;
    private Map<String,Integer> table = new TreeMap<>();  //日期排序
    private LineChartData mData = new LineChartData();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
    }
}
    private void generateData(){    //设置折线图的线颜色等属性
        List<Line> lines=new ArrayList<>();
        List<PointValue> values=new ArrayList<>();
        int indexX=0;
        for(Integer value:table.values()){
        values.add(new PointValue(indexX,value));
        indexX++;
        Line  line = new Line(values);
        line.setColor(ChartUtils.COLOR_GREEN);
        line.setShape(ValueShape.CIRCLE);
        line.setPointColor(ChartUtils.COLOR_ORANGE);
        lines.add(line);
        mData = new LineChartData(lines);
        mData.setLines(lines);
        mChart.setLineChartData(mData);
        }
}