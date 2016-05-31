package com.thoughtworks.continuinglearning;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class BoardTest {
    private PrintStream printStream;
    private Board board;
    private String markedBoardString;
    private Prompter prompter;
    private String symbolX;
    private String symbolO;
    private List <String> boardState;
    private Boolean allLocationsTaken;
    private Integer numOfEmptyLocations;


    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        prompter = mock(Prompter.class);
        symbolX = "X";
        symbolO = "O";
        boardState = new ArrayList<>();
        boardState.add(0, "1");
        boardState.add(1, "2");
        boardState.add(2, "3");
        boardState.add(3, "4");
        boardState.add(4, "5");
        boardState.add(5, "6");
        boardState.add(6, "7");
        boardState.add(7, "8");
        boardState.add(8, "9");
        allLocationsTaken = false;
        numOfEmptyLocations = 9;
        board = new Board(printStream, prompter, boardState, allLocationsTaken, numOfEmptyLocations);
    }

    @Test
    public void shouldDrawBoard(){

        board.draw();

        verify(printStream).println(boardState);
    }

    @Test
    public void shouldPromptUserForCellToMarkWhenPlayerIsPrompted() {
        when(prompter.prompt()).thenReturn("1");

        board.mark(symbolX);

        verify(prompter).prompt();
    }

    @Test
    public void shouldMarkXWhenPlayerOneMakesAMove() {
        markedBoardString = "X|2|3\n" +
                            "-----\n" +
                            "4|5|6\n" +
                            "-----\n" +
                            "7|8|9";

        when(prompter.prompt()).thenReturn("1");

        board.mark(symbolX);
        board.draw();

        verify(printStream).println(markedBoardString);
    }

    @Test
    public void shouldMarkOWhenPlayer2MakesAMove() {
        markedBoardString = "1|2|O\n" +
                            "-----\n" +
                            "4|5|6\n" +
                            "-----\n" +
                            "7|8|9\n";

        when(prompter.prompt()).thenReturn("3");

        board.mark(symbolO);
        board.draw();

        verify(printStream).println(markedBoardString);
    }

    @Test
    public void shouldDisplayLocationTakenMessageWhenPlayerAttemptsToMarkACellThatIsNotAvailable() {

        when(prompter.prompt()).thenReturn("3").thenReturn("3");
        board.mark(symbolO);
        board.mark(symbolO);

        verify(printStream).println("Location already taken");
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

}