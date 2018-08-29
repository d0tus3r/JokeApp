package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public final ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void asyncTest() {
        onView(withId(R.id.joke_button)).perform(click());
        //test to confirm textView isn't an empty string
        //inspired by https://stackoverflow.com/questions/46598149/test-a-textview-value-is-not-empty-using-espresso-and-fail-if-a-textview-value-i/46598289#46598289
        onView(withId(R.id.joke_text_view)).check(matches(not(withText(""))));
    }

}