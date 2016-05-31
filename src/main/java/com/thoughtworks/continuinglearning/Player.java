package com.thoughtworks.continuinglearning;

import java.io.PrintStream;

public class Player {
    private Board board;
    private String symbol;
    private String playerNumber;
    private PrintStream printstream;

    public Player(Board board, String symbol, String playerNumber, PrintStream printstream) {
        this.board = board;
        this.symbol = symbol;
        this.playerNumber = playerNumber;
        this.printstream = printstream;
    }

    public void makeMove() {
      board.mark(symbol);
    }


    public void hasWon() {
        if(board.hasWinner()) {
            printstream.println("Player " + playerNumber + " Wins!");
        }
    }
}
