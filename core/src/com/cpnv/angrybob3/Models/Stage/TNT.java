package com.cpnv.angrybob3.Models.Stage;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Phil & XCL
 */

public final class TNT extends PhysicalObject {

    private static final String PICNAME = "tnt.png";
    private static final int WIDTH = 60;
    private static final int HEIGHT = 60;

    private int negativePoints; // Number of pooints removed from score if hit

    public TNT(Vector2 position, int negativePoints) {
        super(position, WIDTH, HEIGHT, PICNAME);
        this.negativePoints = negativePoints;
    }

    public int getNegativePoints() {
        return negativePoints;
    }

    public void explode(){

    }
}
