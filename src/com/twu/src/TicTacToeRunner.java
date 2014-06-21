package com.twu.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by chinawang on 6/21/14.
 */
public class TicTacToeRunner {

    private PrintStream printStream;
    private BufferedReader reader;
    private Board board;

    public TicTacToeRunner(PrintStream printStream, BufferedReader reader, Board board) {
        this.printStream = printStream;
        this.reader = reader;
        this.board = board;
    }

    public void go() throws IOException {
        board.printBoard();

        printStream.print("Player One, enter your move: ");
        Player playerOne = new Player("X", board);
        String playerOneLocation = reader.readLine();
        playerOne.makeMove(playerOneLocation);
        board.printBoard();

        printStream.print("Player Two, enter your move: ");
        Player playerTwo = new Player("O", board);
        String playerTwoLocation = reader.readLine();
        playerTwo.makeMove(playerTwoLocation);
        board.printBoard();
    }

}
