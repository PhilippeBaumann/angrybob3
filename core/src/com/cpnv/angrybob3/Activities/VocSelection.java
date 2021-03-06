package com.cpnv.angrybob3.Activities;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;

import com.cpnv.angrybob3.AngryBob;
import com.cpnv.angrybob3.Model.Data.Vocabulary;
import com.cpnv.angrybob3.Providers.VocProvider;
import com.cpnv.angrybob3.ui.Button;

public class VocSelection extends BaseActivity implements InputProcessor {
    private static final String TITLE = "Angry Wirds";
    private String VOCTITLE = "Exercice de ... en ...";
    private static final int TITLE_SIZE = 6;
    private static final int LINE_SIZE = 3;

    private static final float TITLE_POSITION_Y = Play.WORLD_HEIGHT - 20f;
    private static final float BUTTON_DIMENSION = 100;
    private static final float VOC_POSITION_X = 200;
    private static final float VOC_START_Y = Play.WORLD_HEIGHT - 200;
    private static final float VOC_MARGIN = 50f;

    private BitmapFont titleFont;
    private float titlePositionX;

    private BitmapFont vocabularyFont;
    private BitmapFont randomVocFont;
    private float vocTextX;
    // used to align the text with the buttons, using the center
    private float textOffsetY;

    // Button randomVocButton;

    // Buttons FR , EN , ES

    private Button buttonFromFR;
    private Button buttonFromEN;
    private Button buttonFromES;

    private BitmapFont buttonFromFRFont;
    private BitmapFont buttonFromESFont;
    private BitmapFont buttonFromENFont;

    private HashMap<Button, Vocabulary> vocSelectionButtons;
    private HashMap<Button, Vocabulary> vocDetailButtons;
    private float vocDetailX;

    public VocSelection() {

        // Title
        titleFont = new BitmapFont();
        titleFont.setColor(Color.BLUE);
        titleFont.getData().setScale(TITLE_SIZE);
        GlyphLayout titleGlyphLayout = new GlyphLayout();
        titleGlyphLayout.setText(titleFont, TITLE);
        titlePositionX = Play.WORLD_WIDTH / 2f - titleGlyphLayout.width / 2f;

        // Voc Title
        titleFont = new BitmapFont();
        titleFont.setColor(Color.BLUE);
        titleFont.getData().setScale(TITLE_SIZE);
        titleGlyphLayout.setText(titleFont, VOCTITLE);
        titlePositionX = Play.WORLD_WIDTH / 2f - titleGlyphLayout.width / 2f;

        vocDetailX = VOC_POSITION_X + BUTTON_DIMENSION + VOC_MARGIN;

        vocabularyFont = new BitmapFont();
        vocabularyFont.setColor(Color.BLUE);
        vocabularyFont.getData().setScale(LINE_SIZE);
        vocTextX = vocDetailX + BUTTON_DIMENSION + VOC_MARGIN;

        randomVocFont = new BitmapFont();
        randomVocFont.setColor(Color.RED);
        randomVocFont.getData().setScale(LINE_SIZE);

        float buttonY = VOC_START_Y;

        // Button FR, ES, EN

        buttonFromFR = new Button(
                new Vector2(VOC_POSITION_X, buttonY),
                BUTTON_DIMENSION, BUTTON_DIMENSION,
                "pig.png",
                "fr"
        );
        buttonFromES = new Button(
                new Vector2(VOC_POSITION_X, buttonY - 100),
                BUTTON_DIMENSION, BUTTON_DIMENSION,
                "pig.png",
                "es"
        );
        buttonFromEN = new Button(
                new Vector2(VOC_POSITION_X, buttonY - 200),
                BUTTON_DIMENSION, BUTTON_DIMENSION,
                "pig.png",
                "en"
        );


        buttonY -= BUTTON_DIMENSION + VOC_MARGIN;
        vocSelectionButtons = new HashMap<>();
        vocDetailButtons = new HashMap<>();
        for (Vocabulary vocabulary : VocProvider.getInstance().vocabularies) {
            vocSelectionButtons.put(
                    new Button(
                            new Vector2(VOC_POSITION_X, buttonY),
                            BUTTON_DIMENSION, BUTTON_DIMENSION,
                            "block.png",
                            vocabulary.getName()
                    ),
                    vocabulary
            );
            vocDetailButtons.put(
                    new Button(
                            new Vector2(vocDetailX, buttonY),
                            BUTTON_DIMENSION, BUTTON_DIMENSION,
                            "block.png",
                            "bob"
                    ),
                    vocabulary
            );
            buttonY -= BUTTON_DIMENSION + VOC_MARGIN;
        }

        GlyphLayout vocGlyphLayout = new GlyphLayout();
        vocGlyphLayout.setText(vocabularyFont, TITLE);
        vocGlyphLayout.setText(vocabularyFont, VOCTITLE);
        // We want to align the center of the button with the center of the text
        textOffsetY = vocGlyphLayout.height / 2f - BUTTON_DIMENSION / 2f;
    }

    @Override
    public void render() {
        super.render();

        batch.begin();
        titleFont.draw(batch, TITLE, titlePositionX, TITLE_POSITION_Y);
        titleFont.draw(batch, VOCTITLE, titlePositionX, TITLE_POSITION_Y - 200);

        // Buttons Rendering

        buttonFromFR.draw(batch);
        buttonFromES.draw(batch);
        buttonFromEN.draw(batch);

        //randomVocFont.draw(batch, "Random", vocTextX, buttonFromFR.getYTop() + textOffsetY);

        // Buttons Font

        //buttonFromFRFont.draw(batch, "Random", vocTextX, buttonFromFR.getYTop() + textOffsetY);
        //buttonFromESFont.draw(batch, "Random", vocTextX, buttonFromES.getYTop() + textOffsetY);
        //buttonFromENFont.draw(batch, "Random", vocTextX, buttonFromEN.getYTop() + textOffsetY);
        batch.end();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector2 touchPoint = convertCoordinates(screenX, screenY);

        if (buttonFromFR.isTouched(touchPoint)) {
            AngryBob.popPage();
            AngryBob.start(buttonFromES.getValue() , "en");
        }

        if (buttonFromEN.isTouched(touchPoint)) {
            AngryBob.popPage();
            AngryBob.start(buttonFromES.getValue() , "en");
        }

        if (buttonFromES.isTouched(touchPoint)) {
            AngryBob.popPage();
            AngryBob.start(buttonFromES.getValue() , "en");
        }

        // Modify to get buttons for each language

        for (HashMap.Entry<Button, Vocabulary> entry : vocSelectionButtons.entrySet()) {
            Button languageButton = entry.getKey();
            if (languageButton.isTouched(touchPoint)) {
                // Get the selected language To
                Vocabulary selectedVoc = entry.getValue();
                AngryBob.popPage();
                // TODO Wait till the second button is selected for the training language
                AngryBob.start(/*languageButton.getValue()*/ "fr" , "en");
            }
        }
        for (HashMap.Entry<Button, Vocabulary> entry : vocDetailButtons.entrySet()) {
            Button iconButton = entry.getKey();
            if (iconButton.isTouched(touchPoint)) {
                Vocabulary selectedVoc = entry.getValue();
                AngryBob.pushPage(new VocDetail(selectedVoc));
            }
        }
        return true;
    }
}
