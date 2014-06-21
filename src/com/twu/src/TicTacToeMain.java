package com.twu.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class TicTacToeMain {

    public static void main(String[] args) throws IOException {
        PrintStream printStream = new PrintStream(System.out);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> boardMap = new HashMap<String, String>();
        Board board = new Board(printStream, boardMap);
        TurnManager turnManager = new TurnManager(printStream, board);
        Player playerOne = new Player(reader, "X", "One", board);
        Player playerTwo = new Player(reader, "O", "Two", board);
        TicTacToeRunner runner = new TicTacToeRunner(printStream, board, turnManager, playerOne, playerTwo);
        runner.go();
    }
}
