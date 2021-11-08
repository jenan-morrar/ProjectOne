package model;

import com.example.projectone.R;

import java.util.ArrayList;

public class exerciseModel {

    private ArrayList<exercise> exercises = new ArrayList<>();

    public exerciseModel(){
        exercises.add(new exercise("Qardio","Day 1", R.drawable.exercise1));
        exercises.add(new exercise("exercise2","Day 1", R.drawable.exercise5 ));
        exercises.add(new exercise("exercise3","Day 1", R.drawable.exercise17 ));
        exercises.add(new exercise("exercise4","Day 1",  R.drawable.exercise8 ));
        exercises.add(new exercise("exercise5","Day 2",  R.drawable.exercise14));
        exercises.add(new exercise("exercise6","Day 2",  R.drawable.exercise3 ));
        exercises.add(new exercise("exercise7","Day 2",  R.drawable.exercise1 ));
        exercises.add(new exercise("exercise8","Day 3",  R.drawable.exercise11 ));
        exercises.add(new exercise("exercise9","Day 3",  R.drawable.exercise6 ));
        exercises.add(new exercise("exercise10","Day 4", R.drawable.exercise2 ));
        exercises.add(new exercise("exercise11","Day 4",  R.drawable.exercise4 ));
        exercises.add(new exercise("exercise12","Day 5",  R.drawable.exercise12 ));
        exercises.add(new exercise("exercise13","Day 5",  R.drawable.exercise9 ));
        exercises.add(new exercise("exercise14","Day 6",  R.drawable.exercise13 ));
        exercises.add(new exercise("exercise15","Day 6", R.drawable.exercise14 ));
        exercises.add(new exercise("exercise16","Day 7",  R.drawable.exercise15 ));
        exercises.add(new exercise("exercise17","Day 7",  R.drawable.exercise16 ));

    }

    public ArrayList<exercise> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<exercise> exercises) {
        this.exercises = exercises;
    }
}
