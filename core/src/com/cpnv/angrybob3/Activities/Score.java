package com.cpnv.angrybob3.Activities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.cpnv.angrybob3.AngryBob;
import com.cpnv.angrybob3.Models.Stage.Title;

/**
 * Created by Phil
 */

public class Score extends GameActivity{
    private Texture background;
    private Title title;
    private float splashTime = 3;
    private Sprite hat;
    private Sprite bob;
    private boolean direction = true;
    private boolean direction_bob = true;

    public Score()
    {
        super();
        background = new Texture(Gdx.files.internal("background.png"));
        //title = new Title("Angry Bob 3", 600);
        hat = new Sprite(new Texture("loadingHat.png"));
        bob = new Sprite(new Texture("bird.png"));
        hat.setBounds(camera.viewportWidth/2 - 50, camera.viewportHeight/5,100,100);
        hat.setOrigin(50,50);
        bob.setOrigin(50,50);
        bob.setBounds(camera.viewportWidth/2 - 50, camera.viewportHeight/6,100,100);
    }

    public void update() {

        // Hat animation
        hat.rotate(3);
        if (direction) {
            hat.setY(hat.getY() + 6);
        }else {
            hat.setY(hat.getY() - 3);
        }
        if (hat.getY() >= camera.viewportHeight/2.8){
            direction = false;
        }
        if (hat.getY() <= camera.viewportHeight/4.3){
            direction = true;
        }

        // Bird animation
        if (direction_bob) {
            bob.setY(bob.getY() + 3);
        }else {
            bob.setY(bob.getY() - 2);
        }
        if (bob.getY() >= camera.viewportHeight/4.3){
            direction_bob = false;
        }
        if (bob.getY() <= camera.viewportHeight/6.6){
            direction_bob = true;
        }

        if (splashTime > 0)
            splashTime -= dt;
        else
            AngryBob.getInstance().push(AngryBob.ACTIVITY.MenuSelector);
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
