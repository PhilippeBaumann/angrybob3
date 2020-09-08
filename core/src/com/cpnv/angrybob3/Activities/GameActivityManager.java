package com.cpnv.angrybob3.Activities;

import com.badlogic.gdx.Gdx;
import com.cpnv.angrybob3.AngryBob;

import java.util.Stack;

/**
 * Created by Phil & XCL
 */

public class GameActivityManager {
    private Stack<GameActivity> gameActivities;

    public GameActivityManager() {
        gameActivities = new Stack<GameActivity>();
    }

    public void push(GameActivity gameActivity) {
        gameActivities.push(gameActivity);
    }

    public void pop() {
        gameActivities.pop();
    }

    public void popSingleTarget(GameActivity gameActivity){
        gameActivities.remove(gameActivity);
    }

    public void handleInput() {
        gameActivities.peek().handleInput();
    }

    public void update(float dt) {
        gameActivities.peek().update(dt);
    }

    public void render() {
        gameActivities.peek().render();
    }
}
