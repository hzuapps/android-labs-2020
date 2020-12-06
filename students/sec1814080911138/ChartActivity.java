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
        mChart = (LineChartView) findViewById(R.id.chart);
        mData = new LineChartData();
        List<CostBean> allDate = (List<CostBean>) getIntent().getSerializableExtra("cost_list");//从数据库中查找出所有日期
        generateValues(allDate);
        generateData();
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
private void generateValues(List<CostBean> allDate) {   //将重复的数据累加，不重复的则收集到数据源中
        if(allDate!=null)
            for (int i = 0; i < allDate.size(); i++) {
            CostBean costBean = allDate.get(i);  //遍历每一个数据
            String costDate = costBean.costDate;
            int costMoney = Integer.parseInt(costBean.costMoney);
            if (!table.containsKey(costDate)) {       //不同日期则新建
                table.put(costDate, costMoney);
            } else {                         //同一日期累加
                int originMoney = table.get(costDate);
                table.put(costDate, originMoney + costMoney);
            }
        }

        }

        }


