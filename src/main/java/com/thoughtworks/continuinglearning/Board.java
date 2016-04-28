package com.thoughtworks.continuinglearning;

import java.io.PrintStream;

/**
 * Created by nicollettec on 4/28/16.
 */
public class Board {

    public static final String X = "X";
    public static final String O = "O";

    private PrintStream printStream;
    private String board =  "1|2|3\n" +
                            "-----\n" +
                            "4|5|6\n" +
                            "-----\n" +
                            "7|8|9";

    public Board(PrintStream printStream){

        this.printStream = printStream;
    }

    public void drawBoard(){
        printStream.println(
               board
        );

    }

    public void mark(String playerMove) {
        Integer userSelection = Integer.parseInt(playerMove);

        if (userSelection % 2 == 0) {
            board = board.replaceAll(playerMove, X);
        } else {
            board = board.replaceAll(playerMove, O);
        }

        drawBoard();
    }
}
