package com.twu.tests;

import com.twu.src.Board;
import com.twu.src.Player;
import com.twu.src.TicTacToeRunner;
import com.twu.src.TurnManager;
import org.junit.Before;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TicTacToeRunnerTest {

    private PrintStream mockPrintStream;
    private BufferedReader mockReader;
    private Board mockBoard;
    private TurnManager mockTurnManager;
    private Player mockPlayerOne, mockPlayerTwo;
    private TicTacToeRunner runner;

    @Before
    public void setUp() {
        mockPrintStream = mock(PrintStream.class);
        mockReader = mock(BufferedReader.class);
        mockBoard = mock(Board.class);
        mockTurnManager = mock(TurnManager.class);
        mockPlayerOne = mock(Player.class);
        mockPlayerTwo = mock(Player.class);
        runner = new TicTacToeRunner(mockPrintStream, mockBoard, mockTurnManager, mockPlayerOne, mockPlayerTwo);
    }

    @Test
    public void shouldPrintGameIsADrawWhenLoopEnds() throws IOException {
        when(mockBoard.isFull()).thenReturn(true);
        runner.go();
        verify(mockPrintStream).println("Game is a draw");
    }






}