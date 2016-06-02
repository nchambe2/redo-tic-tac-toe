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
    private Integer numOfEmptyLocations;


    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        symbolX = "X";
        symbolO = "O";
        locations = new ArrayList<>();
        locations.add(0, "1");
        locations.add(1, "2");
        locations.add(2, "3");
        locations.add(3, "4");
        locations.add(4, "5");
        locations.add(5, "6");
        locations.add(6, "7");
        locations.add(7, "8");
        locations.add(8, "9");
        numOfEmptyLocations = 9;
        board = new Board(printStream, locations, numOfEmptyLocations);
    }

    @Test
    public void shouldDrawBoard(){
        board.draw();

        verify(printStream).println(
                locations.get(0) + "|" + locations.get(1) + "|" + locations.get(2) + "\n" +
                "-----" + "\n" +
                locations.get(3) + "|" + locations.get(4) + "|" + locations.get(5) + "\n" +
                "-----" + "\n" +
                locations.get(6) + "|" + locations.get(7) + "|" + locations.get(8) + "\n"
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
    public void shouldReturnFalseWhenBoardIsNotFull() {
        board.setNumOfEmptyLocations(0);

        assertThat(board.isFull(), is(false));
    }

    @Test
    public void shouldReturnTrueWhenBoardIsFull() {
        board.setNumOfEmptyLocations(9);

        assertThat(board.isFull(), is(true));
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
    @Test
    public void shouldReturnFalseWhenThereIsntThreeInARowHorizontally() {
        assertThat(board.hasWinner(), is(false));
    }

}