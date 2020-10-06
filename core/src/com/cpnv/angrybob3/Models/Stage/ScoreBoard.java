package com.cpnv.angrybob3.Models.Stage;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.cpnv.angrybob3.Activities.GameActivity;

/**
 * Created by Phil & XCL
 */

public class ScoreBoard {

    private final int TARGET_SCORE = 300;
    private final int BOARD_WIDTH = 300;
    private final int LINE_HEIGHT = 40;
    private final int DEFAULT_LIFE_COUNT = 3;

    // Modifiable Constant
    private float defaultCountdown = 200;

    public static int score;
    private float countdown;
    private int lifeCount;

    private BitmapFont font;

    public ScoreBoard(int score, float countdown, int lifeCount) {
        this.score = score;
        this.defaultCountdown = countdown;
        this.countdown = defaultCountdown;
        this.lifeCount = lifeCount;
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        font.getData().setScale(2);
    }

    public void update(float dt) {
        countdown -= dt;
    }

    public boolean gameOver() {
        return ((countdown <= 0) || (score >= TARGET_SCORE) || lifeCount <= 0);
    }

    public void scoreChange(int val) {
        score += val;
        score = Math.max(0,score);
    }

    public void setLifeCount(int value) {
        lifeCount += value;
    }

    public void timerChange(int value) {
        countdown += value;
    }

    public void draw(Batch batch) {
        font.draw(batch, "Score: "+ this.score, GameActivity.WORLD_WIDTH-BOARD_WIDTH, GameActivity.WORLD_HEIGHT-LINE_HEIGHT);
        font.draw(batch, "Time remaining: " +(int)this.countdown, GameActivity.WORLD_WIDTH-BOARD_WIDTH, GameActivity.WORLD_HEIGHT-LINE_HEIGHT * 2);
        font.draw(batch, "Remaining Life: " + this.lifeCount , GameActivity.WORLD_WIDTH-BOARD_WIDTH, GameActivity.WORLD_HEIGHT-LINE_HEIGHT * 3);
    }

    public void reset() {
        score = 0;
        countdown = defaultCountdown;
        lifeCount = DEFAULT_LIFE_COUNT;
    }
}
