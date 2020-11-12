package com.cpnv.angrybob3;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

import java.util.Random;
import java.util.Stack;

import com.cpnv.angrybob3.Activities.Play;
import com.cpnv.angrybob3.Activities.Welcome;
import com.cpnv.angrybob3.Model.Data.Vocabulary;
import com.cpnv.angrybob3.Providers.VocProvider;

// TODO try to improve performance by not reusing textures

public class AngryBob extends Game {
    public static Random alea;

    protected static Stack<Game> pages;

    public static Vocabulary voc;

    public static int score = 0;

    @Override
    public void create() {
        alea = new Random();

        pages = new Stack<>();
        pages.push(new Welcome());
    }

    @Override
    public void render() {
        pages.peek().render();
    }

    public static void start(String LanguageFrom, String LanguageTo) {
        AngryBob.score = 0;
        AngryBob.voc = VocProvider.getInstance().pickAVoc();
        AngryBob.voc.setLanguageFrom(LanguageFrom);
        AngryBob.voc.setLanguageTo(LanguageTo);
        voc.resetFoundWords();
        AngryBob.pushPage(new Play());
    }

    public static void pushPage(Game game) {
        // Since we will only push new pages, we don't need to initialize
        pages.push(game);
    }

    public static void popPage() {
        pages.pop();
        Gdx.input.setInputProcessor((InputProcessor) pages.peek());
    }
}
