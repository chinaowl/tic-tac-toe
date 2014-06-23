package com.twu.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

public class TicTacToeMain {

    public static void main(String[] args) throws IOException {
        PrintStream printStream = new PrintStream(System.out);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> boardMap = new HashMap<String, String>();
        List<ThreeInARow> validWins = initializeValidWinsList();
        Board board = new Board(printStream, boardMap, validWins);
        TurnManager turnManager = new TurnManager(printStream, board);
        Player playerOne = new HumanPlayer(reader, "X", "One", board);
        Player playerTwo = new ComputerPlayer("O", "Two", board, validWins);
        TicTacToeRunner runner = new TicTacToeRunner(printStream, board, turnManager, playerOne, playerTwo);
        runner.go();
    }

    private static List<ThreeInARow> initializeValidWinsList() {
        ThreeInARow row1 = new ThreeInARow(Arrays.asList("1", "2", "3"));
        ThreeInARow row2 = new ThreeInARow(Arrays.asList("4", "5", "6"));
        ThreeInARow row3 = new ThreeInARow(Arrays.asList("7", "8", "9"));
        ThreeInARow col1 = new ThreeInARow(Arrays.asList("1", "4", "7"));
        ThreeInARow col2 = new ThreeInARow(Arrays.asList("2", "5", "8"));
        ThreeInARow col3 = new ThreeInARow(Arrays.asList("3", "6", "9"));
        ThreeInARow diagonal1 = new ThreeInARow(Arrays.asList("1", "5", "9"));
        ThreeInARow diagonal2 = new ThreeInARow(Arrays.asList("3", "5", "7"));
        return new ArrayList<ThreeInARow>(Arrays.asList(row1, row2, row3, col1, col2, col3, diagonal1, diagonal2));
    }
}
