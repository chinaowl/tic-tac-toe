package com.twu.src;

import java.io.IOException;

/**
 * Created by chinawang on 6/22/14.
 */
public interface Player {

    public boolean makeMove() throws IOException;

    public String getSymbol();

    public String getNumber();

}
