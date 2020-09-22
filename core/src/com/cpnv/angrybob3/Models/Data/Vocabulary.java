package com.cpnv.angrybob3.Models.Data;

import com.cpnv.angrybob3.AngryBob;

import java.util.ArrayList;

public class Vocabulary {
    private String vocName;
    private ArrayList<Word> words;

    public Vocabulary(String vocName){
        this.vocName = vocName;
        this.words = new ArrayList<Word>();
    }

    public void addWord(Word word){
        words.add(word);
    }

    public Word pickAWord(){
        return words.get(AngryBob.random.nextInt(words.size()));
    }
}
