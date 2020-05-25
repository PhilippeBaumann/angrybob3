package com.cpnv.angrybob3.Models.Activities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.cpnv.angrybob3.AngryBob;
import com.cpnv.angrybob3.Models.Stage.ScoreBoard;
import com.cpnv.angrybob3.Models.Stage.Title;

/**
 * Created by Phil & XCL
 */

public class GameOver extends GameActivity {

    private Texture background;
    private Title title;

    public GameOver()
    {
        super();
        background = new Texture(Gdx.files.internal("background.png"));
        title = new Title("Game Over\n score: "+ ScoreBoard.score);
    }


    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched())
        {
            AngryBob.gameActivityManager.pop(); // game over
            AngryBob.gameActivityManager.pop(); // play
        }
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render() {
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);
        title.draw(spriteBatch);
        spriteBatch.end();
    }
}
