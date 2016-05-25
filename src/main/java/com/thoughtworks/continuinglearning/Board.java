package com.thoughtworks.continuinglearning;

import java.io.PrintStream;

public class Board {
    private PrintStream printStream;
    private String board = "1|2|3\n" +
            "-----\n" +
            "4|5|6\n" +
            "-----\n" +
            "7|8|9";

    public Board(PrintStream printStream) {

        this.printStream = printStream;
    }

    public void draw() {
        printStream.println(board);
    }
}