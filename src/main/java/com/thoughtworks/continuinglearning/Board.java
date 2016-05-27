package com.thoughtworks.continuinglearning;

import java.io.PrintStream;

public class Board {
    private PrintStream printStream;
    private Prompter prompter;
    private String board = "1|2|3\n" +
                           "-----\n" +
                           "4|5|6\n" +
                           "-----\n" +
                           "7|8|9";

    public Board(PrintStream printStream, Prompter prompter) {
        this.printStream = printStream;
        this.prompter = prompter;
    }

    public void draw() {
        printStream.println(board);
    }

    public void mark(String symbol) {
        String cellToMark = prompter.prompt();
        Boolean locationAvailability = checkLocation(cellToMark);

        if(locationAvailability) {
            board = board.replace(cellToMark, symbol);
        } else {
            printStream.println("Location already taken");
        }
    }

    private Boolean checkLocation(String cell) {
        if(board.contains(cell)) {
            return true;
        } else {
            return false;
        }
    }
}