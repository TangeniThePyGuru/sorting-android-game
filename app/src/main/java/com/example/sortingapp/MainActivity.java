package com.example.sortingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    AppInterface appInterface;
    private boolean gameOver;

    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // initialise a new game object
        game = new Game();

        // draw interface
        appInterface = new AppInterface(this, screenHeight());
        setContentView(appInterface);
        int [] x = new int[10];


        appInterface.showCurrent(game.getProblem());

    }

    private int screenHeight()
    {
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);

        int DP = (int)(getResources().getDisplayMetrics().density);

        return size.y - 130*DP;
    }
}
