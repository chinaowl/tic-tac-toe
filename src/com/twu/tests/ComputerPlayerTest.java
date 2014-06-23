package com.twu.tests;

import com.twu.src.Board;
import com.twu.src.ComputerPlayer;
import com.twu.src.Player;
import com.twu.src.ThreeInARow;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        ThreeInARow row1 = new ThreeInARow(Arrays.asList("1", "2", "3"));
        List<ThreeInARow> validWins = new ArrayList<ThreeInARow>(Arrays.asList(row1));
        player = new ComputerPlayer(playerSymbol, "Computer", mockBoard, validWins);
    }

    @Test
    public void shouldTellBoardToMakeMoveAtFirstAvailableLocation() throws IOException {
        when(mockBoard.getFirstEmptyLocation()).thenReturn(playerInput);
        player.makeMove();
        verify(mockBoard).addMoveToBoard(playerInput, playerSymbol);
    }

    @Test
    public void shouldTellBoardToMakeWinningMove() {

    }

}