package com.cpnv.angrybob3.Models.Activities;

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
