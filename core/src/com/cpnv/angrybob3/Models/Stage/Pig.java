package com.cpnv.angrybob3.Models.Stage;
import com.badlogic.gdx.math.Vector2;
import com.cpnv.angrybob3.Models.Data.Word;

/**
 * Created by Phil
 */

public final class Pig extends PhysicalObject {

    private static final String  PICNAME = "pig.png";
    private static Boolean luckyOne = false;

    private static final int WIDTH = 60;
    public static final int HEIGHT = 60;

    private Word word;

    public Pig(Vector2 position, Word word, boolean luckyOne) {
        super(position, WIDTH, HEIGHT, PICNAME);
        this.luckyOne = luckyOne;
        this.word = word;
        if (this.luckyOne) {
            this.retexture("pigWithHat.png");
            this.word = (new Word('1', "Bailando!", "Pimenton!"));
        }
    }

    public void looseHat(){
        this.retexture("pig.png");
        luckyOne ^= true;
    }

    public Boolean getLuckyOne() { return luckyOne; }



    public Word getWord() {
        return word;
    }

    public String getWordValue() {
        return word.getValue2();
    }
    
    public void setWord(Word word) {
        this.word = word;
    }
}
