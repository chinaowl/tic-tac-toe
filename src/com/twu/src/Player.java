package com.twu.src;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by chinawang on 6/21/14.
 */
public class Player {

    private BufferedReader reader;
    private final String symbol;
    private final String number;
    private Board board;

    public Player(BufferedReader reader, String symbol, String number, Board board) {
        this.reader = reader;
        this.symbol = symbol;
        this.number = number;
        this.board = board;
    }

    public boolean makeMove() throws IOException {
        String location = reader.readLine();
        return board.addMoveToBoard(symbol, location);
    }

    public String getNumber() {
        return number;
    }
}
