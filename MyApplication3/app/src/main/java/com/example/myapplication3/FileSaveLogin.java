package com.example.myapplication3;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileSaveLogin {
    public static boolean saveUserInfo(Context context, String account, String password) {
        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput("data.text", Context.MODE_PRIVATE);
            fos.write((account + ":" + password).getBytes());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Map<String, String> getUerInfo(Context context) {
        FileInputStream fis = null;

        String content = "";
        try {
            fis = context.openFileInput("data.txt");
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            content = new String(buffer);
            Map<String, String> myMap = new HashMap<>();
            String[] infos = content.split(":");
            myMap.put("account", infos[0]);
            myMap.put("password", infos[1]);
            return myMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }



}