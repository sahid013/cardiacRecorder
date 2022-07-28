package com.example.cardiacrecorder_013_015;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.openLinkWithText;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.anything;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.cardiacrecorder_013_015.activity.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)

public class UITest {


    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);


    @Test
    public void testMain() {
        onView(withText("Previous Record History")).check(matches(isDisplayed())); //Check the name on the screen
    }



    @Test
    public void bottomFragementAppear() {
        onView(withId(R.id.addNewHealthRecord)).perform(click()); //Click add button to add a record
        onView(withText("Add Record")).check(matches(isDisplayed()));
    }

    @Test
    public void insertItem() {
        onView(withId(R.id.addNewHealthRecord)).perform(click()); //Click add button to add a record
        onView(withId(R.id.recordingDate)).perform(click());
        onView(withText("OK")).perform(click());
        onView(withId(R.id.recordingTime)).perform(click());
        onView(withText("OK")).perform(click());
        onView(withId(R.id.sysPressure)).perform(ViewActions.typeText("120"),pressImeActionButton());
        onView(withId(R.id.recordingDate)).perform(ViewActions.swipeUp());
        onView(withId(R.id.diaPressure)).perform(ViewActions.typeText("90"),pressImeActionButton());
        onView(withId(R.id.heartRate)).perform(ViewActions.typeText("72"),pressImeActionButton());
        onView(withId(R.id.overAllComment)).perform(ViewActions.typeText("Normal"));
        onView(withId(R.id.overAllComment)).perform(pressImeActionButton());
        onView(withId(R.id.addRecord)).perform(click());
    }

//    @Test
//    public void update() {
//        onView(withId(R.id.updateOrDeleteOption)).perform(click());
//        onView(withText("Update")).perform(click());
//        onView(withId(R.id.recordingDate)).perform(click());
//        onView(withText("CANCEL")).perform(click());
//        onView(withId(R.id.recordingTime)).perform(click());
//        onView(withText("CANCEL")).perform(click());
//        onView(withId(R.id.sysPressure)).perform(ViewActions.clearText(),ViewActions.typeText("120"),pressImeActionButton());
//        onView(withId(R.id.recordingDate)).perform(ViewActions.swipeUp());
//        onView(withId(R.id.diaPressure)).perform(ViewActions.clearText(),ViewActions.typeText("30"),pressImeActionButton());
//        onView(withId(R.id.heartRate)).perform(ViewActions.clearText(),ViewActions.typeText("150"),pressImeActionButton());
//        onView(withId(R.id.overAllComment)).perform(ViewActions.clearText(),ViewActions.typeText("Alarming"));
//        onView(withId(R.id.overAllComment)).perform(pressImeActionButton());
//        onView(withId(R.id.addRecord)).perform(click());
//
//    }

//    @Test
//    public void delete() {
//        onView(withId(R.id.updateOrDeleteOption)).perform(click());
//        onView(withText("Delete")).perform(click());
//        onView(withText("YES")).perform(click());
//    }
}
