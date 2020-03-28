package com.example.sortingapp;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AppInterface extends RelativeLayout {

    private final int SIZE = 10;

    TextView[] numbers;

    public AppInterface(Context context, int screenHeight) {
        super(context);

        buildGui(context, screenHeight);

    }

    public void buildGui(Context context, int screenHeight){
        numbers = new TextView[10];

        numbers = new TextView[SIZE];

        for (int i = 0; i < SIZE; i++)
        {
            numbers[i] = new TextView(context);
            numbers[i].setId(TextView.generateViewId());
            numbers[i].setBackgroundColor(Color.parseColor("#009900"));
            numbers[i].setTextColor(Color.BLACK);
            numbers[i].setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
            numbers[i].setGravity(Gravity.CENTER);

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(0, 0);
            if (i > 0) params.addRule(RelativeLayout.BELOW, numbers[i-1].getId());
            params.width = LayoutParams.MATCH_PARENT;
            params.height = screenHeight/10;
            params.topMargin = 1;
            numbers[i].setLayoutParams(params);
            addView(numbers[i]);
        }
    }

    public void showCurrent(int[] current)
    {
        for (int i = 0; i < SIZE; i++)
            numbers[i].setText(current[i]+"");
    }

    public void stop()
    {
        for (int i = 0; i < SIZE; i++)
            numbers[i].setBackgroundColor(Color.parseColor("#990000"));
    }
}
