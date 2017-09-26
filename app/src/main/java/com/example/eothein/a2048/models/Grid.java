package com.example.eothein.a2048.models;

/**
 * Created by Jens Buysse & Karine Samyn on 26.09.17.
 */

public class Grid {


    /**
     * The size of the grid
     */
    private int gridSize;

    /**
     * The grid containing all the elements
     */
    private Element[][] grid;


    public Grid (int gridSize){
        setGridSize(gridSize);
        grid = new Element[gridSize][gridSize];

        //Initialise the grid with new elements
        for(int i  = 0; i< gridSize; i++){
            for(int j = 0; j< gridSize; j++){
                grid[i][j] = new Element(getGridSize());
            }
        }

    }

    /**
     * Return the element of this grid
     * @param i the row index
     * @param j the column index
     * @return the requested element
     */
    public Element getElement(int i, int j){
        return grid[i][j];
    }

    public int getGridSize() {
        return gridSize;
    }

    public void setGridSize(int gridSize) {
        if(gridSize<4)
            throw new IllegalArgumentException("The grid size cannot be less than 4");
        else
            this.gridSize = gridSize;
    }

    /**
     * Swipe right
     */
    public void swipeRight(){
        throw new UnsupportedOperationException("This operations is not yet supported");
    }

    /**
     * Swipe left
     */
    public void swipeLeft(){
        throw new UnsupportedOperationException("This operations is not yet supported");
    }

    /**
     * Swipe up
     */
    public void swipeUp(){
        throw new UnsupportedOperationException("This operations is not yet supported");
    }

    /**
     * Swipe down
     */
    public void switeDown(){
        throw new UnsupportedOperationException("This operations is not yet supported");
    }
}
