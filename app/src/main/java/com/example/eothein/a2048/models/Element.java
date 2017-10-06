package com.example.eothein.a2048.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Jens Buysse & Karine Samyn on 26.09.17.
 */

public class Element {


    /**
     * Number representing the element. An element representing an empty value receives the value of
     * -1.
     */
    private int number = -1;


    public Element() {
        this.number = -1;
    }

    /**
     * Creates an element. The gridsize allows the number of the element to be between -1 and
     * grid size
     * @param gridSize the maximum number the element can contain
     */
    public Element(int gridSize){
        Random r = new Random();
        boolean empty = r.nextBoolean();
        if(empty){
            this.number = -1;
        }else{
            this.number = r.nextInt(gridSize);
        }

    }

    /**
     * Returns the number of this element
     * @return the number of this element
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets the number for this element
     * @param number the number of this element
     */
    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isEmpty(){
        return this.number == -1;
    }

    @Override
    public String toString() {
        if (number == -1) {
            return "" + 0;
        } else {
            return "" +
                    number
                    ;
        }
    }
}
