package com.example.sortingapp;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.GridLayout;
import android.widget.TextView;

public class AppInterface extends GridLayout {

    private final int SIZE = 10;

    TextView[] numbers;
    TextView message;

    public AppInterface(Context context, int screenHeight) {
        super(context);

        setRowCount(11);
        setColumnCount(3);

        buildGui(context, screenHeight);

    }

    public void buildGui(Context context, int screenHeight){
        numbers = new TextView[10];
        numbers = new TextView[SIZE];
        int i = 0;

        for (i = 0; i < SIZE; i++)
        {
            numbers[i] = new TextView(context);
            numbers[i].setId(TextView.generateViewId());
            numbers[i].setBackgroundColor(Color.parseColor("#009900"));
            numbers[i].setTextColor(Color.BLACK);
            numbers[i].setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
            numbers[i].setGravity(Gravity.CENTER);
            numbers[i].setTextSize(13);

            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = LayoutParams.MATCH_PARENT;
            params.height = screenHeight/15;
            params.rowSpec = GridLayout.spec(i, 1);
            params.columnSpec = GridLayout.spec(1, 1);
            params.setMargins(10,5,10,5);
            numbers[i].setLayoutParams(params);
            addView(numbers[i]);
        }

        message = new TextView(context);
        message.setId(TextView.generateViewId());
        message.setBackgroundColor(Color.GRAY);
        message.setTextColor(Color.BLACK);
        message.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
        message.setGravity(Gravity.CENTER);
        message.setText("45 swaps left");

        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.width = LayoutParams.MATCH_PARENT;
        params.height = screenHeight/10;
        params.rowSpec = GridLayout.spec(i, 1);
        params.columnSpec = GridLayout.spec(1, 1);
        params.topMargin = 1;
        params.setMargins(10,10,10,20);
        message.setLayoutParams(params);
        addView(message);




    }

    public void showCurrent(int[] current, int windowLocation, String message)
    {
        for (int i = 0; i < SIZE; i++) {
            numbers[i].setText(current[i] + "");

            // color code the window
            if (i == windowLocation || i == windowLocation + 1)
                numbers[i].setBackgroundColor(Color.YELLOW);
        }

        // set the current message for the game
        this.message.setText(message);
    }

    public void stop()
    {
        for (int i = 0; i < SIZE; i++)
            numbers[i].setBackgroundColor(Color.parseColor("#990000"));
    }
}
