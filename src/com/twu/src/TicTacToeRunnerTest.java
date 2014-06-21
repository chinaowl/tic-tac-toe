package com.twu.src;

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
    private TicTacToeRunner runner;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        board = mock(Board.class);
        runner = new TicTacToeRunner(printStream, reader, board);
    }

    @Test
    public void shouldAskPlayerOneForMove() throws IOException {
        runner.go();
        verify(printStream).print("Player One, enter your move: ");
    }

    @Test
    public void shouldAskPlayerTwoForMove() throws IOException {
        runner.go();
        verify(printStream).print("Player Two, enter your move: ");
    }


}