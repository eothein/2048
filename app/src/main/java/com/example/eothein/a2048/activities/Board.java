package com.example.eothein.a2048.activities;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import com.example.eothein.a2048.R;
import com.example.eothein.a2048.models.Grid;

/**
 * Created by eothein on 26.09.17.
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

        this.setRowCount(4);
        this.setColumnCount(4);
        this.setlayout
        for(int i = 0; i< grid.getGridSize(); i++){
            for(int j= 0; j <grid.getGridSize(); j++){
                ElementView v = new ElementView(this.getContext(),grid.getElement(i,j));


                addView(v);
                Log.i("Info", "Added a view " + i + " " + j);
            }
        }
    }
}
