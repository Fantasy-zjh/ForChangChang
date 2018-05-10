package com.love.gift.forchangchang.QandA.question;

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.love.gift.forchangchang.MySensorEventListener.MySensorEventListener;
import com.love.gift.forchangchang.MySensorEventListener.Shakeable;
import com.love.gift.forchangchang.QandA.answer.q2_a;
import com.love.gift.forchangchang.R;
import com.love.gift.forchangchang.backgroundmusic.MusicServer;

import java.security.Provider;


/**
 * Created by single dog on 2018/4/29.
 */

public class q3 extends AppCompatActivity implements Shakeable {
    public static q3 instance = null;
    private SensorManager sensorManager;
    private MySensorEventListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q3);
        instance = this;
        q2_a.instance.finish();
//        sensorManager = (SensorManager) this.getSystemService(Service.SENSOR_SERVICE);
//        listener = new MySensorEventListener(this);
//        sensorManager.registerListener(listener, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            Intent intent = new Intent(q3.this, com.love.gift.forchangchang.QandA.answer.q3_a.class);
            startActivity(intent);
        }
        return false;
    }

    @Override
    public void onShake(Object... objs) {
        Intent intent = new Intent(q3.this, com.love.gift.forchangchang.QandA.answer.q3_a.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        instance = null;
//        sensorManager.unregisterListener(listener);
        sensorManager = null;
        listener = null;
        super.onDestroy();
    }
}
