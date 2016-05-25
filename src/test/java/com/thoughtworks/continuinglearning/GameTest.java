package com.thoughtworks.continuinglearning;


import com.sun.media.jfxmedia.events.PlayerStateEvent;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameTest {

    private Game game;
    private Board board;
    private Player player;

    @Before
    public void setUp() {
       board = mock(Board.class);
       player = mock(Player.class);
       game = new Game(board, player);
    }

    @Test
    public void shouldDrawBoardWhenApplicationStarts() {

        game.start();

        verify(board).draw();
    }

    @Test
    public void shouldRedrawBoardWhenUserEntersInput() {
        game.start();

        verify(player).makeMove();
    }
}
