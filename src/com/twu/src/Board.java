package com.twu.src;

import java.io.PrintStream;
import java.util.Map;

/**
 * Created by chinawang on 6/21/14.
 */
public class Board {

    private PrintStream printStream;
    private Map<String, String> boardMap;
    private final int maxNumberOfValidMoves = 9;
    private int validMoveCounter = 0;

    public Board(PrintStream printStream, Map<String, String> boardMap) {
        this.printStream = printStream;
        this.boardMap = boardMap;
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
        if (!boardMap.containsKey(playerInput)) {
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
