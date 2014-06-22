package com.twu.tests;

import com.twu.src.*;
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
        mockPlayerOne = mock(HumanPlayer.class);
        mockPlayerTwo = mock(HumanPlayer.class);
        runner = new TicTacToeRunner(mockPrintStream, mockBoard, mockTurnManager, mockPlayerOne, mockPlayerTwo);
    }

    @Test
    public void shouldPrintPlayerOneHasWon() throws IOException {
        when(mockBoard.playerHasWon(mockPlayerOne.getSymbol())).thenReturn(true);
        runner.go();
        verify(mockPrintStream).println("Player null wins!");
    }

    @Test
    public void shouldPrintGameIsADrawWhenBoardIsFull() throws IOException {
        when(mockBoard.isFull()).thenReturn(true);
        runner.go();
        verify(mockPrintStream).println("Game is a draw");
    }






}