package com.cpnv.angrybob3.Models.Activities;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.cpnv.angrybob3.AngryBob;
import com.cpnv.angrybob3.Models.Data.Word;
import com.cpnv.angrybob3.Models.Stage.Bird;
import com.cpnv.angrybob3.Models.Stage.Board;
import com.cpnv.angrybob3.Models.Stage.Bubble;
import com.cpnv.angrybob3.Models.Stage.PhysicalObject;
import com.cpnv.angrybob3.Models.Stage.Pig;
import com.cpnv.angrybob3.Models.Stage.RubberBand;
import com.cpnv.angrybob3.Models.Stage.Scenery;
import com.cpnv.angrybob3.Models.Stage.ScoreBoard;
import com.cpnv.angrybob3.Models.Stage.TNT;
import com.cpnv.angrybob3.Models.Stage.Wasp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Phil & XCL
 */

public class Play extends GameActivity implements InputProcessor {

    public static final int FLOOR_HEIGHT = 120;
    private static final int SLINGSHOT_WIDTH = 75;
    private static final int SLINGSHOT_HEIGHT = 225;
    private static final int SLINGSHOT_OFFSET = 100;
    public static final int TWEETY_START_X = SLINGSHOT_OFFSET + (SLINGSHOT_WIDTH - Bird.WIDTH) / 2;
    public static final int TWEETY_START_Y = FLOOR_HEIGHT + SLINGSHOT_HEIGHT - Bird.HEIGHT;
    private static final float ELASTICITY = 6f;
    private final int TNT_PENALTY = 5;
    private final int SCORE_BUMP_SUCCESS = 7;
    private final int SCORE_BUMP_FAIL = 1;

    private Scenery scenery;
    private Bird tweety;
    private Wasp waspy;
    private ArrayList<Bubble> babble;
    private Texture background;
    private Texture slingshot1;
    private Texture slingshot2;
    private Board board;
    private ScoreBoard scoreBoard;
    private RubberBand rubberBand1;
    private RubberBand rubberBand2;
    private Queue<Touch> actions;

    // Only One Lucky One Pig
    private boolean luckyOne;
    boolean luckyOneCreated = false;

    public Play() {
        super();

        babble = new ArrayList<Bubble>();

        background = new Texture(Gdx.files.internal("background.png"));
        slingshot1 = new Texture(Gdx.files.internal("slingshot.png"));
        slingshot2 = new Texture(Gdx.files.internal("slingshotFront.png"));

        tweety = new Bird();
        tweety.freeze();
        rubberBand1 = new RubberBand();
        rubberBand2 = new RubberBand();

        waspy = new Wasp(new Vector2(WORLD_WIDTH / 2, WORLD_HEIGHT / 2), new Vector2(20, 20));
        scenery = new Scenery();
        for (int i = 5; i < WORLD_WIDTH / 50; i++) {
            try {
                scenery.addElement(new PhysicalObject(new Vector2(i * 50, FLOOR_HEIGHT), 50, 50, "block.png"));
            } catch (Exception e) {
                Gdx.app.log("ANGRY_BOB", "Could not add Wood Box to scene");
            }
        }
        for (int i = 0; i < 2; i++) {
            try {
                scenery.addElement(new TNT(new Vector2(AngryBob.random.nextInt(WORLD_WIDTH * 2 / 3) + WORLD_WIDTH / 3, FLOOR_HEIGHT + 50), TNT_PENALTY));
            } catch (Exception e) {
                Gdx.app.log("ANGRY_BOB", "Could not add TNT Barrel to scene");
            }
        }
        for (int i = 0; i < 8; i++) {
            try {
                if (luckyOneCreated){
                    luckyOne = false;
                }else {
                    luckyOne = AngryBob.random.nextBoolean();
                }
                scenery.addElement(new Pig(new Vector2(AngryBob.random.nextInt(WORLD_WIDTH * 2 / 3) + WORLD_WIDTH / 3, FLOOR_HEIGHT + 50) , new Word(1, "bob 123", "bobbybob"), luckyOne));
                if (luckyOne) {luckyOneCreated = true;}

            } catch (Exception e) {
                Gdx.app.log("ANGRY_BOB", "Could not add Pig to scene" + e);
            }
        }

        board = new Board(scenery.pickAWord()); // Put one word from a pig on the board
        scoreBoard = new ScoreBoard(70, 240);

        Gdx.input.setInputProcessor(this);
        actions = new LinkedList<Touch>(); // User inputs are queued in here when events fire, handleInput processes them

        // Display Bob Message
        babble.add(new Bubble(tweety.getPosition().x, tweety.getPosition().y, "Let's Get My Hat Back ! \nLos El Jalapenos!", 6));
    }

    public void handleInput() {
        Touch action;
        while ((action = actions.poll()) != null) {
            switch (action.type) {
                case down:
                    if (tweety.isFrozen() && action.point.x < TWEETY_START_X && action.point.y >= FLOOR_HEIGHT && action.point.y < TWEETY_START_Y) {
                        tweety.setX(action.point.x);
                        tweety.setY(action.point.y);
                    }

                    // Pig Clicking
                    Pig piggy = scenery.pigTouched(action.point.x, action.point.y);
                    if (piggy != null)
                        babble.add(new Bubble(piggy.getPosition().x, piggy.getPosition().y, piggy.getWordValue(), 2));
                    break;
                case up:
                    if (tweety.isFrozen() && action.point.x < TWEETY_START_X && action.point.y >= FLOOR_HEIGHT && action.point.y < TWEETY_START_Y) {
                        tweety.setSpeed(new Vector2(100 + (TWEETY_START_X - action.point.x) * ELASTICITY, 100 + (TWEETY_START_Y - action.point.y) * ELASTICITY));
                        tweety.unFreeze();
                    }
                    break;
                case drag:
                    if (tweety.isFrozen() && action.point.x < TWEETY_START_X && action.point.y >= FLOOR_HEIGHT && action.point.y < TWEETY_START_Y) {
                        tweety.setX(action.point.x);
                        tweety.setY(action.point.y);
                    }
                    break;
            }
        }
    }

    public void update(float dt) {
        //  Bird
        tweety.accelerate(dt);
        tweety.move(dt);
        PhysicalObject hit = scenery.collidesWith(tweety);
        if (hit != null) {
            String c = hit.getClass().getSimpleName();
            if (c.equals("TNT")) {
                scoreBoard.scoreChange(-((TNT) hit).getNegativePoints());
            } else if (c.equals("Pig")) {
                Pig p = (Pig)hit;
                if (p.getWord().getId() == board.getWordId() + 20) {
                    scoreBoard.scoreChange(SCORE_BUMP_SUCCESS);
                    p.setWord(new Word(1, "bob", "bobby")); // REPLACE w/ collec.
                    board.setWord(scenery.pickAWord());
                } else if (p.luckyOne) {
                    // Put Hat on Bob The Bird
                    p.looseHat();
                } else {
                    scoreBoard.scoreChange(-SCORE_BUMP_FAIL);
                }
            }
            tweety.reset();
        }

        // Wasp
        waspy.accelerate(dt);
        waspy.move(dt);
        if (tweety.collidesWith(waspy)) {
            scoreBoard.scoreChange(-100);
            AngryBob.gameActivityManager.push(new GameOver());
        }

        // Bird Respawn
        if (tweety.getX() > WORLD_WIDTH - Bird.WIDTH) tweety.reset();

        // Bubbles
        for (int i = babble.size() - 1; i >= 0; i--) {
            babble.get(i).ageAway(dt);
            if (babble.get(i).isDead()) babble.remove(i);
        }

        // Rubberbands
        rubberBand1.between(new Vector2(tweety.getX() + 20, tweety.getY() + 10), new Vector2(SLINGSHOT_OFFSET + SLINGSHOT_WIDTH, SLINGSHOT_HEIGHT + FLOOR_HEIGHT - 40));
        rubberBand2.between(new Vector2(tweety.getX() + 20, tweety.getY() + 10), new Vector2(SLINGSHOT_OFFSET + 15, SLINGSHOT_HEIGHT + FLOOR_HEIGHT - 40));

        // Scoreboard
        scoreBoard.update(dt);
        if (scoreBoard.gameOver())
            AngryBob.gameActivityManager.push(new GameOver());


        camera.position.lerp(posCameraDesired,0.1f);
    }

    public Vector3 posCameraDesired = new Vector3(20, 30, 0);

    @Override
    public void render() {
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);
        board.draw(spriteBatch);
        scoreBoard.draw(spriteBatch);
        spriteBatch.draw(slingshot1, SLINGSHOT_OFFSET, FLOOR_HEIGHT, SLINGSHOT_WIDTH, SLINGSHOT_HEIGHT);
        if (tweety.isFrozen())
        {
            for (Bubble b : babble) b.draw(spriteBatch);
            rubberBand1.draw(spriteBatch);
        }
        tweety.draw(spriteBatch);
        if (tweety.isFrozen())
            rubberBand2.draw(spriteBatch);
        waspy.draw(spriteBatch);
        scenery.draw(spriteBatch);
        spriteBatch.draw(slingshot2, SLINGSHOT_OFFSET, FLOOR_HEIGHT, SLINGSHOT_WIDTH, SLINGSHOT_HEIGHT);
        spriteBatch.end();
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
        Vector3 pointTouched = camera.unproject(new Vector3(screenX, screenY, 0));
        actions.add(new Touch(pointTouched, Touch.Type.down));
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        Vector3 pointTouched = camera.unproject(new Vector3(screenX, screenY, 0));
        actions.add(new Touch(pointTouched, Touch.Type.up));
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        Vector3 pointTouched = camera.unproject(new Vector3(screenX, screenY, 0));
        actions.add(new Touch(pointTouched, Touch.Type.drag
        ));
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