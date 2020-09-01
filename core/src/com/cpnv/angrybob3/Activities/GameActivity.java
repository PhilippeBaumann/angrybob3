package com.cpnv.angrybob3.Activities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Phil & XCL
 */

public abstract class GameActivity {

    // General constants
    public static final int WORLD_WIDTH = 1600;
    public static final int WORLD_HEIGHT = 900;

    // Default Position
    public float x = WORLD_WIDTH / 2;
    public float y = WORLD_HEIGHT / 2;

    // Display tools
    protected OrthographicCamera camera;
    protected SpriteBatch spriteBatch = new SpriteBatch();

    protected GameActivity()
    {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, WORLD_WIDTH, WORLD_HEIGHT);
        camera.position.set(x, y, 0);
        camera.update();
        spriteBatch.setProjectionMatrix(camera.combined);
        Gdx.gl.glClearColor(0, 0, 0, 0); // Black background
    }

    public void  cameraUpdate(Vector2 target, float dt){
        Vector3 position = camera.position;
        x = camera.position.x + (target.x * dt - camera.position.x) * .2f;
        y = camera.position.y + (target.y * dt - camera.position.y) * .2f;
        camera.position.set(position);

        camera.update();
    }

    public abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render();
}
