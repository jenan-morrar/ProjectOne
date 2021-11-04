package model;

import com.example.projectone.R;

import java.util.ArrayList;

public class exerciseModel {

    private ArrayList<exercise> exercises = new ArrayList<>();

    public exerciseModel(){
        exercises.add(new exercise("exercise1","Day 1", "This exercise aims to tighten thigh fat, such that it needs 1 hours", R.drawable.exercise10 ));
        exercises.add(new exercise("exercise2","Day 1", "This exercise aims to reduce the the fat of belly and thighs, such that it needs 2 hours", R.drawable.exercise5 ));
        exercises.add(new exercise("exercise3","Day 1", "This exercise aims to strengthen belly's muscles and burn the fat of thighs, such that it needs 1 hours", R.drawable.exercise17 ));
        exercises.add(new exercise("exercise4","Day 1", "This exercise aims to build shoulder's muscles, such that it needs 1 hours", R.drawable.exercise8 ));
        exercises.add(new exercise("exercise5","Day 2", "This exercise aims to burn the fat , such that it needs 1.5 hours", R.drawable.exercise14));
        exercises.add(new exercise("exercise6","Day 2", "This exercise aims to relax the body , such that it needs 2 hours", R.drawable.exercise3 ));
        exercises.add(new exercise("exercise7","Day 2", "This exercises aim to warm up the body, such that it needs 1.5 hours", R.drawable.exercise1 ));
        exercises.add(new exercise("exercise8","Day 3", "This exercise aims build belly's and shoulder's muscles, such that it needs 1 hours", R.drawable.exercise11 ));
        exercises.add(new exercise("exercise9","Day 3", "This exercise aims to tighten the waist's fat, such that it needs 1 hours", R.drawable.exercise6 ));
        exercises.add(new exercise("exercise10","Day 4", "This exercise aims to strengthen the muscles of the shoulder and abdomen, such that it needs 1.5 hours", R.drawable.exercise2 ));
        exercises.add(new exercise("exercise11","Day 4", "This exercise aims to relax and worm up the body, such that it needs 1 hours", R.drawable.exercise4 ));
        exercises.add(new exercise("exercise12","Day 5", "This exercise aims to build the six bags , such that it needs 2 hours", R.drawable.exercise12 ));
        exercises.add(new exercise("exercise13","Day 5", "This exercise aims to build the muscles, such that it needs 1 hours", R.drawable.exercise9 ));
        exercises.add(new exercise("exercise14","Day 6", "This exercise aims to strengthen the muscles of shoulders, such that it needs 1 hours", R.drawable.exercise13 ));
        exercises.add(new exercise("exercise15","Day 6", "This exercise aims to strengthen the muscles of belly , such that it needs 1 hours", R.drawable.exercise14 ));
        exercises.add(new exercise("exercise16","Day 7", "This exercise aims to tighten the fat of thigh, such that it needs 1 hours", R.drawable.exercise15 ));
        exercises.add(new exercise("exercise17","Day 7", "This exercise aims to tighten thigh fat, such that it needs 1 hours", R.drawable.exercise16 ));

    }

    public ArrayList<exercise> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<exercise> exercises) {
        this.exercises = exercises;
    }
}
