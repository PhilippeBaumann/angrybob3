package com.cpnv.angrybob3.Activities;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by XCL & PBN
 */

public abstract class GameActivity extends Game implements InputProcessor {

    // General constants
    public static final int WORLD_WIDTH = 1600;
    public static final int WORLD_HEIGHT = 900;

    // Centered Screen Position
    public float x = WORLD_WIDTH / 2;
    public float y = WORLD_HEIGHT / 2;

    // Global DeltaTime (maybe move it back to individual updates
    float dt = Gdx.graphics.getDeltaTime();

    // Display tools
    protected OrthographicCamera camera;
    protected SpriteBatch spriteBatch = new SpriteBatch();

    public GameActivity()
    {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, WORLD_WIDTH, WORLD_HEIGHT);
        camera.position.set(x, y, 0);
        camera.update();
        Gdx.gl.glClearColor(0, 0, 0, 0); // Black background
    }

    /*
    public void  cameraUpdate(Vector2 target, float dt){
        Vector3 position = camera.position;
        x = camera.position.x + (target.x * dt - camera.position.x) * .2f;
        y = camera.position.y + (target.y * dt - camera.position.y) * .2f;
        camera.position.set(position);

        camera.update();
    }*/

    //public abstract void handleInput();
    //public abstract void update(float dt);

    @Override
    public void create() {

    }

    // Default renderer
    @Override
    public void render() {
        // We don't need blending for the background, disabling it should improve performance
        //spriteBatch.disableBlending();
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.end();
        //spriteBatch.enableBlending();
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
    }

    // Input Processor Methods

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
        return false;
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
