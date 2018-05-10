package com.love.gift.forchangchang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.love.gift.forchangchang.backgroundmusic.MusicServer;
import com.love.gift.forchangchang.QandA.question.q1;

public class MainActivity extends AppCompatActivity {
    public static MainActivity instance=null;
    private ImageView imageView;
    public static Intent musicIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance=this;
        musicIntent=new Intent(MainActivity.this,MusicServer.class);
        startService(musicIntent);

        Animation rotate= AnimationUtils.loadAnimation(this,R.anim.rotate);
        imageView=(ImageView)findViewById(R.id.imageView);
        imageView.setAnimation(rotate);
        imageView.startAnimation(rotate);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Intent intent=new Intent(MainActivity.this,q1.class);
        startActivity(intent);
        return true;
    }

    @Override
    protected void onDestroy() {
        instance=null;
        imageView.clearAnimation();
        imageView=null;
        super.onDestroy();
    }
}
