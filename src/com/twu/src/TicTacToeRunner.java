package com.twu.src;

import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by chinawang on 6/21/14.
 */
public class TicTacToeRunner {

    private PrintStream printStream;
    private Board board;
    private TurnManager turnManager;
    private Player playerOne, playerTwo;

    public TicTacToeRunner(PrintStream printStream, Board board, TurnManager turnManager, Player playerOne, Player playerTwo) {
        this.printStream = printStream;
        this.board = board;
        this.turnManager = turnManager;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void go() throws IOException {
        board.printBoard();
        String finalMessage = "Game is a draw";

        while (true) {
            turnManager.takeTurn(playerOne);
            if (board.playerHasWon(playerOne.getSymbol())) {
                finalMessage = "Player " + playerOne.getNumber() + " wins!";
                break;
            }
            if (board.isFull()) {
                break;
            }

            turnManager.takeTurn(playerTwo);
            if (board.playerHasWon(playerTwo.getSymbol())) {
                finalMessage = "Player " + playerTwo.getNumber() + " wins!";
                break;
            }
            if (board.isFull()) {
                break;
            }
        }
        printStream.println(finalMessage);
    }

}
