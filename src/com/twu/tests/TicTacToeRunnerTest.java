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

    private PrintStream printStream;
    private BufferedReader reader;
    private Board board;
    private TurnManager turnManager;
    private Player playerOne, playerTwo;
    private TicTacToeRunner runner;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        board = mock(Board.class);
        turnManager = mock(TurnManager.class);
        playerOne = mock(Player.class);
        playerTwo = mock(Player.class);
        runner = new TicTacToeRunner(printStream, board, turnManager, playerOne, playerTwo);
    }

    @Test
    public void shouldPrintGameIsADrawWhenLoopEnds() throws IOException {
        when(board.isFull()).thenReturn(true);
        runner.go();
        verify(printStream).println("Game is a draw");
    }






}