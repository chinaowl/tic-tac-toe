package com.twu.tests;

import com.twu.src.Board;
import com.twu.src.HumanPlayer;
import com.twu.src.Player;
import org.junit.Before;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.IOException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HumanPlayerTest {

    private BufferedReader mockReader;
    private Board mockBoard;
    private Player player;
    private final String playerSymbol = "X";
    private final String playerInput = "1";


    @Before
    public void setUp() {
        mockReader = mock(BufferedReader.class);
        mockBoard = mock(Board.class);
        player = new HumanPlayer(mockReader, playerSymbol, "1", mockBoard);
    }

    @Test
    public void shouldTellBoardToMakeMoveAtLocation1() throws IOException {
        when(mockReader.readLine()).thenReturn(playerInput);
        player.makeMove();
        verify(mockBoard).addMoveToBoard(playerInput, playerSymbol);
    }

}