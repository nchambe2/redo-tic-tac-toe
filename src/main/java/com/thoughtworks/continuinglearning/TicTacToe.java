package com.thoughtworks.continuinglearning;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class TicTacToe {

    public static void main(String[] args) {
        List<Integer> boardArray = new ArrayList();
        boardArray.add(1);
        boardArray.add(2);
        boardArray.add(3);
        boardArray.add(4);
        boardArray.add(5);
        boardArray.add(6);
        boardArray.add(7);
        boardArray.add(8);
        boardArray.add(9);

        PrintStream printStream = new PrintStream(System.out);
        Board board = new Board(boardArray, printStream);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Player player = new Player(board, bufferedReader);


        Game game = new Game(printStream, board, player, bufferedReader);
    }
}
