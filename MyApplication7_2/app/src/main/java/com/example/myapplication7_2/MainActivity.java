package com.example.myapplication7_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView duck1, duck2, duck3;
    ImageButton horn;
    TextView content_left;
    MyBroadCastReceiver1 myBroadCastReceiver1;
    MyBroadCastReceiver2 myBroadCastReceiver2;
    MyBroadCastReceiver3 myBroadCastReceiver3;
    private int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        register_Receiver();
    }

    private void init() {
        duck1 = findViewById(R.id.duck_1);
        duck2 = findViewById(R.id.duck_2);
        duck3 = findViewById(R.id.duck_3);
        horn = findViewById(R.id.horn);
        content_left = findViewById(R.id.content_left);
        horn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                content_left.setVisibility(View.VISIBLE);
                horn.setClickable(false);
                Intent intent = new Intent();
                intent.setAction("Count_Duck");
                sendOrderedBroadcast(intent,null);
            }
        });
    }

    private void register_Receiver() {
        IntentFilter intentFilter1=new IntentFilter();
        intentFilter1.addAction("Count_Duck");
        intentFilter1.setPriority(1000);
//        intentFilter1.setPriority(800);
        myBroadCastReceiver1=new MyBroadCastReceiver1();
        registerReceiver(myBroadCastReceiver1,intentFilter1, Context.RECEIVER_NOT_EXPORTED);
        IntentFilter intentFilter2=new IntentFilter();
        intentFilter2.addAction("Count_Duck");
        intentFilter2.setPriority(800);
//        intentFilter2.setPriority(1000);
        myBroadCastReceiver2=new MyBroadCastReceiver2();
        registerReceiver(myBroadCastReceiver2,intentFilter2, Context.RECEIVER_NOT_EXPORTED);
        IntentFilter intentFilter3=new IntentFilter();
        intentFilter3.addAction("Count_Duck");
        intentFilter3.setPriority(600);
        myBroadCastReceiver3=new MyBroadCastReceiver3();
        registerReceiver(myBroadCastReceiver3,intentFilter3, Context.RECEIVER_NOT_EXPORTED);


    }

    class MyBroadCastReceiver1 extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            num=num+1;
            duck1.setVisibility(View.VISIBLE);
            duck1.setText(num+"");
            Log.i("duck1","我收到了广播。");
            stop();
        }
    }

    class MyBroadCastReceiver2 extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            num=num+1;
            duck2.setVisibility(View.VISIBLE);
            duck2.setText(num+"");
            Log.i("duck2","我收到了广播。");
//            abortBroadcast();
//            Log.i("duck2","我拦截了广播。");
            stop();
        }
    }

    class MyBroadCastReceiver3 extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            num=num+1;
            duck3.setVisibility(View.VISIBLE);
            duck3.setText(String.valueOf(num));
            Log.i("duck3","我收到了广播。");
            stop();
        }
    }

    private void stop() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myBroadCastReceiver1);
        unregisterReceiver(myBroadCastReceiver2);
        unregisterReceiver(myBroadCastReceiver3);
    }
}