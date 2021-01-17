package edu.hzuapps.androidlabs.sec1814080911102.fruit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import edu.hzuapps.androidlabs.sec1814080911102.R;

public class FruitAdapter extends ArrayAdapter {
    private final int resourceId;

    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit = (Fruit) getItem(position); // 获取当前项的Fruit实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);//实例化一个对象
        TextView fruitName = (TextView) view.findViewById(R.id.fruit_text);//获取该布局内的文本视图
        fruitName.setText(fruit.getText());//为文本视图设置文本内容
        return view;
    }
}
