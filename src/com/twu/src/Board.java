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

    public Board(PrintStream printStream, Map<String, String> boardMap) {
        this.printStream = printStream;
        this.boardMap = boardMap;
        initializeValidMovesList();
    }

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

    public boolean addMoveToBoard(String playerSymbol, String playerInput) {
        if (validMoves.contains(playerInput) && !boardMap.containsKey(playerInput)) {
            boardMap.put(playerInput, playerSymbol);
            validMoveCounter++;
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        return validMoveCounter == maxNumberOfValidMoves;
    }
}
