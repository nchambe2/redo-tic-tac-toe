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
        locations.add(0, "1");
        locations.add(1, "2");
        locations.add(2, "3");
        locations.add(3, "4");
        locations.add(4, "5");
        locations.add(5, "6");
        locations.add(6, "7");
        locations.add(7, "8");
        locations.add(8, "9");
        Integer numOfEmptyLocations = 9;
        Board board = new Board(printStream, locations, numOfEmptyLocations);
        Player player1 = new Player(board, "X", "1", printStream, bufferedReader);
        Player player2 = new Player(board, "O", "2", printStream, bufferedReader);
        Game game = new Game(board, player1, player2);
        game.start();
    }
}
