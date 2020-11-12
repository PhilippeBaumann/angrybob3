package com.cpnv.angrybob3.Activities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import com.cpnv.angrybob3.AngryBob;
import com.cpnv.angrybob3.Models.Stage.Title;

/**
 * Created by Phil
 */

public class Pause extends GameActivity {

    private Title title;

    public Pause()
    {
        //title = new Title("Paused", 600);
    }

    @Override
    public void render() {
        super.render();

        spriteBatch.begin();
        title.draw(spriteBatch);
        spriteBatch.end();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        AngryBob.getInstance().pop();
        return true;
    }
}