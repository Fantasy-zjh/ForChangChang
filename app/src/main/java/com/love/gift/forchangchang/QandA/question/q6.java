package com.love.gift.forchangchang.QandA.question;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.Toast;

import com.love.gift.forchangchang.QandA.answer.q2_a;
import com.love.gift.forchangchang.QandA.answer.q5_a;
import com.love.gift.forchangchang.QandA.answer.q6_a;
import com.love.gift.forchangchang.R;
import com.love.gift.forchangchang.backgroundmusic.MusicServer;
import com.love.gift.forchangchang.puzzlegame.game.PuzzleGame;
import com.love.gift.forchangchang.puzzlegame.ui.PuzzleLayout;

/**
 * Created by single dog on 2018/4/29.
 */

public class q6 extends AppCompatActivity implements PuzzleGame.GameStateListener {
    public static q6 instance = null;
    private PuzzleLayout puzzleLayout;
    private PuzzleGame puzzleGame;
    private Chronometer chronometer;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q6);
        initView();
        initListener();
        instance=this;
        q5_a.instance.finish();
        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setAnimation(rotate);
        imageView.startAnimation(rotate);
    }

    private void initView() {
        puzzleLayout = (PuzzleLayout) findViewById(R.id.puzzleLayout);
        puzzleGame = new PuzzleGame(this, puzzleLayout);
        puzzleLayout.changeRes(R.drawable.threemonths);

        chronometer = (Chronometer) findViewById(R.id.chronometer);
        chronometer.setFormat("%s");
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();
    }

    private void initListener() {
        puzzleGame.addGameStateListener(this);
    }


    @Override
    public void gameSuccess(int level) {
        Toast toast = Toast.makeText(this, "原来3个月这么快", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        final Intent intent = new Intent(q6.this, q6_a.class);
        new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                startActivity(intent);
                return false;
            }
        }).sendEmptyMessageDelayed(0, 2000);
    }

    @Override
    protected void onDestroy() {
        instance=null;
        puzzleLayout.clear();
        puzzleLayout=null;
        puzzleGame=null;
        chronometer=null;
        imageView.clearAnimation();
        imageView=null;
        super.onDestroy();
    }
}
