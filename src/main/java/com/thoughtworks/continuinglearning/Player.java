package com.thoughtworks.continuinglearning;

import java.io.BufferedReader;
import java.io.IOException;

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

    private String getBufferedReaderInput() {
        try {
            return  bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void makeMove() {
       String userChoice = getBufferedReaderInput();
       board.mark(userChoice);
    }
}
