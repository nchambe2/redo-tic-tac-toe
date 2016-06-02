package com.thoughtworks.continuinglearning;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
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
    private BufferedReader bufferedReader;


    @Before
    public void setUp() {
        symbol = "X";
        bufferedReader = mock(BufferedReader.class);
        board = mock(Board.class);
        printstream = mock(PrintStream.class);
        playerNumber = "1";
        player = new Player(board, symbol, playerNumber, printstream, bufferedReader);
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

    @Test
    public void shouldPrintMessageToUserWhenPlayerMakesAMove() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        player.makeMove();
        verify(printstream).println("Player " + playerNumber + " please enter a number from 1 through 9.");
    }

    @Test
    public void shouldMarkLocationOneWhenLocationIsEmpty() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        when(board.locationAvailable(1)).thenReturn(true);

        player.makeMove();

        verify(board).mark(1, symbol);
    }

    @Test
    public void shouldReturnLocationUnavailableMessageWhenLocationIsFull() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        when(board.locationAvailable(1)).thenReturn(false);

        player.makeMove();

        verify(printstream).println("Location already taken");

    }



}