package com.example.android.javajokeslib;

import java.util.ArrayList;

public class Jokes {

    public static String createJoke() {
        ArrayList<String> jokes = new ArrayList<>();
        jokes.add("What do you call 8 hobbits?\nA hobbyte");
        jokes.add("\"Knock, knock. Who's there?\"\nvery long pause...\n\"Java.\"");
        jokes.add("How many programmers does it take to change a light bulb?\n\"None. It's a hardware problem.");

        int jokeIndex = (int) (Math.random()*jokes.size());
        return jokes.get(jokeIndex);
    }
}