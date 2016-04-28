package com.thoughtworks.continuinglearning;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class TicTacToe {

    public static void main(String[] args) {

        PrintStream printStream = new PrintStream(System.out);
        Board board = new Board(printStream);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Player player = new Player(board, bufferedReader);


        Game game = new Game(printStream, board, player, bufferedReader);
        game.start();
    }
}
