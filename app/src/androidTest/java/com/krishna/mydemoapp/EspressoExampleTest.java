package com.krishna.mydemoapp;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.krishna.mydemoapp.example.espresso.EspressoExample;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by parthdesai on 2017-09-04.
 */
@RunWith(AndroidJUnit4.class)
public class EspressoExampleTest {
    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    @Test
    public void shouldBeAbleToLaunchMainScreen(){
        onView(withId(R.id.espresso_example)).perform(click());
        onView(withId(R.id.new_add)).perform(click());
        onView(withId(R.id.first_name)).perform(click());
        onView(withId(R.id.first_name)).perform(typeText("Foo"));

        onView(withId(R.id.second_name)).perform(click());
        onView(withId(R.id.second_name)).perform(typeText("Poo"));
        onView(withId(R.id.second_name)).perform(closeSoftKeyboard());
        onView(withId(R.id.add)).perform(click());

    }

    //-open terminal
    //-open uiautomatorviewer
    //path- cd ~/Library/Android/sdk/tools

}
