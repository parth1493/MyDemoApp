package com.krishna.mydemoapp;

import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.krishna.mydemoapp.example.espresso.EspressoExample;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by parthdesai on 2017-09-04.
 */
@RunWith(AndroidJUnit4.class)
public class EspressoExampleTest {
    @Rule
    public ActivityTestRule<EspressoExample> activityActivityTestRule = new ActivityTestRule<EspressoExample>(EspressoExample.class);
    @Test
    public void shouldBeAbleToLaunchMainScreen(){
        onView(withId(R.id.hello)).perform(click());
    }

    //-open terminal
    //-open uiautomatorviewer
    //path- cd ~/Library/Android/sdk/tools

}
