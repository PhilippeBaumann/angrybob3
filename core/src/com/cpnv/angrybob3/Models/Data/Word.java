package com.cpnv.angrybob3.Models.Data;

/**
 * Created by XCL & Phil
 */

public class Word {
    //private int id;
    private String value1;
    private String value2;

    private boolean allocated;
    private boolean found;

    /*
    public int getId() {
        return id;
    }
    */

    public String getValue1() {
        return value1;
    }

    public String getValue2() {
        return value2;
    }

    public Word(String value1, String value2) {
        this.value1 = value1;
        this.value2 = value2;
        allocated = false;
        found = false;
    }

}
