package com.example.matsevytyi03;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4ClassRunner.class)
public class AppTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void InputTest() {

        //one digit
        Espresso.onView(withId(R.id.inpt5)).perform(ViewActions.click());

        Espresso.onView(withId(R.id.outputWindow))
                .check(matches(isDisplayed()))
                .check(matches(withText("5")));

        //clear field with 1 char
        Espresso.onView(withId(R.id.actClear)).perform(ViewActions.click());

        Espresso.onView(withId(R.id.outputWindow))
                .check(matches(isDisplayed()))
                .check(matches(withText("")));

        //3 digits
        Espresso.onView(withId(R.id.inpt1)).perform(ViewActions.click());
        Espresso.onView(withId(R.id.inpt2)).perform(ViewActions.click());
        Espresso.onView(withId(R.id.inpt3)).perform(ViewActions.click());

        Espresso.onView(withId(R.id.outputWindow))
                .check(matches(isDisplayed()))
                .check(matches(withText("123")));

        //backspace
        Espresso.onView(withId(R.id.actBack)).perform(ViewActions.click());

        Espresso.onView(withId(R.id.outputWindow))
                .check(matches(isDisplayed()))
                .check(matches(withText("12")));


        //clear field with >1 char
        Espresso.onView(withId(R.id.actClear)).perform(ViewActions.click());

        Espresso.onView(withId(R.id.outputWindow))
                .check(matches(isDisplayed()))
                .check(matches(withText("")));
    }

    @Test
    public void BasicArithmeticTest() {

        //adition
        Espresso.onView(ViewMatchers.withId(R.id.outputWindow))
                .perform(ViewActions.replaceText("5"), ViewActions.closeSoftKeyboard());

        Espresso.onView(withId(R.id.operPlus)).perform(ViewActions.click());

        Espresso.onView(withId(R.id.outputWindow)).perform(ViewActions.replaceText("3"), ViewActions.closeSoftKeyboard());

        Espresso.onView(withId(R.id.actCalc)).perform(ViewActions.click());

        Espresso.onView(withId(R.id.outputWindow))
                .check(matches(isDisplayed()))
                .check(matches(withText("8")));


        //subtraction
        Espresso.onView(withId(R.id.operMin)).perform(ViewActions.click());

        Espresso.onView(withId(R.id.outputWindow)).perform(ViewActions.replaceText("2"), ViewActions.closeSoftKeyboard());

        Espresso.onView(withId(R.id.actCalc)).perform(ViewActions.click());

        Espresso.onView(withId(R.id.outputWindow))
                .check(matches(isDisplayed()))
                .check(matches(withText("6")));

        //multiplication
        Espresso.onView(withId(R.id.actMult)).perform(ViewActions.click());

        Espresso.onView(withId(R.id.outputWindow)).perform(ViewActions.replaceText("2"), ViewActions.closeSoftKeyboard());

        Espresso.onView(withId(R.id.actCalc)).perform(ViewActions.click());

        Espresso.onView(withId(R.id.outputWindow))
                .check(matches(isDisplayed()))
                .check(matches(withText("12")));

        //division
        Espresso.onView(withId(R.id.operDiv)).perform(ViewActions.click());

        Espresso.onView(withId(R.id.outputWindow)).perform(ViewActions.replaceText("2"), ViewActions.closeSoftKeyboard());

        Espresso.onView(withId(R.id.actCalc)).perform(ViewActions.click());

        Espresso.onView(withId(R.id.outputWindow))
                .check(matches(isDisplayed()))
                .check(matches(withText("6")));
    }

    @Test
    public void AdvancedArithmeticTest() {

        //change sign x1
        Espresso.onView(withId(R.id.outputWindow)).perform(ViewActions.replaceText("16"), ViewActions.closeSoftKeyboard());

        Espresso.onView(withId(R.id.actChangeSign)).perform(ViewActions.click());

        Espresso.onView(withId(R.id.outputWindow))
                .check(matches(isDisplayed()))
                .check(matches(withText("-16")));


        //change signx2
        Espresso.onView(withId(R.id.outputWindow)).perform(ViewActions.replaceText("-16"), ViewActions.closeSoftKeyboard());

        Espresso.onView(withId(R.id.actChangeSign)).perform(ViewActions.click());

        Espresso.onView(withId(R.id.outputWindow))
                .check(matches(isDisplayed()))
                .check(matches(withText("16")));

       //sqrt
        Espresso.onView(withId(R.id.operSqrt)).perform(ViewActions.click());

        Espresso.onView(withId(R.id.outputWindow))
                .check(matches(isDisplayed()))
                .check(matches(withText("4")));
    }

    @Test
    public void UnallowedOperationsTest() {

        //sqrt from -1
        Espresso.onView(withId(R.id.outputWindow)).perform(ViewActions.replaceText("-1"), ViewActions.closeSoftKeyboard());
        Espresso.onView(withId(R.id.operSqrt)).perform(ViewActions.click());

        Espresso.onView(withId(R.id.outputWindow))
                .check(matches(isDisplayed()))
                .check(matches(withText("NaN")));

        //division by 0
        Espresso.onView(withId(R.id.outputWindow)).perform(ViewActions.replaceText("10"), ViewActions.closeSoftKeyboard());
        Espresso.onView(withId(R.id.operDiv)).perform(ViewActions.click());
        Espresso.onView(withId(R.id.outputWindow)).perform(ViewActions.replaceText("0"), ViewActions.closeSoftKeyboard());
        Espresso.onView(withId(R.id.actCalc)).perform(ViewActions.click());

        Espresso.onView(withId(R.id.outputWindow))
                .check(matches(isDisplayed()))
                .check(matches(withText("Infinity")));
    }

}
