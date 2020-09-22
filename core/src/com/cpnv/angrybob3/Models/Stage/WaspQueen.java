package com.cpnv.angrybob3.Models.Stage;


import com.badlogic.gdx.math.Vector2;
import com.cpnv.angrybob3.Activities.Play;
import com.cpnv.angrybob3.AngryBob;

/**
 * Created by Phil & XCL
 */

public final class WaspQueen extends Wasp {

    private static final int AGITATION = 15; // How sharply speed changes
    private static final String PICNAME = "wasp.png";
    private static final int WIDTH = 180;
    private static final int HEIGHT = 180;

    public WaspQueen(Vector2 position, Vector2 speed) {
        super(position, WIDTH, HEIGHT, PICNAME, speed);
    }

    @Override
    public void accelerate(float dt) {
        // The wasp only slightly alters its speed at random. It is subject to gravity, but it counters it with its flight
        speed.x += (AngryBob.random.nextFloat()-getX()/ (Play.WORLD_WIDTH - 30))*AGITATION; // the closer it is to a border, the higher the chances that acceleration goes the other way
        speed.y += (AngryBob.random.nextFloat()-getY()/ Play.WORLD_HEIGHT)*AGITATION;
    }

}
