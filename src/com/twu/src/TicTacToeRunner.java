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
    private Player playerOne, playerTwo;

    public TicTacToeRunner(PrintStream printStream, BufferedReader reader, Board board, Player playerOne, Player playerTwo) {
        this.printStream = printStream;
        this.reader = reader;
        this.board = board;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void go() throws IOException {
        board.printBoard();


        while (true) {
            boolean validMoveMade;
            while (true) {
                printStream.print("Player One, enter your move: ");
                validMoveMade = playerOne.makeMove();
                if (validMoveMade) {
                    board.printBoard();
                    break;
                } else {
                    printStream.println("Location already taken");
                }
            }

            if (board.isFull()) {
                break;
            }

            while (true) {
                printStream.print("Player Two, enter your move: ");
                validMoveMade = playerTwo.makeMove();
                if (validMoveMade) {
                    board.printBoard();
                    break;
                } else {
                    printStream.println("Location already taken");
                }
            }

            if (board.isFull()) {
                break;
            }
        }
        printStream.println("Game is a draw");
    }

}
