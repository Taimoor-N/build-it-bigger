package com.example.android.androidjokeslib;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.android.androidjokeslib.util.Constants;

public class JokeActivity extends AppCompatActivity {

    private String mJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        if (savedInstanceState == null) {
            Intent intent = getIntent();
            mJoke = intent.getStringExtra(Constants.INTENT_JOKE_TEXT);
            createAndAddJokeFragmentWithJoke(mJoke);
        } else {
            mJoke = savedInstanceState.getString(Constants.SAVE_INSTANCE_JOKE_TEXT);
            createAndAddJokeFragmentWithJoke(mJoke);
        }
    }

    private void createAndAddJokeFragmentWithJoke(String joke) {
        JokeFragment jokeFragment = new JokeFragment();
        jokeFragment.setJoke(joke);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.joke_container, jokeFragment)
                .commit();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle currentState) {
        super.onSaveInstanceState(currentState);
        currentState.putString(Constants.SAVE_INSTANCE_JOKE_TEXT, mJoke);
    }
}