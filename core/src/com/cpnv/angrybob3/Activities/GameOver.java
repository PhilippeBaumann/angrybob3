package com.cpnv.angrybob3.Activities;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

import com.cpnv.angrybob3.AngryBob;

public class GameOver extends BaseActivity implements InputProcessor {
    private static final String TITLE = "Fin de la partie";
    private static final int TITLE_SCALE = 6;
    private static final int INFO_SCALE = 2;

    private BitmapFont titleFont;
    private float titlePositionX;
    private float titlePositionY;

    private BitmapFont infoFont;
    private String scoreText;
    private float scorePositionX;
    private float scorePositionY;
    private String vocText;
    private float vocPositionX;
    private float vocPositionY;

    public GameOver() {
        titleFont = new BitmapFont();
        titleFont.setColor(Color.RED);
        titleFont.getData().setScale(TITLE_SCALE);
        GlyphLayout titleGlyphLayout = new GlyphLayout();
        titleGlyphLayout.setText(titleFont, TITLE);
        titlePositionX = Play.WORLD_WIDTH / 2f - titleGlyphLayout.width / 2f;
        titlePositionY = Play.WORLD_HEIGHT / 2f + titleGlyphLayout.height / 2f;

        scoreText = "Score : " + AngryBob.score;
        vocText = "Voc : " + AngryBob.voc.getName();

        infoFont = new BitmapFont();
        infoFont.setColor(Color.BLACK);
        infoFont.getData().setScale(INFO_SCALE);

        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(infoFont, scoreText);
        scorePositionX = Play.WORLD_WIDTH / 2f - glyphLayout.width / 2f;
        scorePositionY = titlePositionY - titleGlyphLayout.height - glyphLayout.height;
        glyphLayout.setText(infoFont, vocText);
        vocPositionX = Play.WORLD_WIDTH / 2f - glyphLayout.width / 2f;
        vocPositionY = scorePositionY - glyphLayout.height - 10;
    }

    @Override
    public void render() {
        super.render();

        batch.begin();
        titleFont.draw(batch, TITLE, titlePositionX, titlePositionY);
        infoFont.draw(batch, scoreText, scorePositionX, scorePositionY);
        infoFont.draw(batch, vocText, vocPositionX, vocPositionY);
        batch.end();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        AngryBob.popPage();
        return true;
    }
}
