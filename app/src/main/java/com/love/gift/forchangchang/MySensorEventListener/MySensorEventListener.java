package com.love.gift.forchangchang.MySensorEventListener;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

import com.love.gift.forchangchang.QandA.question.q3;

/**
 * Created by single dog on 2018/4/29.
 */

public class MySensorEventListener implements SensorEventListener{
    private Shakeable mActivity;

    public MySensorEventListener(Shakeable mActivity){
        this.mActivity = mActivity;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int sensorType=event.sensor.getType();
        float[] values=event.values;

        if(sensorType== Sensor.TYPE_ACCELEROMETER){
            if((Math.abs(values[0]) > 17 || Math.abs(values[1]) > 17 || Math.abs(values[2]) > 17)){
                mActivity.onShake(values);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
