package com.twu.src;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by chinawang on 6/21/14.
 */
public class HumanPlayer implements Player {

    private BufferedReader reader;
    private final String symbol;
    private final String number;
    private Board board;

    public HumanPlayer(BufferedReader reader, String symbol, String number, Board board) {
        this.reader = reader;
        this.symbol = symbol;
        this.number = number;
        this.board = board;
    }

    @Override
    public boolean makeMove() throws IOException {
        String location = reader.readLine();
        return board.addMoveToBoard(symbol, location);
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }
}
