package model;

import com.example.projectone.R;

import java.util.ArrayList;

public class exerciseModel {

    private ArrayList<exercise> exercises = new ArrayList<>();

    public exerciseModel(){
        exercises.add(new exercise("exercise 1","Day 1", R.drawable.exercise1));
        exercises.add(new exercise("exercise 2","Day 1", R.drawable.exercise2 ));
        exercises.add(new exercise("exercise 3","Day 1", R.drawable.exercise3 ));
        exercises.add(new exercise("exercise 4","Day 1",  R.drawable.exercise4 ));
        exercises.add(new exercise("exercise 5","Day 1",  R.drawable.exercise5));
        exercises.add(new exercise("exercise 6","Day 1",  R.drawable.exercise6));
        exercises.add(new exercise("exercise 7","Day 1",  R.drawable.exercise7));
        exercises.add(new exercise("exercise 8","Day 1",  R.drawable.exercise8));
        exercises.add(new exercise("exercise 1","Day 2",  R.drawable.exercise9));
        exercises.add(new exercise("exercise 2","Day 2",  R.drawable.exercise10));
        exercises.add(new exercise("exercise 3","Day 2",  R.drawable.exercise11 ));
        exercises.add(new exercise("exercise 1","Day 3",  R.drawable.exercise12 ));
        exercises.add(new exercise("exercise 2","Day 3",  R.drawable.exercise13));
        exercises.add(new exercise("exercise 3","Day 3",  R.drawable.exercise14));
        exercises.add(new exercise("exercise 4","Day 3",  R.drawable.exercise15));
        exercises.add(new exercise("exercise 1","Day 4", R.drawable.exercise16));
        exercises.add(new exercise("exercise 2","Day 4",  R.drawable.exercise17));
        exercises.add(new exercise("exercise 3","Day 4",  R.drawable.exercise18));
        exercises.add(new exercise("exercise 4","Day 4",  R.drawable.exercise19));
        exercises.add(new exercise("exercise 1","Day 5",  R.drawable.exercise20));
        exercises.add(new exercise("exercise 2","Day 5",  R.drawable.exercise21));
        exercises.add(new exercise("exercise 3","Day 6",  R.drawable.exercise22 ));
        exercises.add(new exercise("exercise 4","Day 6", R.drawable.exercise23));
        exercises.add(new exercise("exercise 1","Day 7",  R.drawable.exercise24 ));
        exercises.add(new exercise("exercise 2","Day 7",  R.drawable.exercise25 ));
        exercises.add(new exercise("exercise 3","Day 7",  R.drawable.exercise26 ));
        exercises.add(new exercise("exercise 1","Day 8",  R.drawable.exercise27 ));
        exercises.add(new exercise("exercise 2","Day 8",  R.drawable.exercise28 ));
        exercises.add(new exercise("exercise 3","Day 8",  R.drawable.exercisee30 ));
        exercises.add(new exercise("exercise 1","Day 9",  R.drawable.exercise31));
        exercises.add(new exercise("exercise 2","Day 9",  R.drawable.exercise32 ));
        exercises.add(new exercise("exercise 1","Day 10",  R.drawable.exercise15 ));
        exercises.add(new exercise("exercise 2","Day 10",  R.drawable.exercise16 ));

    }

    public ArrayList<exercise> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<exercise> exercises) {
        this.exercises = exercises;
    }
}
