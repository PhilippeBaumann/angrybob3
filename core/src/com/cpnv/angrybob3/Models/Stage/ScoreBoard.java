package com.cpnv.angrybob3.Models.Stage;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.cpnv.angrybob3.Models.Activities.GameActivity;

/**
 * Created by Phil & XCL
 */

public class ScoreBoard {

    private final int TARGET_SCORE = 100;
    private final int BOARD_WIDTH = 300;
    private final int LINE_HEIGHT = 40;

    public static int score;
    private float countdown;
    private BitmapFont font;

    public ScoreBoard(int score, float countdown) {
        this.score = score;
        this.countdown = countdown;
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        font.getData().setScale(2);
    }

    public void update(float dt) {
        countdown -= dt;
    }

    public boolean gameOver() {
        return ((countdown <= 0) || (score <= 0) || (score >= TARGET_SCORE));
    }

    public void scoreChange(int val) {
        score += val;
        score = Math.max(0,score);
    }

    public void draw(Batch batch) {
        font.draw(batch, "Score: "+this.score, GameActivity.WORLD_WIDTH-BOARD_WIDTH, GameActivity.WORLD_HEIGHT-LINE_HEIGHT);
        font.draw(batch, "Time remaining: " +(int)this.countdown, GameActivity.WORLD_WIDTH-BOARD_WIDTH, GameActivity.WORLD_HEIGHT-LINE_HEIGHT * 2);
    }
}
