package com.cpnv.angrybob3.Models.Stage;
import com.badlogic.gdx.math.Vector2;
import com.cpnv.angrybob3.Models.Data.Word;

/**
 * Created by Phil
 */

public final class Pig extends PhysicalObject {

    private static final String  PICNAME = "pig.png";
    private Boolean luckyOne = false;

    private static final int WIDTH = 60;
    public static final int HEIGHT = 60;

    private String word;

    public Pig(Vector2 position, String word, boolean luckyOne) {
        super(position, WIDTH, HEIGHT, PICNAME);
        this.luckyOne = luckyOne;
        this.word = word;
        if (this.luckyOne) {
            this.retexture("pigWithHat.png");
        }
    }

    public void looseHat(){
        this.retexture("pig.png");
        luckyOne ^= true;
    }

    public Boolean getLuckyOne() { return luckyOne; }


    public String getWord() {
        return word;
    }

    public String getWordValue() {
        return this.word;
    }
    
    public void setWord(String word) {
        this.word = word;
    }
}
