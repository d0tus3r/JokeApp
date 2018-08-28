package net.digitalswarm.mylibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class AndroidLibraryActivity extends AppCompatActivity{
    //textview for joke
    private TextView jokeTextView;
    private String cloudJoke;
    //key for intent
    public final static String CLOUD_JOKE_KEY = "CLOUD_JOKE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_library);
        //assign joke tv
        jokeTextView = findViewById(R.id.joke_text_view);
        //use string from GCE instance
        Intent cloudJokeIntent = getIntent();
        cloudJoke = cloudJokeIntent.getStringExtra(CLOUD_JOKE_KEY);
        jokeTextView.setText(cloudJoke);
    }
}
