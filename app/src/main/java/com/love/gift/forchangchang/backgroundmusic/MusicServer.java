package com.love.gift.forchangchang.backgroundmusic;

/**
 * Created by single dog on 2018/4/28.
 */
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.widget.Toast;

import com.love.gift.forchangchang.R;

import java.io.IOException;
import java.util.ArrayList;

public class MusicServer extends Service {
    private MediaPlayer mediaPlayer;
    private ArrayList<Uri> music=new ArrayList<>();
    private int index=0;


    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onStart(final Intent intent, int startId) {
        super.onStart(intent, startId);

        addmusic();

        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this,music.get(index));
            index++;
            if(index>2)index=0;

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    try {
                        mediaPlayer.reset();
                        mediaPlayer.setDataSource(getApplication(),music.get(index));
                        mediaPlayer.prepare();
                        index++;
                        if(index>2)index=0;
                        new Handler(new Handler.Callback() {
                            @Override
                            public boolean handleMessage(Message msg) {
                                mediaPlayer.start();
                                return false;
                            }
                        }).sendEmptyMessageDelayed(0,1000);
                    }catch (IOException e){
                        e.printStackTrace();
                    }catch (NullPointerException e){
                        e.printStackTrace();
                    }
                }
            });

            mediaPlayer.start();
        }

    }

    public void addmusic(){
        Uri uri1=Uri.parse("android.resource://" + getPackageName() + "/" +R.raw.gaobaiqiqiu);
        Uri uri2=Uri.parse("android.resource://" + getPackageName() + "/" +R.raw.dengnixiake);
        Uri uri3=Uri.parse("android.resource://" + getPackageName() + "/" +R.raw.qianshiqingren);
        music.add(uri1);
        music.add(uri2);
        music.add(uri3);
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        mediaPlayer.stop();
    }
}