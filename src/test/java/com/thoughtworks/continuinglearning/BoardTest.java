package com.thoughtworks.continuinglearning;

import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by nicollettec on 4/28/16.
 */
public class BoardTest {

    @Test
    public void shouldDrawBoard(){
        List<Integer> boardArray = new ArrayList();
        PrintStream printStream = mock(PrintStream.class);
        Board board = new Board(boardArray, printStream);

        board.drawBoard();

        verify(printStream).println(
                "1|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9"
        );
    }

}