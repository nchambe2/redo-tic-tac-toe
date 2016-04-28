package com.thoughtworks.continuinglearning;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by nicollettec on 4/28/16.
 */

public class PlayerTest {

    private BufferedReader bufferedReader;
    private Player player;
    private Board board;
    private PrintStream printStream;

    @Before
    public void setUp() {
        bufferedReader = mock(BufferedReader.class);
        board = mock(Board.class);
        player = new Player(board, bufferedReader);
        printStream = mock(PrintStream.class);
    }

    @Test
    public void shouldCaptureUserMove() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");

        player.makeMove(bufferedReader);

        verify(board).mark(bufferedReader);

    }

    @Test
    public void shouldCaptureUserMoveWhenInputIsTwo() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2");

        player.makeMove(bufferedReader);

        verify(board).mark(bufferedReader);

    }
}