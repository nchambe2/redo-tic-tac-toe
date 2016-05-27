package com.thoughtworks.continuinglearning;


import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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

        game.start();

        verify(board, times(2)).draw();
    }

    @Test
    public void shouldRecordFirstPlayersMoveWhenBoardHasBeenDrawn() {
        game.start();

        verify(player1).makeMove();
    }

    @Test
    public void shouldRecordSecondPlayersMoveWhenBoardHasBeenDrawn() {
        game.start();

        verify(player2).makeMove();
    }
}
