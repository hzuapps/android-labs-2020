package edu.hzuapps.androidlabs.myView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import edu.hzuapps.androidlabs.R;

public class ReadFragment extends Fragment {
    View view;
//    书本position
    int position;
//    文本区域
    TextView textView;
//    字高度
    int textHeight;
//    文字上下行间距
    float textPadding;
//    页面高度
    int pagerHeight;
//    一个页面最大的行数
    int pagerNum;
//    当前行数
    int num;
//    书本实例
    ArrayList<ArrayList<Integer>> chapterArray;
    Info info;
    ReadFragment that;
//    加载界面设置
    CardView loadingCardView;
    TextView loadingTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = (ViewGroup) inflater.inflate( R.layout.read_item_fragment, container, false);

//        变量初始化
        textView = view.findViewById(R.id.readTextView);
        loadingCardView = view.findViewById(R.id.loadingCardView);
        loadingTextView = view.findViewById(R.id.loadingTextView);
        info = (Info) getArguments().getSerializable("info");
        position = info.position;
        chapterArray = info.chapter;
        that = this;


//        判断是否为初始化处理
        if (info.initState){
            textView.setText(info.text);
        }else {
//            设置加载动画
            loadingCardView.setVisibility(View.VISIBLE);
            int len = position%30;
            int perce = position;
            if(len<15)
                loadingTextView.setText("加载中\n★\n"+perce);
            else
                loadingTextView.setText("加载中\n★★★\n"+perce);

//            测量字高和行间距
            textView.measure(0, 0);
            textView.setText(".");
            textHeight = textView.getMeasuredHeight() + 6;
            textPadding = textView.getLineSpacingExtra();

            textView.setText(info.text);
        }
        return this.view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
//        初始化判断
        if (!info.initState) {
//        计算页数，把数据赋值到book数组，数据结构为[章节，第一页偏移量，第二页偏移量，。。。]，从0开始
            textView.post(new Runnable() {
                @Override
                public void run() {
//                获得textview高度，计算一页能显示多少行
                    pagerHeight = textView.getHeight();
                    pagerNum = (int) ((pagerHeight + textPadding) / (textHeight + textPadding));
//                一章实际行数
                    num = textView.getLineCount();
//                计算添加到数组
                    int tem1 = 1;
                    ArrayList<Integer> temA = new ArrayList<Integer>();
                    if (position==0){
//                        添加第一章页数
                        chapterArray.get(position).add(0);
                    }else {
//                        添加非第一章页数
                        chapterArray.get(position).add(chapterArray.get(position-1).get(1)+(chapterArray.get(position-1).size()-2));
                    }
                    while (num > tem1 * pagerNum) {
                        textView.getLayout().getLineStart(tem1 * pagerNum);
                        chapterArray.get(position).add(textView.getLayout().getLineEnd((pagerNum * tem1) - 1));
                        tem1++;
                    }
                    chapterArray.get(position).add(textView.getLayout().getLineEnd(num - 1));
                }
            });
        }
    }
}
