package com.example.sortingapp;

import java.util.Arrays;
import java.util.Random;

public class Game {

    private final int SIZE = 10;
    private int[] solution;
    private Random random;
    private int[] problem;
    private int numberOfSwaps = 0;
    private int windowLocation = 0;
    private boolean gameOver = false;

    public Game (){

        random = new Random();

        problem = new int[SIZE];
        solution = new int[SIZE];

        generate_problem();
        sort_solution();
    }

    public void move_window(){
        // move the current
        if (windowLocation <= SIZE - 2)
            windowLocation ++;
        else {
            windowLocation = 0;
        }
    }

    public int[] getArray(){
        // get the current array
        return this.getProblem();
    }

    public void swap_window(){

        // swap the two locations
        int temp = problem[windowLocation];
        problem[windowLocation] = problem[windowLocation+1];
        problem[windowLocation+1] = temp;

        // increment the number of swaps
        if (numberOfSwaps < 45)
            numberOfSwaps++;
        else
            gameOver = true;

    }

    public int getWindowLocation(){
        // get the current window location
        return windowLocation;
    }

    public String getMessage(){
        // get a message on the status of the
        if (gameOver){
            if (numberOfSwaps < 45) return "Won the game!";
            else return "Lost the game!";
        }
        return (45 - numberOfSwaps) + " swaps left";
    }

    private void generate_problem(){
        // no duplicates should
        // generate a random problem with 10 numbers
        for (int i = 0; i < SIZE; i++) {

            int key;

            start :
            {
                key = random.nextInt(100);
                // there should never be duplicates
                // if there is go back to the start label and generate a new number
                // zero should not be accepted
                if (exists(problem, key) || key == 0) {
                    break start;
                } else {
                    problem[i] = key;
                }
            }
        }
    }

    private void sort_solution(){
        // sort the problem to find the solution
        solution = problem.clone();
        Arrays.sort(solution);
    }
        // return the problem
    public int[] getProblem() {
        return problem;
    }
        // return the solution
    public int[] getSolution() {
        return solution;
    }

    // Function return true if given element
    // found in array
    private boolean exists(int[] arr, int toCheckValue)
    {
        // check if the specified element
        // is present in the array or not
        // using Linear Search method
        boolean test = false;
        for (int element : arr) {
            if (element == toCheckValue) {
                test = true;
                break;
            }
        }

        return test;
    }
}
