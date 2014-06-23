package com.twu.tests;

import com.twu.src.ThreeInARow;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class ThreeInARowTest {

    private ThreeInARow row;

    @Before
    public void setUp() {
        row = new ThreeInARow(Arrays.asList("1", "2", "3"));
    }

    @Test
    public void shouldReturnHasWonIsTrue() {
        row.setLocationAsTaken("1", "X");
        row.setLocationAsTaken("2", "X");
        row.setLocationAsTaken("3", "X");
        assertTrue(row.hasWon("X"));
    }

    @Test
    public void shouldReturnHasWonIsFalse() {
        row.setLocationAsTaken("1", "X");
        row.setLocationAsTaken("2", "X");
        row.setLocationAsTaken("3", "O");
        assertFalse(row.hasWon("X"));
    }

    @Test
    public void shouldReturnIsAboutToWinIsTrue() {
        row.setLocationAsTaken("1", "X");
        row.setLocationAsTaken("2", "X");
        assertTrue(row.isAboutToWin("X"));
    }

    @Test
    public void shouldReturnIsAboutToWinIsFalse() {
        row.setLocationAsTaken("1", "X");
        row.setLocationAsTaken("2", "O");
        assertFalse(row.isAboutToWin("X"));
    }

    @Test
    public void shouldReturnWinningLocation() {
        row.setLocationAsTaken("1", "X");
        row.setLocationAsTaken("2", "X");
        assertEquals("3", row.getNextWinningLocation());
    }

}