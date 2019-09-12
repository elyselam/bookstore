package com.company.app.system;

import com.company.platform.MenuBuilder;

public class StringMenuBuilder implements MenuBuilder {

    private StringBuilder state;
    private String delimiter = "\n";

    public StringMenuBuilder() {

        state = new StringBuilder();
    }

    @Override
    public String build() {

        return state.toString();
    }

    /*
        add an option to the state with the following format
        key. value delimiter
        addOption("1", "Exit")
        1. Exit

     */
    public StringMenuBuilder addOption(String key, String value) {
        state.append(String.format("%s. %s %s", key, value, delimiter));

        //returns object that was instantiated in StringBuilder class which contains 'state' variable
        return this;
    }
}
