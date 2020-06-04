package com.example.android.androidjokeslib;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class JokeFragment extends Fragment {

    private String mJoke;

    public JokeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_joke, container, false);

        TextView jokeText = root.findViewById(R.id.tv_joke);
        jokeText.setText(mJoke);

        return root;
    }

    public void setJoke(String jokeText) {
        mJoke = jokeText;
    }
}