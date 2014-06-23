package com.twu.src;

import java.util.List;

/**
 * Created by chinawang on 6/22/14.
 */
public class ComputerPlayer implements Player {

    private final String symbol;
    private final String number;
    private Board board;
    private List<ThreeInARow> validWins;

    public ComputerPlayer(String symbol, String number, Board board, List<ThreeInARow> validWins) {
        this.symbol = symbol;
        this.number = number;
        this.board = board;
        this.validWins = validWins;
    }

    @Override
    public boolean makeMove() {
        String location = null;
        for (ThreeInARow threeInARow : validWins) {
            if (threeInARow.isAboutToWin(symbol)) {
                location = threeInARow.getNextWinningLocation();
            }
        }
        if (location == null) {
            location = board.getFirstEmptyLocation();
        }
        return board.addMoveToBoard(location, symbol);
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
