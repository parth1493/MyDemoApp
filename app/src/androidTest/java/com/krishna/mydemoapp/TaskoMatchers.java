package com.krishna.mydemoapp;


import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by parthdesai on 2017-09-05.
 */

public class TaskoMatchers {


    public static Matcher<View> withTaskViewName(final String expected) {
        return new TypeSafeMatcher<View>() {
            @Override
            protected boolean matchesSafely(View item) {
                if(item != null && item.findViewById(R.id.first_name)!= null){
                    TextView taskname = (TextView) item.findViewById(R.id.first_name);
                    if(TextUtils.isEmpty(taskname.getText())){
                        return false;
                    }else {
                        return taskname.getText().equals(expected);
                    }

                }else {
                    return false;
                }
            }

            @Override
            public void describeTo(Description description) {
            description.appendText("Looked for " + expected + " in the task_item.xml file");
            }
        };

    }
}