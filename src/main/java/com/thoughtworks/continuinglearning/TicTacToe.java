package com.thoughtworks.continuinglearning;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class TicTacToe {
    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> locations = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            locations.add(i, Integer.toString(i + 1));
        }
        Board board = new Board(printStream, locations);
        Player player1 = new Player(board, "X", "1", printStream, bufferedReader);
        Player player2 = new Player(board, "O", "2", printStream, bufferedReader);
        Game game = new Game(board, player1, player2);
        game.start();
    }
}
