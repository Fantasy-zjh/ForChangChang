package com.love.gift.forchangchang.QandA.answer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import com.love.gift.forchangchang.QandA.question.q2;
import com.love.gift.forchangchang.R;
import com.love.gift.forchangchang.backgroundmusic.MusicServer;
import com.love.gift.forchangchang.snow.FallObject;
import com.love.gift.forchangchang.snow.FallingView;

/**
 * Created by single dog on 2018/4/29.
 */

public class q2_a extends AppCompatActivity {
    public static q2_a instance = null;
    private Paint snowPaint;
    private Bitmap bitmap;
    private Canvas bitmapCanvas;
    private FallObject.Builder builder;
    private FallObject fallObject;
    private FallingView fallingView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q2_a);
        instance = this;
        q2.instance.finish();
        initSnow();
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
        builder = new FallObject.Builder(getResources().getDrawable(R.drawable.ic_windmill));
        fallObject = builder
                .setSpeed(4, true)
                .setSize(50, 50, true)
                .setWind(5, true, true)
                .build();

        fallingView = (FallingView) findViewById(R.id.fallingView);
        fallingView.addFallObject(fallObject, 40);//添加40个雪球对象
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Intent intent = new Intent();
        intent.setClass(q2_a.this, com.love.gift.forchangchang.QandA.question.q3.class);
        startActivity(intent);
        return true;
    }

    @Override
    protected void onDestroy() {
        instance=null;
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
