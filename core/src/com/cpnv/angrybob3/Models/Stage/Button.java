package com.cpnv.angrybob3.Models.Stage;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Phil & XCL
 */

public final class Button extends PhysicalObject {

    private static final String PICNAME = "button.png";
    private static final int WIDTH = 80;
    private static final int HEIGHT = 80;

    public Button(Vector2 position) {
        super(position, WIDTH, HEIGHT, PICNAME);
    }

    public boolean collides (Vector2 point){
        return this.getRectangle().contains(point);
    }

    public void downed(){
        super.retexture("button_down.png");
    }

    public void upped(){
        super.retexture("button.png");
    }
}
