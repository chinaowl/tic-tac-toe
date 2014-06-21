package com.twu.src;

/**
 * Created by chinawang on 6/21/14.
 */
public class Player {

    private final String symbol;
    private Board board;

    public Player(String symbol, Board board) {
        this.symbol = symbol;
        this.board = board;
    }

    public boolean makeMove(String location) {
        if (board.addMoveToBoard(symbol, location)) {
            return true;
        } else {
            return false;
        }
    }
}
