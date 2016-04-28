package com.thoughtworks.continuinglearning;

import java.io.BufferedReader;
import java.io.PrintStream;

/**
 * Created by nicollettec on 4/28/16.
 */
public class Game {
    private Board board;
    private PrintStream printStream;
    private Player player;
    private BufferedReader bufferedReader;

    public Game(PrintStream printStream, Board board, Player player, BufferedReader bufferedReader) {
        this.printStream = printStream;
        this.board = board;
        this.player = player;
        this.bufferedReader = bufferedReader;
    }

    public void start(){
        board.drawBoard();
        player.makeMove();
    }
}