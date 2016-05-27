package com.thoughtworks.continuinglearning;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

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


    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        prompter = mock(Prompter.class);
        symbolX = "X";
        symbolO = "O";
        board = new Board(printStream, prompter);
    }

    @Test
    public void shouldDrawBoard(){

        board.draw();

        verify(printStream).println(
                "1|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9"
        );
    }

    @Test
    public void shouldPromptUserForCellToMarkWhenPlayerIsPrompted() {
        when(prompter.prompt()).thenReturn("1");

        board.mark(symbolX);

        verify(prompter).prompt();
    }

    @Test
    public void shouldMarkOWhenPlayer1MakesAMove() {
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
                            "7|8|9";

        when(prompter.prompt()).thenReturn("3");

        board.mark(symbolO);
        board.draw();

        verify(printStream).println(markedBoardString);
    }

    @Test
    public void shouldDisplayLocationTakenMessageWhenPlayerAttemptsToMarkACellThatIsNotAvailable() {
        boardString = "1|2|O\n" +
                            "-----\n" +
                            "4|5|6\n" +
                            "-----\n" +
                            "7|8|9";

        when(prompter.prompt()).thenReturn("3");

        board.mark(symbolO);
        board.draw();

        verify(printStream).println("Location already taken");
    }

}