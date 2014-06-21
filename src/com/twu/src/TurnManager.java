package com.twu.src;

import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by chinawang on 6/21/14.
 */
public class TurnManager {

    private PrintStream printStream;
    private Board board;

    public TurnManager(PrintStream printStream, Board board) {
        this.printStream = printStream;
        this.board = board;
    }

    public void takeTurn(Player player) throws IOException {
        boolean validMoveMade;
        while (true) {
            printStream.print("Player " + player.getNumber() + ", enter your move: ");
            validMoveMade = player.makeMove();
            if (validMoveMade) {
                board.printBoard();
                break;
            } else {
                printStream.println("Location already taken");
            }
        }
    }
}
