package com.thoughtworks.continuinglearning;


import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class GameTest {

    private Game game;
    private Board board;
    private Player player1;
    private Player player2;

    @Before
    public void setUp() {
       board = mock(Board.class);
       player1 = mock(Player.class);
       player2 = mock(Player.class);
       game = new Game(board, player1, player2);
    }

    @Test
    public void shouldDrawBoardWhenApplicationStarts() {
        when(board.isFull()).thenReturn(false).thenReturn(true);
        game.start();

        verify(board, times(3)).draw();
    }

    @Test
    public void shouldRecordFirstPlayersMoveWhenBoardHasBeenDrawn() {
        when(board.isFull()).thenReturn(false).thenReturn(true);
        game.start();

        verify(player1).makeMove();
    }

    @Test
    public void shouldRecordSecondPlayersMoveWhenBoardHasBeenDrawn() {
        when(board.isFull()).thenReturn(false).thenReturn(true);
        game.start();

        verify(player2).makeMove();
    }

    @Test
    public void shouldCheckIfPlayerHasWonWhenPlayerFinishesTurn() {
        when(board.isFull()).thenReturn(false).thenReturn(true);

        game.start();

        verify(player1).hasWon();
    }
}
