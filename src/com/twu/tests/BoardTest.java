package com.twu.tests;

import com.twu.src.Board;
import org.junit.Before;
import org.junit.Test;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {

    private PrintStream mockPrintStream;
    private Map<String, String> boardMap;
    private Board board;

    @Before
    public void setUp() {
        mockPrintStream = mock(PrintStream.class);
        boardMap = new HashMap<String, String>();
        board = new Board(mockPrintStream, boardMap);
    }

    @Test
    public void shouldReturnEmptyBoardString() {
        board.printBoard();
        verify(mockPrintStream).println("   |   |   \n" +
                "--- --- ---\n" +
                "   |   |   \n" +
                "--- --- ---\n" +
                "   |   |   \n");
    }

    @Test
    public void shouldReturnBoardStringWithXInLocation1() {
        boardMap.put("1", "X");
        board.printBoard();
        verify(mockPrintStream).println(" X |   |   \n" +
                "--- --- ---\n" +
                "   |   |   \n" +
                "--- --- ---\n" +
                "   |   |   \n");
    }

    @Test
    public void shouldAddMoveToBoardAtLocation1() {
        board.addMoveToBoard("1", "X");
        assertEquals("X", boardMap.get("1"));
    }

    @Test
    public void getBoardSymbolShouldReturnXWhenGiven1() {
        boardMap.put("1", "X");
        assertEquals("X", board.getBoardSymbol("1"));
    }

    @Test
    public void getBoardSymbolShouldReturnSpaceWhenGivenInvalidLocation() {
        assertEquals(" ", board.getBoardSymbol("1"));
    }

    @Test
    public void shouldPreventAddingMovesTwiceToSameLocation() {
        board.addMoveToBoard("1", "X");
        board.addMoveToBoard("1", "Y");
        assertEquals("X", board.getBoardSymbol("1"));
    }

    @Test
    public void validAddMoveShouldReturnTrue() {
        assertTrue(board.addMoveToBoard("1", "X"));
    }

    @Test
    public void invalidAddMoveShouldReturnFalse() {
        board.addMoveToBoard("1", "X");
        assertFalse(board.addMoveToBoard("1", "Y"));
    }

    @Test
    public void playerShouldWinWithThreeInARow() {
        board.addMoveToBoard("1", "X");
        board.addMoveToBoard("2", "X");
        board.addMoveToBoard("3", "X");
        assertTrue(board.playerHasWon("X"));
    }

    @Test
    public void playerShouldWinWithThreeInACol() {
        board.addMoveToBoard("1", "X");
        board.addMoveToBoard("4", "X");
        board.addMoveToBoard("7", "X");
        assertTrue(board.playerHasWon("X"));
    }

    @Test
    public void playerShouldWinWithThreeInADiagonal() {
        board.addMoveToBoard("1", "X");
        board.addMoveToBoard("5", "X");
        board.addMoveToBoard("9", "X");
        assertTrue(board.playerHasWon("X"));
    }

}