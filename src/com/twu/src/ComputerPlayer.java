package com.twu.src;

/**
 * Created by chinawang on 6/22/14.
 */
public class ComputerPlayer implements Player {

    private final String symbol;
    private final String number;
    private Board board;

    public ComputerPlayer(String symbol, String number, Board board) {
        this.symbol = symbol;
        this.number = number;
        this.board = board;
    }

    @Override
    public boolean makeMove() {
        String location = board.getFirstEmptyLocation();
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
