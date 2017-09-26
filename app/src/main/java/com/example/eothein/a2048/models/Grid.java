package com.example.eothein.a2048.models;

import com.example.eothein.a2048.interfaces.Slider;

/**
 * Created by Jens Buysse & Karine Samyn on 26.09.17.
 */

public class Grid implements Slider {


    /**
     * The size of the grid
     */
    private int gridSize;

    /**
     * The grid containing all the elements
     */
    private Element[][] grid;


    public Grid(int gridSize) {
        setGridSize(gridSize);
        grid = new Element[gridSize][gridSize];

        //Initialise the grid with new elements
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = new Element(getGridSize());
            }
        }

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
        mergeLine(0);
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
}
