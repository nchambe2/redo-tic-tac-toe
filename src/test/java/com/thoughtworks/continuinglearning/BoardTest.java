package com.thoughtworks.continuinglearning;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class BoardTest {

    private PrintStream printStream;
    private Board board;
    private BufferedReader bufferedReader;
    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        board = new Board(printStream);
        bufferedReader = mock(BufferedReader.class);
    }

    @Test
    public void shouldDrawBoard(){

        board.drawBoard();

        verify(printStream).println(
                "1|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9"
        );
    }

    @Test
    public void shouldUpdateBoardWithXWhenUserMarksEvenSquare() throws IOException {

        board.mark("2");

        verify(printStream).println(
                "1|X|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9"
        );
    }

    @Test
    public void shouldUpdateBoardWithOWhenUserMarksOddSquare() {
        board.mark("3");

        verify(printStream).println(
                "1|2|O\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9"
        );

    }

}