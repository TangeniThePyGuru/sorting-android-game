package com.example.sortingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    AppInterface appInterface;

    Game game;
    GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // initialise a new game object
        game = new Game();

        // draw interface
        appInterface = new AppInterface(this, screenHeight());
        setContentView(appInterface);

        appInterface.showCurrent(game.getArray(), game.getWindowLocation(), game.getMessage());
        TouchHandler temp = new TouchHandler();
        gestureDetector = new GestureDetector(this, temp);
    }

    private int screenHeight()
    {
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);

        int DP = (int)(getResources().getDisplayMetrics().density);

        return size.y - 130*DP;
    }


    public boolean onTouchEvent(MotionEvent event)
    {
        if (!game.isGameOver())
            gestureDetector.onTouchEvent(event);

        return true;
    }

    private class TouchHandler extends GestureDetector.SimpleOnGestureListener{

        public boolean onSingleTapConfirmed(MotionEvent event)
        {

            // slide window when user single clicks the interface
            game.move_window();
            appInterface.showCurrent(game.getArray(), game.getWindowLocation(), game.getMessage());

            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent event) {
            // swap the cells when user double clicks interface
            game.swap_window();
            appInterface.showCurrent(game.getArray(), game.getWindowLocation(), game.getMessage());
            // restore default color
            if (game.isGameOver()) appInterface.stop(game.getMessage());

            return true;
        }
    }
}
