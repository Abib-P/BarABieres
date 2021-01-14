package com.barabieres.output;

public enum startChoices {
    easy_mode("Easy mode"),
    normal("Normal mode"),
    hard("Hard mode"),
    display("Display Rules");

    private String name;
    startChoices(String name){
     this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override public String toString() { return getName(); }

}
