package com.cpnv.angrybob3.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.cpnv.angrybob3.Model.TextualObject;

import org.omg.CORBA.PUBLIC_MEMBER;

import jdk.nashorn.internal.ir.CallNode;

public class Button extends TextualObject
{
    private String value;

    public String getValue() {
        return value;
    }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);
    }

    public Button(Vector2 position, float width, float height, String pictureName, String text) {
        super(position, width, height, pictureName, text);
        value = text;
    }

    public boolean isTouched(Vector2 point)
    {
        return this.getRectangle().contains(point);
    }
}
