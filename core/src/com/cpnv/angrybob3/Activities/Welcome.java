package com.cpnv.angrybob3.Activities;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cpnv.angrybob3.AngryBob;
import com.cpnv.angrybob3.Models.Stage.Title;

/**
 * Created by Phil


public class Welcome extends GameActivity implements InputProcessor {
    private Texture background;
    private Title title;
    private float splashTime = 3;
    private Sprite hat;
    private Sprite bob;
    private boolean direction = true;
    private boolean direction_bob = true;

    public Welcome()
    {
        super();
        background = new Texture(Gdx.files.internal("background.png"));
        title = new Title("Angry Bob 3", 600);
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

 */

public class Welcome extends Game implements InputProcessor {

    public static final float WORLD_WIDTH = 1600;
    public static final float WORLD_HEIGHT = 900;

    private SpriteBatch batch;
    private Texture background;
    private BitmapFont title;

    private OrthographicCamera camera;

    public Welcome() {

        batch = new SpriteBatch();
        background = new Texture(Gdx.files.internal("background.png"));

        camera = new OrthographicCamera();
        camera.setToOrtho(false, WORLD_WIDTH, WORLD_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        camera.update();

        title= new BitmapFont();
        title.setColor(Color.ROYAL);
        title.getData().setScale(6);

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void create() {

    }

    public void update() {
        float dt = Gdx.graphics.getDeltaTime();
    }

    @Override
    public void render() {
        update();
        batch.begin();
        batch.setProjectionMatrix(camera.combined);
        batch.draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);
        title.draw(batch,"Hello",WORLD_WIDTH/2,WORLD_HEIGHT/2);
        batch.end();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        AngryBob.getInstance().push(AngryBob.ACTIVITY.Play);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}