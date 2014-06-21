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

    private PrintStream printStream;
    private Map<String, String> boardMap;
    private Board board;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        boardMap = new HashMap<String, String>();
        board = new Board(printStream, boardMap);
    }

    @Test
    public void shouldReturnEmptyBoardString() {
        board.printBoard();
        verify(printStream).println("   |   |   \n" +
                "--- --- ---\n" +
                "   |   |   \n" +
                "--- --- ---\n" +
                "   |   |   \n");
    }

    @Test
    public void shouldReturnBoardStringWithXInLocation1() {
        boardMap.put("1", "X");
        board.printBoard();
        verify(printStream).println(" X |   |   \n" +
                "--- --- ---\n" +
                "   |   |   \n" +
                "--- --- ---\n" +
                "   |   |   \n");
    }

    @Test
    public void shouldAddMoveToBoardAtLocation1() {
        board.addMoveToBoard("X", "1");
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
        board.addMoveToBoard("X", "1");
        board.addMoveToBoard("Y", "1");
        assertEquals("X", board.getBoardSymbol("1"));
    }

    @Test
    public void validAddMoveShouldReturnTrue() {
        assertTrue(board.addMoveToBoard("X", "1"));
    }

    @Test
    public void invalidAddMoveShouldReturnFalse() {
        board.addMoveToBoard("X", "1");
        assertFalse(board.addMoveToBoard("Y", "1"));
    }

}