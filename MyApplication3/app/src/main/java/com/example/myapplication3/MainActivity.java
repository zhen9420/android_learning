package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private EditText et_account;
    private EditText et_password;
    private Button login;
    private TextView tv_a,tv_p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_account = findViewById(R.id.et1);
        et_password = findViewById(R.id.et2);
        login = findViewById(R.id.btn);
        tv_a = findViewById(R.id.tv_account);
        tv_p = findViewById(R.id.tv_password);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = et_account.getText().toString();
                String password = et_password.getText().toString();
                if(account.isEmpty()){
                    Toast.makeText(MainActivity.this,"请输入账号",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(password.isEmpty()){
                    Toast.makeText(MainActivity.this,"请输入密码",Toast.LENGTH_SHORT).show();
                    return;
                }
                boolean isSaveSuccess=FileSaveLogin.saveUserInfo(MainActivity.this,account,password);
                if (isSaveSuccess){
                    Toast.makeText(MainActivity.this,"保存成功",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"保存失败",Toast.LENGTH_SHORT).show();
                }
                Map<String,String> userInfo=FileSaveLogin.getUerInfo(MainActivity.this);
                if(userInfo!=null){
                    tv_a.setText("输入的账号为："+userInfo.get("account"));
                    tv_p.setText("输入的密码为："+userInfo.get("password"));
                }
                else{
                    Toast.makeText(MainActivity.this,"保存信息为空",Toast.LENGTH_SHORT).show();
                }



            }
        });
    }
}