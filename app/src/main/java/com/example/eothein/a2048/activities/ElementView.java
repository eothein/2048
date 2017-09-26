package com.example.eothein.a2048.activities;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
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
        textView.setText(Integer.toString(element.getNumber()));
    }



}
