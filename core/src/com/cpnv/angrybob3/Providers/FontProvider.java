package com.cpnv.angrybob3.Providers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by Phil
 */

public abstract class FontProvider {

    public static BitmapFont Title;
    public static BitmapFont h1;

    /**
     * Must be called once at the beginning of the app
     */
    public static void load() {
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.characters = "abcdefghijklmnopqrstuvwxyzàéèêëùABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.!'()>?:";
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("BungeeShadeRegular.ttf"));
        parameter.size = 150;
        parameter.color = Color.BLACK;
        Title = generator.generateFont(parameter);

        parameter.size = 80;
        h1 = generator.generateFont(parameter);
    }

}
