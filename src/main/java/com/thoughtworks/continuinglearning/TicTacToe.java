package com.thoughtworks.continuinglearning;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class TicTacToe {
    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Prompter prompter = new Prompter(bufferedReader);
        Board board = new Board(printStream, prompter);
        Player player1 = new Player(board, "X");
        Player player2 = new Player(board, "O");
        Game game = new Game(board, player1, player2);
        game.start();
    }
}
