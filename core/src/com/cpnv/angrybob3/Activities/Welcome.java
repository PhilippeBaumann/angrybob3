package com.cpnv.angrybob3.Activities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

import com.cpnv.angrybob3.AngryBob;

public class Welcome extends BaseActivity {
    private static final String TITLE = "Angry Wirds";
    private static final int TITLE_SCALE = 6;

    private BitmapFont titleFont;
    private float titlePositionX;
    private float titlePositionY;

    public Welcome() {
        titleFont = new BitmapFont();
        titleFont.setColor(Color.ROYAL);
        titleFont.getData().setScale(TITLE_SCALE);
        GlyphLayout titleGlyphLayout = new GlyphLayout();
        titleGlyphLayout.setText(titleFont, TITLE);
        titlePositionX = Play.WORLD_WIDTH / 2f - titleGlyphLayout.width / 2f;
        titlePositionY = Play.WORLD_HEIGHT / 2f + titleGlyphLayout.height / 2f;
    }

    @Override
    public void render() {
        super.render();

        batch.begin();
        titleFont.draw(batch, TITLE, titlePositionX, titlePositionY);
        batch.end();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        AngryBob.pushPage(new VocSelection());
        return true;
    }
}
