package com.cpnv.angrybob3.Models.Stage;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Phil & XCL
 */

public final class Bubble {

    private static final String PICNAME = "bubble.png";
    private static final int WIDTH = 260;
    private static final int HEIGHT = 160;
    private static final int BUBBLE_OFFSET = 60; // to center the spike on the head
    private static final int TEXT_OFFSET_X = 38; // to place the text inside the bubble
    private static final int TEXT_OFFSET_Y = 110;

    private String message;
    private float timeLeft; // life time in seconds
    private Sprite sprite;
    private BitmapFont font;

    /**
     * Bubble will appear for the pig located at x,y
     *
     * @param x
     * @param y
     * @param message
     * @param duration
     */
    public Bubble(float x, float y, String message, int duration) {

        // Propriety assignation
        this.message = message;
        this.timeLeft = duration;

        // Sprite Changes
        sprite = new Sprite(new Texture(PICNAME));
        if (x <= 200){
            sprite.flip(true, false);
            sprite.setBounds(x, y+60 - 20, WIDTH, HEIGHT);
        }else {
            sprite.setBounds(x-WIDTH/2-BUBBLE_OFFSET, y+60 - 20, WIDTH, HEIGHT);
        }

        // Font Manipulation
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        if (message.length() <= 12) font.getData().setScale(2f);
        else font.getData().setScale(1.2f);
    }

    public void ageAway(float dt)
    {
        timeLeft -= dt;
    }

    public boolean isDead() {
        return timeLeft <= 0;
    }

    public void draw(Batch batch)
    {
        sprite.draw(batch);
        font.draw(batch, message, sprite.getX()+TEXT_OFFSET_X, sprite.getY()+TEXT_OFFSET_Y);
    }
}
