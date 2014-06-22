package com.twu.tests;

import com.twu.src.Board;
import com.twu.src.ComputerPlayer;
import com.twu.src.Player;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ComputerPlayerTest {

    private Board mockBoard;
    private Player player;
    private final String playerSymbol = "X";
    private final String playerInput = "1";

    @Before
    public void setUp() {
        mockBoard = mock(Board.class);
        player = new ComputerPlayer(playerSymbol, "Computer", mockBoard);
    }

    @Test
    public void shouldTellBoardToMakeMoveAtLocation1() throws IOException {
        when(mockBoard.getFirstEmptyLocation()).thenReturn(playerInput);
        player.makeMove();
        verify(mockBoard).addMoveToBoard(playerInput, playerSymbol);
    }

}