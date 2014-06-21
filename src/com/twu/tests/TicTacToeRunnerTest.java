package com.twu.tests;

import com.twu.src.Board;
import com.twu.src.Player;
import com.twu.src.TicTacToeRunner;
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
    private Player playerOne, playerTwo;
    private TicTacToeRunner runner;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        board = mock(Board.class);
        playerOne = mock(Player.class);
        playerTwo = mock(Player.class);
        runner = new TicTacToeRunner(printStream, reader, board, playerOne, playerTwo);
    }

    @Test
    public void shouldAskPlayerOneForMove() throws IOException {
        when(board.isFull()).thenReturn(true);
        when(playerOne.makeMove()).thenReturn(true);
        runner.go();
        verify(printStream).print("Player One, enter your move: ");
    }

    @Test
    public void shouldAskPlayerTwoForMove() throws IOException {
        when(board.isFull()).thenReturn(false).thenReturn(true);
        when(playerOne.makeMove()).thenReturn(true);
        when(playerTwo.makeMove()).thenReturn(true);
        runner.go();
        verify(printStream).print("Player Two, enter your move: ");
    }






}