package com.cpnv.angrybob3.Model.Data;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

import com.cpnv.angrybob3.AngryBob;

public class Vocabulary {
    private String vocName;
    private ArrayList<SemanticWord> words;

    // By assessing the Voc we can see which languages are in use
    private String languageFrom;
    private String languageTo;

    public String getLanguageFrom() {
        return languageFrom;
    }

    public void setLanguageFrom(String languageFrom) {
        this.languageFrom = languageFrom;
    }

    public String getLanguageTo() {
        return languageTo;
    }

    public void setLanguageTo(String languageTo) {
        this.languageTo = languageTo;
    }

    public Vocabulary(String vocName) {
        this.vocName = vocName;
        words = new ArrayList<>();
    }

    public String getName() {
        return vocName;
    }

    public ArrayList<SemanticWord> getWords() {
        return words;
    }

    public int size() {
        return words.size();
    }

    // The next two functions are the same , another name was provided in the VocProvider
    //  Was asked in the pdf
    public void addWord(SemanticWord word) {
        words.add(word);
    }

    // it's whats call in the VocProvider
    public void addSemanticWord(SemanticWord word) {
        words.add(word);
    }

    public boolean hasNotFoundWord() {
        for (SemanticWord word : words) {
            if (!word.isFound()) {
                return true;
            }
        }
        return false;
    }



    public boolean hasNotAllocatedWord() {
        for (SemanticWord word : words) {
            if (!word.isAllocated()) {
                return true;
            }
        }
        return false;
    }

    public void resetFoundWords() {
        for (SemanticWord word : words) {
            word.setFound(false);
        }
    }

    public void deallocateAll() {
        for (SemanticWord word : words) {
            word.setAllocated(false);
        }
    }

    public SemanticWord pickAWord() throws NoPickableWordException {
        return pickWord(words);
    }

    public SemanticWord pickNotAllocatedWord() throws NoPickableWordException {
        return pickWord(notAllocatedWords());
    }

    public SemanticWord pickNotFoundWord() throws NoPickableWordException {
        return pickWord(notFoundWords());
    }

    public void print() {
        for (SemanticWord word : words) {
            Gdx.app.log("EXCEPTION", "Voc: ");
            Gdx.app.log("EXCEPTION",
                    word.getQuestion(getLanguageFrom()) + " / " + word.getSolution(getLanguageTo()) + " :: "
            + "Allocated : " + word.isAllocated() + ", Found : " + word.isFound());
        }
    }

    private SemanticWord pickWord(ArrayList<SemanticWord> words) throws NoPickableWordException {
        int wordsCount = words.size();

        if (wordsCount <= 0) {
            throw new NoPickableWordException();
        }
        return words.get(AngryBob.alea.nextInt(words.size()));
    }

    private ArrayList<SemanticWord> notAllocatedWords() {
        ArrayList<SemanticWord> notAllocatedWords = new ArrayList<>();
        for (SemanticWord word : words) {
            if (!word.isAllocated()) {
                notAllocatedWords.add(word);
            }
        }
        return notAllocatedWords;
    }

    private ArrayList<SemanticWord> notFoundWords() {
        ArrayList<SemanticWord> notFoundWords = new ArrayList<>();
        for (SemanticWord word : words) {
            if (!word.isFound()) {
                notFoundWords.add(word);
            }
        }
        return notFoundWords;
    }
}
