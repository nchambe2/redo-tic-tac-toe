package com.thoughtworks.continuinglearning;

public class Player {
    private Board board;
    private String symbol;

    public Player(Board board, String symbol) {
        this.board = board;
        this.symbol = symbol;
    }

    public void makeMove() {
      board.mark(symbol);
    }


}
