package com.cpnv.angrybob3.Models.Stage;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Phil & XCL
 */

public class RubberBand extends PhysicalObject {
    private static final String PICNAME = "rubber.png";
    private static final float THICKNESS = 12f;

    public RubberBand(){
        super(new Vector2(0,0),0,0,PICNAME);
    }

    public void between (Vector2 ori, Vector2 dest) {
        Vector2 diff = dest.sub(ori);
        setBounds(ori.x,ori.y,diff.len(), THICKNESS);
        setOrigin(0,0);
        setRotation(diff.angle());
    }

}
