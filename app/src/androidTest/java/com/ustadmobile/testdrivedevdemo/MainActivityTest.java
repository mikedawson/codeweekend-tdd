package com.ustadmobile.testdrivedevdemo;

import android.content.Context;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.contrib.PickerActions;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Test
    public void givenUserIsChild_whenNextClicked_thenShouldGoToChildActivity() {
        ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.datePicker)).perform(PickerActions.setDate(2015, 1, 1));
        onView(withId(R.id.button)).perform(click());
        onView(withText("You are a child")).check(matches(isDisplayed()));
    }

    @Test
    public void givenUserIsAdult_whenNextClicked_thenShouldGoToAdultActivity() {
        ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.datePicker)).perform(PickerActions.setDate(1995, 1, 1));
        onView(withId(R.id.button)).perform(click());
        onView(withText("You are an adult")).check(matches(isDisplayed()));
    }


    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.ustadmobile.testdrivedevdemo", appContext.getPackageName());
    }
}