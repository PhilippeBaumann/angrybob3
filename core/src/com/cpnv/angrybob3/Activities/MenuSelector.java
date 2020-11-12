package com.cpnv.angrybob3.Activities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.cpnv.angrybob3.AngryBob;
import com.cpnv.angrybob3.Models.Stage.Title;

/**
 * Created by Phil
 */

public class MenuSelector extends GameActivity{
    private Texture background;
    private Title title;
    private Sprite hat;
    private Sprite bob;
    private boolean direction = true;
    private boolean direction_bob = true;

    public MenuSelector()
    {
        super();
        background = new Texture(Gdx.files.internal("background.png"));
        title = new Title("Menu", WORLD_HEIGHT);
        hat = new Sprite(new Texture("loadingHat.png"));
        bob = new Sprite(new Texture("bird.png"));
        hat.setBounds(camera.viewportWidth/2 - 50, 180,100,100);
        hat.setOrigin(50,50);
        bob.setBounds(camera.viewportWidth/2 - 50, 136,100,100);
        bob.setOrigin(50,50);
    }

    public void update() {

        launchScene("play");

        // To go to the settings
        //AngryBob.gameActivityManager.push(new GameOver());

        // To Close Game
        //Gdx.app.exit();
    }

    private void launchScene(String scene){
        // Settings X
        AngryBob.getInstance().push(AngryBob.ACTIVITY.Play);
    }

    @Override
    public void render() {
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);
        title.draw(spriteBatch);
        bob.draw(spriteBatch);
        hat.draw(spriteBatch);
        spriteBatch.end();
    }
}
