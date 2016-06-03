package com.thoughtworks.continuinglearning;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class BoardTest {
    private PrintStream printStream;
    private Board board;
    private String symbolX;
    private String symbolO;
    private List <String> locations;


    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        symbolX = "X";
        symbolO = "O";
        locations = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            locations.add(i, Integer.toString(i + 1));
        }
        board = new Board(printStream, locations);
    }

    @Test
    public void shouldDrawBoard(){
        board.draw();

        verify(printStream).println(
                "1|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9\n"
        );
    }

    @Test
    public void shouldReturnTrueWhenLocationIsAvailable() {
        assertThat(board.locationAvailable(1), is(true));
    }

    @Test
    public void shouldMarkXWhenPlayerMakesAMove() {
        board.mark(1, symbolX);

        assertThat(locations.get(0), is(symbolX));
    }

    @Test
    public void shouldMarkOWhenPlayer2MakesAMove() {
        board.mark(3, symbolO);

        assertThat(locations.get(2), is(symbolO));
    }

    @Test
    public void shouldReturnTrueWhenThereIsAnEmptySpace() {

        assertThat(board.isThereAnEmptySpace(), is(true));
    }

    @Test
    public void shouldReturnFalseWhenThereIsNoEmptySpaces() {
        for(int i = 0; i < 9; i++) {
            locations.set(i, symbolX);
        }
        assertThat(board.isThereAnEmptySpace(), is(false));
    }

    @Test
    public void shouldReturnTrueWhenThereIsThreeInARowHorizontally() {
        locations.add(0, "X");
        locations.add(1, "2");
        locations.add(2, "3");
        locations.add(3, "4");
        locations.add(4, "X");
        locations.add(5, "6");
        locations.add(6, "7");
        locations.add(7, "8");
        locations.add(8, "X");
        assertThat(board.hasWinner(), is(true));
    }

}