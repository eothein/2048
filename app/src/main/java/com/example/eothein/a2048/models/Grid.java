package com.example.eothein.a2048.models;

import com.example.eothein.a2048.interfaces.Slider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jens Buysse & Karine Samyn on 26.09.17.
 */

public class Grid {


    /**
     * Using the Singleton pattern.
     */
    private static Grid gridInstance;
    /**
     * The size of the grid
     */
    private int gridSize;

    /**
     * The grid containing all the elements
     */
    private Element[][] grid;

    private Grid(int gridSize) {
        setGridSize(gridSize);
        grid = new Element[gridSize][gridSize];

        //Initialise the grid with new elements
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = new Element(); //new Element(getGridSize());
            }
        }
        addElement();
        addElement();

    }

    public static Grid get(int gridSize) {
        if (gridInstance == null)
            gridInstance = new Grid(gridSize);
        return gridInstance;
    }

    /**
     * Return the element of this grid
     *
     * @param i the row index
     * @param j the column index
     * @return the requested element
     */
    public Element getElement(int i, int j) {
        return grid[i][j];
    }


    /**
     * Set the number for a certain tile
     *
     * @param number the number to set
     * @param i      the row index
     * @param j      the column index
     */
    public void setElementNumber(int number, int i, int j) {
        Element e = getElement(i, j);
        e.setNumber(number);
    }

    /**
     * Returns the size of this grid
     *
     * @return the gridsize
     */
    public int getGridSize() {
        return gridSize;
    }

    /**
     * Sets the gridsize for this gird
     *
     * @param gridSize the grid size
     */
    public void setGridSize(int gridSize) {
        if (gridSize < 4)
            throw new IllegalArgumentException("The grid size cannot be less than 4");
        else
            this.gridSize = gridSize;
    }

    /**
     * Swipe right
     */
    public void slideRight() {
        for(int i = 0; i < gridSize; i++)
        mergeLine(i);
        addElement();
    }

    /**
     * Swipe left
     */
    public void slideLeft() {

    }

    private void mergeLine(int index){
        for(int i = 0; i < gridSize-1; i++){
            if(grid[index][i].getNumber() != -1) {
                if (grid[index][i].getNumber() == grid[index][i + 1].getNumber()) {
                    //two number next to each other, we need to merge
                    grid[index][i].setNumber(-1);
                    grid[index][i + 1].setNumber(grid[index][i + 1].getNumber() * 2);
                   i++;
                }
            }
            moveTilesRight(index);
        }
    }

    private void moveTilesRight(int index){
        for(int i = 0; i < gridSize-1; i++){
            if(grid[index][i+1].getNumber() == -1){
                //We found an empty Element next to this element, so we need to move everthing right
                for(int j = i+1; j>0 ; j--){
                    grid[index][j].setNumber(grid[index][j-1].getNumber());
                    grid[index][j-1].setNumber(-1);
                }
            }
        }
    }

    /**
     * Swipe up
     */
    public void slideUp() {
        throw new UnsupportedOperationException("This operations is not yet supported");
    }

    /**
     * Swipe down
     */
    public void slideDown() {
        throw new UnsupportedOperationException("This operations is not yet supported");
    }

    private void addElement() {
        List<Element> list = availableSpace();
        if (!availableSpace().isEmpty()) {
            int index = (int) (Math.random() * list.size()) % list.size();
            Element emptyElement = list.get(index);
            emptyElement.setNumber(Math.random() < 0.9 ? 2 : 4);
        }
    }

    private List<Element> availableSpace() {
        final List<Element> list = new ArrayList<Element>(16);
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (grid[i][j].isEmpty()) {
                    list.add(grid[i][j]);
                }
            }
        }

        return list;
    }

    /**
     * Prints the board for testing purposes
     */
    public void printBoard() {
        for (int i = 0; i < this.gridSize; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < this.gridSize; i++) {
            for (int j = 0; j < this.gridSize; j++) {
                System.out.print(grid[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        for (int i = 0; i < this.gridSize; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
