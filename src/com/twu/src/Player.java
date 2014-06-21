package com.twu.src;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by chinawang on 6/21/14.
 */
public class Player {

    private BufferedReader reader;
    private final String symbol;
    private Board board;

    public Player(BufferedReader reader, String symbol, Board board) {
        this.reader = reader;
        this.symbol = symbol;
        this.board = board;
    }

    public boolean makeMove() throws IOException {
        String location = reader.readLine();
        if (board.addMoveToBoard(symbol, location)) {
            return true;
        } else {
            return false;
        }
    }
}
