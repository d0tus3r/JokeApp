package com.udacity.gradle.builditbigger.backend;

import net.digitalswarm.joke.Jokes;
/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myJoke;

    public String getJoke() {
        myJoke = new Jokes().generateJoke();
        return myJoke;
    }
}