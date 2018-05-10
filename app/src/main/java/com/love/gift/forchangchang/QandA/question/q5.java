package com.love.gift.forchangchang.QandA.question;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.ViewDebug;
import android.widget.TextView;

import com.love.gift.forchangchang.QandA.answer.q4_a;
import com.love.gift.forchangchang.R;

/**
 * Created by single dog on 2018/4/29.
 */

public class q5 extends AppCompatActivity {
    public static q5 instance=null;
    private int num=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q5);
        instance=this;
        q4_a.instance.finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            num++;
            if(num==20){
                Intent intent=new Intent(q5.this,com.love.gift.forchangchang.QandA.answer.q5_a.class);
                startActivity(intent);
            }
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        instance=null;
        super.onDestroy();
    }
}
