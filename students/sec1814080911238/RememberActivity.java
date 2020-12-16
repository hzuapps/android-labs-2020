package edu.hzuapps.androidlabs.sec1814080911238;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RememberActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remember_activity);

        initFruits();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }
    private void initFruits() {
        SharedPreferences sp = getSharedPreferences ("localData",MODE_PRIVATE);

        boolean flag = true;
        int num = 0;
        while (flag) {
            if(sp.contains("English" + num)) {      //判断localData中是否存在该数据，如何如果存在则通过Fruit渲染成列表
                System.out.println(sp.getString("English" + num,""));
                System.out.println( sp.getString("China" + num,""));
                Fruit apple = new Fruit(sp.getString("English" + num,""), sp.getString("China" + num,""));      // 创建 Fruit 对象
                fruitList.add(apple);       // 将 apple 传入 fruitList 渲染类中
                num ++;         //num++渲染下一个单词
            } else {
                flag =false;
            }
        }
    }

}
