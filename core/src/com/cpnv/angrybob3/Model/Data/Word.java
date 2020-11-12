package com.cpnv.angrybob3.Model.Data;

public class Word {
    private String question;
    private String solution;
    // tells if the word has been given to a Pig
    private boolean allocated;
    // tells if the player has already solved the translation
    private boolean found;

    public Word(String solution, String question) {
        this.question = question;
        this.solution = solution;
        allocated = false;
        found = false;
    }

    public String getQuestion() {
        return question;
    }

    public String getSolution() {
        return solution;
    }

    public boolean isAllocated() {
        return allocated;
    }

    public void setAllocated(boolean allocated) {
        this.allocated = allocated;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }
}
