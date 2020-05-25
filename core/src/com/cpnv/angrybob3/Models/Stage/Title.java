package com.cpnv.angrybob3.Models.Stage;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.cpnv.angrybob3.Models.Activities.GameActivity;
import com.cpnv.angrybob3.Providers.FontProvider;

/**
 * Created by Phil & XCL
 */

public final class Title {

    private BitmapFont font;
    private GlyphLayout layout;
    private float x;
    private float y;

    public Title(String message) {
        initBase(message);
        x = (GameActivity.WORLD_WIDTH-layout.width)/2;
        y = (GameActivity.WORLD_HEIGHT+(layout.height*2))/2;
    }

    public Title(String message, float px, float py) {
        initBase(message);
        x = px;
        y = py;
    }

    private void initBase(String message)
    {
        layout = new GlyphLayout();
        font = FontProvider.Title;
        setText(message);
    }

    public void draw(Batch batch)
    {
        font.draw(batch, layout, x, y);
    }

    public void setText (String text)
    {
        layout.setText(font,text);
    }
}
