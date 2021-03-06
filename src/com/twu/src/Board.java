package com.twu.src;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by chinawang on 6/21/14.
 */
public class Board {

    private PrintStream printStream;
    private Map<String, String> boardMap;
    private List<String> validMoves;
    private final int maxNumberOfValidMoves = 9;
    private int validMoveCounter = 0;
    private List<ThreeInARow> validWins;

    public Board(PrintStream printStream, Map<String, String> boardMap, List<ThreeInARow> validWins) {
        this.printStream = printStream;
        this.boardMap = boardMap;
        this.validWins = validWins;
        initializeValidMovesList();
    }

//    private void initializeValidWinsList() {
//        ThreeInARow row1 = new ThreeInARow(Arrays.asList("1", "2", "3"));
//        ThreeInARow row2 = new ThreeInARow(Arrays.asList("4", "5", "6"));
//        ThreeInARow row3 = new ThreeInARow(Arrays.asList("7", "8", "9"));
//        ThreeInARow col1 = new ThreeInARow(Arrays.asList("1", "4", "7"));
//        ThreeInARow col2 = new ThreeInARow(Arrays.asList("2", "5", "8"));
//        ThreeInARow col3 = new ThreeInARow(Arrays.asList("3", "6", "9"));
//        ThreeInARow diagonal1 = new ThreeInARow(Arrays.asList("1", "5", "9"));
//        ThreeInARow diagonal2 = new ThreeInARow(Arrays.asList("3", "5", "7"));
//        validWins = new ArrayList<ThreeInARow>(Arrays.asList(row1, row2, row3, col1, col2, col3, diagonal1, diagonal2));
//    }

    private void initializeValidMovesList() {
        String[] validMovesArray = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        validMoves = new ArrayList<String>(Arrays.asList(validMovesArray));
    }

    public String getBoardSymbol(String key) {
        if (boardMap.containsKey(key)) {
            return boardMap.get(key);
        } else {
            return " ";
        }
    }

    public void printBoard() {
        printStream.println(" " + getBoardSymbol("1") + " | " + getBoardSymbol("2") + " | " + getBoardSymbol("3") + " \n" +
                "--- --- ---\n" +
                " " + getBoardSymbol("4") + " | " + getBoardSymbol("5") + " | " + getBoardSymbol("6") + " \n" +
                "--- --- ---\n" +
                " " + getBoardSymbol("7") + " | " + getBoardSymbol("8") + " | " + getBoardSymbol("9") + " \n");
    }

    public boolean addMoveToBoard(String location, String playerSymbol) {
        if (validMoves.contains(location) && !boardMap.containsKey(location)) {
            boardMap.put(location, playerSymbol);
            updateValidWinsList(location, playerSymbol);
            validMoveCounter++;
            return true;
        } else {
            return false;
        }
    }

    private void updateValidWinsList(String location, String playerSymbol) {
        for (ThreeInARow threeInARow : validWins) {
            if (threeInARow.getAllLocations().contains(location)) {
                threeInARow.setLocationAsTaken(location, playerSymbol);
            }
        }
    }

    public boolean isFull() {
        return validMoveCounter == maxNumberOfValidMoves;
    }

    public boolean playerHasWon(String playerSymbol) {
        for (ThreeInARow threeInARow : validWins) {
            if (threeInARow.hasWon(playerSymbol)) {
                return true;
            }
        }
        return false;
    }

    public String getFirstEmptyLocation() {
        for (String location : validMoves) {
            if (!boardMap.containsKey(location)) {
                return location;
            }
        }
        return null;
    }
}
