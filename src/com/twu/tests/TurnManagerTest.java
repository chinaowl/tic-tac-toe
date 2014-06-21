package com.twu.tests;

import com.twu.src.Board;
import com.twu.src.Player;
import com.twu.src.TurnManager;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.io.PrintStream;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TurnManagerTest {

    private PrintStream printStream;
    private Board board;
    private TurnManager turnManager;
    private Player player;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        turnManager = new TurnManager(printStream, board);
        player = mock(Player.class);
    }

    @Test
    public void shouldAskPlayerOneForMove() throws IOException {
        when(player.getNumber()).thenReturn("One");
        when(player.makeMove()).thenReturn(true);
        turnManager.takeTurn(player);
        verify(printStream).print("Player One, enter your move: ");
    }

}