package com.love.gift.forchangchang.puzzlegame.game;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.love.gift.forchangchang.R;
import com.love.gift.forchangchang.puzzlegame.ui.PuzzleLayout;

/**
 * Created by single dog on 2018/4/29.
 */

public class PuzzleGame implements PuzzleLayout.SuccessListener {

    private PuzzleLayout puzzleLayou;
    private GameStateListener stateListener;
    private Context context;

    public void addGameStateListener(GameStateListener stateListener) {
        this.stateListener = stateListener;
    }

    public PuzzleGame(@NonNull Context context, @NonNull PuzzleLayout puzzleLayout) {
        this.context = context.getApplicationContext();
        this.puzzleLayou = puzzleLayout;
        puzzleLayou.addSuccessListener(this);
    }

    private boolean checkNull() {
        return puzzleLayou == null;
    }



    public int getLevel() {
        if (checkNull()) {
            return 0;
        }
        int count = puzzleLayou.getCount();
        return count - 3 + 1;
    }

    @Override
    public void success() {
        if (stateListener != null) {
            stateListener.gameSuccess(getLevel());
        }
    }

    public interface GameStateListener {
        public void gameSuccess(int level);
    }
}