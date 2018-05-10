package com.love.gift.forchangchang.QandA.question;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.love.gift.forchangchang.MainActivity;
import com.love.gift.forchangchang.QandA.answer.q1_a;
import com.love.gift.forchangchang.R;
import com.love.gift.forchangchang.backgroundmusic.MusicServer;

/**
 * Created by single dog on 2018/4/28.
 */

public class q1 extends AppCompatActivity implements View.OnClickListener{
    public static q1 instance=null;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q1);

        instance=this;
        MainActivity.instance.finish();

        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button3:
                Toast toast= Toast.makeText(getApplicationContext(),"噫，还不错",Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                new Handler(new Handler.Callback() {
                    @Override
                    public boolean handleMessage(Message msg) {
                        Intent intent=new Intent(q1.this,q1_a.class);
                        startActivity(intent);
                        return false;
                    }
                }).sendEmptyMessageDelayed(0,2000);
                break;
            case R.id.button1:
            case R.id.button2:
            case R.id.button4:
                Toast toast2= Toast.makeText(getApplicationContext(),"坏畅畅！",Toast.LENGTH_SHORT);
                toast2.setGravity(Gravity.CENTER,0,0);
                toast2.show();
        }
    }

    @Override
    protected void onDestroy() {
        instance=null;
        button1=null;
        button2=null;
        button3=null;
        button4=null;
        super.onDestroy();
    }
}
