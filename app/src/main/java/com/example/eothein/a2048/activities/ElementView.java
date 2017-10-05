package com.example.eothein.a2048.activities;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.eothein.a2048.R;
import com.example.eothein.a2048.models.Element;

/**
 * Created by eothein on 26.09.17.
 */

public class ElementView extends FrameLayout {

    private Element element;

    private TextView textView;

    public ElementView(Context context, Element element) {
        super(context);
        initElementView(element);
    }


    public ElementView(@NonNull Context context, @Nullable AttributeSet attrs, Element element) {
        super(context, attrs);
        initElementView(element);
    }

    public ElementView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, Element element) {
        super(context, attrs, defStyleAttr);
        initElementView(element);
    }

    private void initElementView(Element element){
        this.element =element;
        LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.element, this, true);
        textView = (TextView)findViewById(R.id.number);

        updateElementView();
    }


    public void updateElementView(){
        if(element.getNumber() > 0) {
            textView.setText(Integer.toString(element.getNumber()));
        }else{
            textView.setText("");
        }

        textView.setTextColor(ContextCompat.getColor(getContext(),
                element.getNumber() <= 4
                        ? R.color.cardColorDark
                        : R.color.cardColorLight
        ));

        // Set background color based on the current value of the number
        //TODO: how to change background color while maintaining the frame around the FrameLayout
        //textView.setBackgroundColor(this.getBackgroundColor());

    }

    public int getBackgroundColor() {
        switch (element.getNumber()) {
            case 2: return Color.parseColor("#EEE4DA");
            case 4: return Color.parseColor("#EDE0C8");
            case 8: return Color.parseColor("#F2B179");
            case 16: return Color.parseColor("#F59563");
            case 32: return Color.parseColor("#F67C5F");
            case 64: return Color.parseColor("#F65E3B");
            case 128: return Color.parseColor("#EDCF72");
            case 256: return Color.parseColor("#EDCC61");
            case 512: return Color.parseColor("#EDC850");
            case 1024: return Color.parseColor("#EDC53F");
            case 2048: return Color.parseColor("#EDC22E");
        }

        return Color.parseColor("#CDC1B4");
    }



}
