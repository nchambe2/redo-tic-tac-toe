package com.thoughtworks.continuinglearning;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlayerTest {
    private Player player;
    private String playerNumber;
    private PrintStream printstream;
    private Board board;
    private String symbol;


    @Before
    public void setUp() {
        symbol = "X";
        board = mock(Board.class);
        printstream = mock(PrintStream.class);
        playerNumber = "1";
        player = new Player(board, symbol, playerNumber, printstream);
    }

    @Test
    public void shouldMarkBoardWhenPlayerMakesAMove() {
        player.makeMove();

        verify(board).mark(symbol);
    }

    @Test
    public void shouldCheckToSeeIfTheirIsAWinAfterPlayerHasMadeAMove() {
        player.hasWon();

        verify(board).hasWinner();
    }

    @Test
    public void shouldPrintWinningMessageWhenPlayerHasWonGame() {
        when(board.hasWinner()).thenReturn(true);
        player.hasWon();

        verify(printstream).println("Player " + playerNumber + " Wins!");
    }


}