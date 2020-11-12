package com.cpnv.angrybob3.Model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

import com.cpnv.angrybob3.AngryBob;
import com.cpnv.angrybob3.Model.Data.SemanticWord;
import com.cpnv.angrybob3.Model.Data.Word;

public final class Pig extends TextualObject implements ScoreInfluencer {
    private static final String PICTURE_NAME = "pig.png";

    private static final int POINTS = -50;

    public static final int WIDTH = 60;
    public static final int HEIGHT = WIDTH;

    private Bubble bubble = null;

    private SemanticWord word;

    public Pig(Vector2 position, SemanticWord word) {
        super(position, WIDTH, HEIGHT, PICTURE_NAME, word.getSolution(AngryBob.voc.getLanguageFrom()));
        this.word = word;
    }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);
        if (bubble != null) {
            bubble.draw(batch);
        }
    }

    public SemanticWord getWord() {
        return word;
    }

    public boolean getScreaming() {
        return bubble != null;
    }

    public void sayWord() {
        this.bubble = new Bubble(this);
    }

    public void shutUp() {
        this.bubble = null;
    }

    @Override
    public int getPoints() {
        return POINTS;
    }
}
