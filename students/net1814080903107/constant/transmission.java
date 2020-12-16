package com.example.thefirst.constant;

public interface transmission {
    String sIP="10.101.144.99";//"10.101.144.99"
    int sPort=20002;//serverPort
    String imageFrom="http://10.101.144.99/Bitmap/";//图片父链接
    //服务类型，1开始
    int SELECT_STORE=2;//搜索商店
    int UPDATE_VIEW=1;//更新视图
    int UPDATE_FOOD=3;
    //1000开始
    int IMAGEVIEW=1000;
}
