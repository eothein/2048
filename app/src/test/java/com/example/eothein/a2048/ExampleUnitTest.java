package com.example.eothein.a2048;

import android.util.Log;

import com.example.eothein.a2048.models.Grid;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    private Grid grid;

    @Before
    public void initialize() {
        this.grid = Grid.get(4);
        //Create a completely empty board
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid.setElementNumber(-1, i, j);
            }
        }
        grid.setElementNumber(2, 0, 2);
        grid.setElementNumber(2, 0, 3);

        grid.setElementNumber(4, 3, 2);
        grid.setElementNumber(4, 3, 3);

        grid.setElementNumber(4, 2, 1);

    }

    @Test
    public void testRightSwipeOnGrid() {
        grid.printBoard();
        grid.slideRight();
        grid.printBoard();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                
                assertEquals(-1, grid.getElement(i, j).getNumber(), 5);
            }
        }
        assertEquals(grid.getElement(0, 3).getNumber(), 4);
        assertEquals(grid.getElement(2, 3).getNumber(), 4);
        assertEquals(grid.getElement(3, 3).getNumber(), 8);

    }
}