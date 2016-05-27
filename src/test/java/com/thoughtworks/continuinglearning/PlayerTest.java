package com.thoughtworks.continuinglearning;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PlayerTest {
    @Test
    public void shouldMarkBoardWhenPlayerMakesAMove() {
        String symbol = "X";
        Board board = mock(Board.class);
        Player player = new Player(board, symbol);

        player.makeMove();

        verify(board).mark(symbol);
    }

}