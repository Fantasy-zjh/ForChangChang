package com.love.gift.forchangchang;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by single dog on 2018/4/29.
 */

public class FinalActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_talk);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(MainActivity.musicIntent);
//                finish();
//                System.exit(0);
            }
        });
    }

    @Override
    protected void onDestroy() {
        button = null;
        super.onDestroy();
    }
}
