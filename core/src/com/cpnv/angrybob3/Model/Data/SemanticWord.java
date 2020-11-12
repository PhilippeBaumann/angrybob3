package com.cpnv.angrybob3.Model.Data;

import java.util.HashMap;

public class SemanticWord {
    private String question;
    private String solution;
    // tells if the word has been given to a Pig
    private boolean allocated;
    // tells if the player has already solved the translation
    private boolean found;

    private HashMap<String, String> values;

    public SemanticWord() {
        values = new HashMap<>();
        allocated = false;
        found = false;
    }

    public void addTranslation(String language, String value){
        values.put(language, value);
    }

    public String getValue(String language){
        return values.get(language);
    }

    // Get the Word associated with the Base (Known Word)
    public String getQuestion(String languageFrom) {
        return getValue(languageFrom);
    }

    // Get the Word associated with the training (To learn Word)
    public String getSolution(String languageTo) {
        return getValue(languageTo);
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
