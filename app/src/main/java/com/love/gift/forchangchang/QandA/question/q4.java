package com.love.gift.forchangchang.QandA.question;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.love.gift.forchangchang.QandA.answer.q1_a;
import com.love.gift.forchangchang.QandA.answer.q3_a;
import com.love.gift.forchangchang.QandA.answer.q4_a;
import com.love.gift.forchangchang.R;
import com.love.gift.forchangchang.backgroundmusic.MusicServer;
import com.love.gift.forchangchang.snow.FallObject;
import com.love.gift.forchangchang.snow.FallingView;

/**
 * Created by single dog on 2018/4/29.
 */

public class q4 extends AppCompatActivity implements View.OnClickListener {
    public static q4 instance = null;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    private Paint snowPaint;
    private Bitmap bitmap;
    private Canvas bitmapCanvas;
    private FallObject.Builder builder;
    private FallObject fallObject;
    private FallingView fallingView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q4);
        initSnow();
        instance = this;
        q3_a.instance.finish();
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                Toast toast = Toast.makeText(getApplicationContext(), "那天咱俩第一次骑车(^_^)", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                new Handler(new Handler.Callback() {
                    @Override
                    public boolean handleMessage(Message msg) {
                        Intent intent = new Intent(q4.this, q4_a.class);
                        startActivity(intent);
                        return false;
                    }
                }).sendEmptyMessageDelayed(0, 2000);
                break;
            case R.id.button2:
            case R.id.button3:
            case R.id.button4:
                Toast toast2 = Toast.makeText(getApplicationContext(), "不对哦！", Toast.LENGTH_SHORT);
                toast2.setGravity(Gravity.CENTER, 0, 0);
                toast2.show();
        }
    }

    private void initSnow() {
        //绘制雪球bitmap
        snowPaint = new Paint();
        snowPaint.setColor(Color.WHITE);
        snowPaint.setStyle(Paint.Style.FILL);
        bitmap = Bitmap.createBitmap(50, 50, Bitmap.Config.ARGB_8888);
        bitmapCanvas = new Canvas(bitmap);
        bitmapCanvas.drawCircle(25, 25, 25, snowPaint);

        //初始化一个雪球样式的fallObject
        builder = new FallObject.Builder(getResources().getDrawable(R.drawable.ic_snow));
        fallObject = builder
                .setSpeed(3, true)
                .setSize(50, 50, true)
                .setWind(5, true, true)
                .build();

        fallingView = (FallingView) findViewById(R.id.fallingView);
        fallingView.addFallObject(fallObject, 40);//添加50个雪球对象
    }

    @Override
    protected void onDestroy() {
        instance=null;
        button1 = null;
        button2 = null;
        button3 = null;
        button4 = null;
        snowPaint = null;
        bitmap = null;
        bitmapCanvas = null;
        builder = null;
        fallObject = null;
        fallingView.clearBitmaps();
        fallingView = null;
        super.onDestroy();
    }
}
