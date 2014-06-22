package com.twu.tests;

import com.twu.src.Board;
import com.twu.src.HumanPlayer;
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

    private PrintStream mockPrintStream;
    private Board mockBoard;
    private TurnManager turnManager;
    private Player mockPlayer;

    @Before
    public void setUp() {
        mockPrintStream = mock(PrintStream.class);
        mockBoard = mock(Board.class);
        turnManager = new TurnManager(mockPrintStream, mockBoard);
        mockPlayer = mock(HumanPlayer.class);
    }

    @Test
    public void shouldAskPlayerOneForMove() throws IOException {
        when(mockPlayer.getNumber()).thenReturn("One");
        when(mockPlayer.makeMove()).thenReturn(true);
        turnManager.takeTurn(mockPlayer);
        verify(mockPrintStream).print("Player One, enter your move: ");
    }

}