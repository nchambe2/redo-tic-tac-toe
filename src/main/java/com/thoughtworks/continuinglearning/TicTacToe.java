package com.thoughtworks.continuinglearning;

import java.io.PrintStream;

public class TicTacToe {
    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        Board board = new Board(printStream);
        Player player = new Player();
        Game game = new Game(board, player);
        game.start();
    }
}
