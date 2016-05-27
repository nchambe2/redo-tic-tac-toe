package com.thoughtworks.continuinglearning;

import java.io.BufferedReader;
import java.io.IOException;

public class Prompter {

    private BufferedReader bufferedReader;

    public Prompter(BufferedReader bufferedReader) {

        this.bufferedReader = bufferedReader;
    }

    public String prompt() {
        try {
            return bufferedReader.readLine();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
