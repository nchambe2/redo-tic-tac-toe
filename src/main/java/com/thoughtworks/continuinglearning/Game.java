package com.thoughtworks.continuinglearning;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;

    public Game(Board board, Player player1, Player player2) {

        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
    while(board.isThereAnEmptySpace()) {
          board.draw();
          player1.makeMove();
          board.draw();
          player1.hasWon();
          player2.makeMove();
          board.draw();
          player2.hasWon();
     }

    }
}
