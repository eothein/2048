package com.example.eothein.a2048.activities;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import com.example.eothein.a2048.R;
import com.example.eothein.a2048.models.Grid;

/**
 * Created by Jens Buysse & Karine Samun on 26.09.17.
 */

public class Board extends GridLayout {

    private Grid grid;

    public Board(Context context) {
        super(context);
        initBoard(context);
    }

    public Board(Context context, AttributeSet attrs) {
        super(context, attrs);
        initBoard(context);

    }

    public Board(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initBoard(context);

    }

    private void initBoard(Context context){
        grid = new Grid(4);

        this.setRowCount(grid.getGridSize());
        this.setColumnCount(grid.getGridSize());

        int width = calculateCardWidth();

        for(int i = 0; i< grid.getGridSize(); i++){
            for(int j= 0; j <grid.getGridSize(); j++){
                ElementView v = new ElementView(this.getContext(),grid.getElement(i,j));


                addView(v, width,width);
                Log.i("Info", "Added a view " + i + " " + j);
            }
        }
    }


    /**
     * Calculates the width and height of a card
     * @return The length of the side of the  square
     */
    private int calculateCardWidth(){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displayMetrics);
        return Math.min(displayMetrics.widthPixels,displayMetrics.heightPixels) / grid.getGridSize();
    }
}
