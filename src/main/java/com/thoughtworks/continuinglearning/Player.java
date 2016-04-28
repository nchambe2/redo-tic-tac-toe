package com.thoughtworks.continuinglearning;

import java.io.BufferedReader;

/**
 * Created by nicollettec on 4/28/16.
 */
public class Player {

    private Board board;
    private BufferedReader bufferedReader;

    public Player(Board board, BufferedReader bufferedReader) {
        this.board = board;
        this.bufferedReader = bufferedReader;
    }

    public void makeMove(BufferedReader bufferedReader) {
       board.mark(bufferedReader);
    }
}
