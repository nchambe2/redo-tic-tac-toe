package com.thoughtworks.continuinglearning;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameTest {

    private Board board;
    private Game game;
    private PrintStream printStream;
    private Player player;
    private BufferedReader bufferedReader;

    @Before
    public void setup(){
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        player = mock(Player.class);
        bufferedReader = mock(BufferedReader.class);
        game = new Game(printStream, board, player, bufferedReader);
    }

    @Test
    public void shouldPrintGameBoardWhenApplicationStarts(){
        game.start();

        verify(board).drawBoard();
    }

    @Test
    public void shouldGetPlayerMoveAfterGameStarts(){
        game.start();

        verify(player).makeMove();
    }

}