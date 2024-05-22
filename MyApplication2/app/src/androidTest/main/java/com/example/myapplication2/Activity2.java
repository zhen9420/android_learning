package com.example.myapplication2;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;

import android.view.View;

import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Activity2 extends AppCompatActivity {
    protected int bamboo=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        List<ImageButton> imts=new ArrayList<ImageButton>();
        Resources res =getResources();
        for(int i=1;i<=6;i++){
            int id=res.getIdentifier("im_btn_"+i,"id",getPackageName());
            ImageButton zhuzi=findViewById(id);
            imts.add(zhuzi);
        }
        for (ImageButton imageButton:imts){
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bamboo++;
                    imageButton.setBackground(null);
                }
            });
            ImageButton back=findViewById(R.id.im_btn_7);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent();
                    intent.putExtra("bamboo_number",bamboo);
                    setResult(1,intent);
                    finish();
                }
            });
        }
    }
}
