package com.example.myapplication4;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

public class SaveLogin {
    public static boolean saveUserInfo(Context context,String account, String password){
        //获取sharedPreferences对象
        SharedPreferences sp = context.getSharedPreferences("data",Context.MODE_PRIVATE);
        //获取eitor对象的引用
        SharedPreferences.Editor editor = sp.edit();
        //将获取的数据放入文件中
        editor.putString("account",account);
        editor.putString("password",password);
        //提交数据
        editor.commit();
        return true;

    }
    public static Map<String,String> getUserInfo(Context context){
        SharedPreferences sp=context.getSharedPreferences("data",Context.MODE_PRIVATE);
        String account= sp.getString("account",null);
        String password=sp.getString("password",null);
        Map<String,String>myMap=new HashMap<>();
        myMap.put("account",account);
        myMap.put("password",password);
        return myMap;
    }




}
