package com.synngate.expertcourselemonade.load

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Matcher

class ButtonUi(
    id: Int,
    textResId: Int,
    parentMatcher: Matcher<View>,
) : AbstractButton(
    onView(
        allOf(
            parentMatcher,
            withId(id),
            withText(textResId)
        )
    )
) {

    fun assertIsNotVisible() {
        interaction.check(matches(not(isDisplayed())))
    }

    fun assertIsVisible() {
        interaction.check(matches(isDisplayed()))
    }
}

abstract class AbstractButton(
    protected val interaction: ViewInteraction
) {

    fun click() {
        interaction.perform(androidx.test.espresso.action.ViewActions.click())
    }
}