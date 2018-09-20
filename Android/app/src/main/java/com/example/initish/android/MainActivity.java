package com.example.initish.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mnames = new ArrayList<>();
    private ArrayList<String> text = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getText();
    }

    private void getText(){

        mnames.add("TIC-TAC-TOE");
        mnames.add("KNOW YOUR WEATHER");
        mnames.add("CURRENCY CONVERTER");
        mnames.add("BRAIN TRAINER");
        mnames.add("TIMER APP");

        text.add("Challenge your friend to a game of Tic-Tac-Toe");
        text.add("Enter the city and know its live weather conditions");
        text.add("Use it to convert dollars to rupees");
        text.add("Train your brain by solving quick maths problems");
        text.add("Set the timer and be productive");

        initRecyclerView();

    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mnames, text);
        recyclerView.setAdapter(adapter);
    }
}

