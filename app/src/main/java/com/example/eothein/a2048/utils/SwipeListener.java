package com.example.eothein.a2048.utils;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Jens Buysse on 26.09.17.
 *
 * Based on the post: https://stackoverflow.com/questions/4139288/android-how-to-handle-right-to-left-swipe-gestures/12938787#12938787
 */

public class SwipeListener extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {

    private final GestureDetector gestureDetector;

    private static final int SWIPE_THRESHOLD = 100;
    private static final int SWIPE_VELOCITY_THRESHOLD = 100;

    public SwipeListener(Context context) {
        gestureDetector = new GestureDetector(context, this);
    }

    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent event) {
        return true;
    }

    @Override
    public boolean onFling(MotionEvent lhs, MotionEvent rhs, float velocityX, float velocityY) {
        boolean result = false;

        try {
            float diffY = rhs.getY() - lhs.getY();
            float diffX = rhs.getX() - lhs.getX();

            boolean isHorizontalSwipe = Math.abs(diffX) > Math.abs(diffY);

            if (isHorizontalSwipe) {
                if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX > 0) {
                        right();
                    } else {
                        left();
                    }
                }
            } else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                if (diffY > 0) {
                    down();
                } else {
                    up();
                }
            }

            result = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public void right() {
    }

    public void left() {
    }

    public void up() {
    }

    public void down() {
    }
}
