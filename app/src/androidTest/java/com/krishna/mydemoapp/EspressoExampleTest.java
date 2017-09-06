package com.krishna.mydemoapp;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;

import com.krishna.mydemoapp.example.espresso.EspressoExample;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.krishna.mydemoapp.TaskoMatchers.withCompoundDrawable;
import static com.krishna.mydemoapp.TaskoMatchers.withTaskViewName;

/**
 * Created by parthdesai on 2017-09-04.
 */
@RunWith(AndroidJUnit4.class)
public class EspressoExampleTest {
    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    @Test
    public void shouldBeAbleToLaunchMainScreen() throws InterruptedException {
        onView(withId(R.id.espresso_example)).perform(click());

        for(int i =0;i<12;i++) {

            onView(withId(R.id.new_add)).perform(click());
            onView(withId(R.id.first_name)).perform(click());
            onView(withId(R.id.first_name)).perform(clearText());
            onView(withId(R.id.first_name)).perform(typeText("Foo "+i));

            onView(withId(R.id.second_name)).perform(click());
            onView(withId(R.id.second_name)).perform(clearText());
            onView(withId(R.id.second_name)).perform(typeText("Poo "+i));
            onView(withId(R.id.second_name)).perform(closeSoftKeyboard());
            onView(withId(R.id.add)).perform(click());
        }
        onView(withText("Foo 1")).check(matches(isDisplayed()));
//        onView(withId(R.id.recycler_view))
//                .perform(RecyclerViewActions.scrollToPosition(11));
//        onView(withText("Foo 11")).check(matches(isDisplayed()));
        onView(withId(R.id.recycler_view))
                .perform(RecyclerViewActions.scrollTo(withTaskViewName("Foo 10")));

        Thread.sleep(1500);
    }
    @Test
    public void shouldBeAbleToLaunchMainIcon(){
        onView(withId(R.id.espresso_example)).perform(click());
        onView(withId(R.id.new_add)).perform(click());
        onView(withCompoundDrawable(R.mipmap.ic_launcher_round)).check(matches(isDisplayed()));
        onView(withId(R.id.simple_text)).check(matches(withCompoundDrawable(R.mipmap.ic_launcher_round)))
                .check(matches(withText(R.string.test_espresso)));
    }
    //-open terminal
    //-open uiautomatorviewer
    //path- cd ~/Library/Android/sdk/tools

}
