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

    private Button randomVocButton;
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
        randomVocButton = new Button(
                new Vector2(VOC_POSITION_X, buttonY),
                BUTTON_DIMENSION, BUTTON_DIMENSION,
                "block.png",
                "random"
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
        randomVocButton.draw(batch);
        randomVocFont.draw(batch, "Random", vocTextX, randomVocButton.getYTop() + textOffsetY);
        for (HashMap.Entry<Button, Vocabulary> entry : vocSelectionButtons.entrySet()) {
            Button button = entry.getKey();
            button.draw(batch);

            Vocabulary voc = entry.getValue();
            vocabularyFont.draw(batch, voc.getName(), vocTextX, button.getYTop() + textOffsetY);
        }
        for (HashMap.Entry<Button, Vocabulary> entry : vocDetailButtons.entrySet()) {
            Button button = entry.getKey();
            button.draw(batch);
        }
        batch.end();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector2 touchPoint = convertCoordinates(screenX, screenY);

        // TODO Remove
        if (randomVocButton.isTouched(touchPoint)) {
            //AngryBob.popPage();
            //AngryBob.start();
        }

        // Modify to get buttons for each language

        for (HashMap.Entry<Button, Vocabulary> entry : vocSelectionButtons.entrySet()) {
            Button languageButton = entry.getKey();
            if (languageButton.isTouched(touchPoint)) {
                // Get the selected language To
                Vocabulary selectedVoc = entry.getValue();
                AngryBob.popPage();
                // TODO Wait till the second button is selected for the training language
                AngryBob.start(/*languageButton.getValue()*/ "en" , "fr");
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
