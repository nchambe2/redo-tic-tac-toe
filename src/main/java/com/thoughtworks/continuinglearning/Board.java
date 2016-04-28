package com.thoughtworks.continuinglearning;

import java.io.PrintStream;

/**
 * Created by nicollettec on 4/28/16.
 */
public class Board {

    private PrintStream printStream;

    public Board(PrintStream printStream){

        this.printStream = printStream;
    }

    public void drawBoard(){
        printStream.println(
                "1|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9"
        );

    }

    public void mark(String playerMove) {

    }
}
