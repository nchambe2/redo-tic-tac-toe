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
        Prompter prompter = new Prompter(bufferedReader);
        List<String> boardState = new ArrayList<>();
        boardState.add(0, "1");
        boardState.add(1, "2");
        boardState.add(2, "3");
        boardState.add(3, "4");
        boardState.add(4, "5");
        boardState.add(5, "6");
        boardState.add(6, "7");
        boardState.add(7, "8");
        boardState.add(8, "9");
        Boolean allLocationsTaken = false;
        Integer numOfEmptyLocations = 9;
        Board board = new Board(printStream, prompter, boardState, allLocationsTaken, numOfEmptyLocations);
        Player player1 = new Player(board, "X");
        Player player2 = new Player(board, "O");
        Game game = new Game(board, player1, player2);
        game.start();
    }
}
