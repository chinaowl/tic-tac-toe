package com.twu.src;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chinawang on 6/22/14.
 */
public class ThreeInARow {

    private final List<String> allLocations;
    private Map<String, String> takenLocations;

    public ThreeInARow(List<String> allLocations) {
        this.allLocations = allLocations;
        takenLocations = new HashMap<String, String>();
    }

    public boolean hasWon(String playerSymbol) {
        for (String location : allLocations) {
            if (!takenLocations.containsKey(location)) {
                return false;
            }
            if (takenLocations.containsKey(location) && !takenLocations.get(location).equals(playerSymbol)) {
                return false;
            }
        }
        return true;
    }

    public boolean isAboutToWin(String playerSymbol) {
        return false;
    }

    public List<String> getAllLocations() {
        return allLocations;
    }

    public void setLocationAsTaken(String location, String playerSymbol) {
        takenLocations.put(location, playerSymbol);
    }
}
