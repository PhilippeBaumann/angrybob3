package com.cpnv.angrybob3.Model;

import com.badlogic.gdx.math.Vector2;

import com.cpnv.angrybob3.Activities.Play;

public final class Bird extends MovingObject {
    public enum State {
        READY,
        AIMING,
        FLYING
    }

    private static final String PICTURE_NAME = "bird.png";
    public static final int WIDTH = 60;
    public static final int HEIGHT = WIDTH;

    private State state = State.READY;
    // Remember where the aiming started
    private Vector2 aimOrigin;
    // Touch location "within" the bird, used to help keeping the dragging animation clean
    private Vector2 dragOffset;

    public Bird() {
        super(new Vector2(Play.BIRD_START_X, Play.BIRD_START_Y),
                WIDTH, HEIGHT,
                PICTURE_NAME,
                new Vector2(0, 0));
    }

    public Bird(Vector2 position, int width, int height, Vector2 speed) {
        super(position, width, height, PICTURE_NAME, speed);
    }

    public State getState() {
        return state;
    }

    public void setSpeed(Vector2 speed) {
        this.speed = speed;
    }

    public Vector2 getSpeed() {
        return speed;
    }

    public void startAim(Vector2 position) {
        if (state == State.READY) {
            aimOrigin = position.cpy();
            // Attention : copy the position before modifying it
            dragOffset = position.sub(getX(), getY());
            state = State.AIMING;
        }
    }

    public void drag(Vector2 position) {
        if (state == State.AIMING) {
            setPosition(position.x - dragOffset.x, position.y - dragOffset.y);
        }
    }

    public void launchFrom(Vector2 position) {
        if (state == State.AIMING) {
            state = State.FLYING;
            speed = aimOrigin.sub(position).scl(Play.SLINGSHOT_POWER);
        }
    }

    @Override
    public void accelerate(float dt) {
        // y = y0 - g * t
        speed.y += GRAVITY * dt;
    }
}
