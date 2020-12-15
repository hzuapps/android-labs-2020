package edu.hzuapps.androidlabs.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import edu.hzuapps.androidlabs.entity.User;

public class JsonParse {
    public static User getUser(String json){
        // 使用Gson解析JSON数据
        Gson gson = new Gson();
        // 创建一个匿名子类对象
        Type listType = new TypeToken<User>(){}.getType();
        // 把获取的信息存到User中
        User user = gson.fromJson(json, listType);
        return user;
    }
}
