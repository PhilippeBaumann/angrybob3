package com.cpnv.angrybob3.Activities;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Vector2;

import com.cpnv.angrybob3.AngryBob;
import com.cpnv.angrybob3.Model.Data.Vocabulary;
import com.cpnv.angrybob3.Model.Data.SemanticWord;
import com.cpnv.angrybob3.ui.Button;

public class VocDetail extends BaseActivity implements InputProcessor {
    private static final int TITLE_SIZE = 6;
    private static final int WORD_SIZE = 2;

    private static final float TITLE_POSITION_Y = Play.WORLD_HEIGHT - 20f;
    private static final float BUTTON_DIMENSION = 100f;
    private static final float COLUMN1_X = 200f;
    private static final float COLUMN2_X = Play.WORLD_WIDTH / 2f + COLUMN1_X;
    private static final float WORD_MARGIN = 25f;

    private Vector2 previousTouchPoint;
    private float scrollOffset = 0;
    private float maxScrollOffset;

    private Vocabulary voc;

    private BitmapFont titleFont;
    private String title;
    private float titlePositionX;

    private BitmapFont wordFont;
    private float vocStartY;
    private float wordHeight;

    private Button returnButton;

    public VocDetail(Vocabulary voc) {
        this.voc = voc;

        title = this.voc.getName();
        titleFont = new BitmapFont();
        titleFont.setColor(Color.GOLD);
        titleFont.getData().setScale(TITLE_SIZE);
        GlyphLayout titleGlyphLayout = new GlyphLayout();
        titleGlyphLayout.setText(titleFont, title);
        titlePositionX = Play.WORLD_WIDTH / 2f - titleGlyphLayout.width / 2f;
        vocStartY = TITLE_POSITION_Y - titleGlyphLayout.height - WORD_MARGIN;

        wordFont = new BitmapFont();
        wordFont.setColor(Color.BLACK);
        wordFont.getData().setScale(WORD_SIZE);

        returnButton = new Button(
                new Vector2(Play.WORLD_WIDTH - BUTTON_DIMENSION - 10f,
                        Play.WORLD_HEIGHT - BUTTON_DIMENSION - 10f),
                BUTTON_DIMENSION, BUTTON_DIMENSION,
                "pig.png",
                "Back"
        );

        GlyphLayout vocGlyphLayout = new GlyphLayout();
        vocGlyphLayout.setText(wordFont, title);
        wordHeight = vocGlyphLayout.height;

        maxScrollOffset = (wordHeight + WORD_MARGIN) * voc.size() - vocStartY;
    }

    @Override
    public void render() {
        super.render();

        batch.begin();
        titleFont.draw(batch, title, titlePositionX, TITLE_POSITION_Y);
        returnButton.draw(batch);
        float wordY = vocStartY + scrollOffset;
        for (SemanticWord word : voc.getWords()) {
            if (0 <= wordY && wordY <= vocStartY) {
                wordFont.draw(batch, word.getQuestion(AngryBob.voc.getLanguageFrom()), COLUMN1_X, wordY);
                wordFont.draw(batch, word.getSolution(AngryBob.voc.getLanguageTo()), COLUMN2_X, wordY);
            }
            wordY -= wordHeight + WORD_MARGIN;
        }
        batch.end();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector2 touchPoint = convertCoordinates(screenX, screenY);
        if (returnButton.isTouched(touchPoint)) {
            AngryBob.popPage();
        }
        previousTouchPoint = touchPoint;
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        Vector2 touchPoint = convertCoordinates(screenX, screenY);
        float verticalDrag = touchPoint.y - previousTouchPoint.y;
        scrolled((int) verticalDrag);

        previousTouchPoint = touchPoint;
        return true;
    }

    @Override
    public boolean scrolled(int amount) {
        scrollOffset += amount;
        if (scrollOffset < 0) {
            scrollOffset = 0;
        }
        if (scrollOffset > maxScrollOffset) {
            scrollOffset = maxScrollOffset;
        }
        return true;
    }
}
