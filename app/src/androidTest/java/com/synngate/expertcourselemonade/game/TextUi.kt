package com.synngate.expertcourselemonade.game

import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isRoot
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.synngate.expertcourselemonade.R
import com.synngate.expertcourselemonade.waitTillDisplayed
import com.synngate.expertcourselemonade.waitTillDoesntExist
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Matcher

class TextUi(
    private val id: Int,
    parentMatcher: Matcher<View>
) {

    private val interaction: ViewInteraction = onView(
        allOf(
            parentMatcher,
            withId(id),
            isAssignableFrom(TextView::class.java)
        )
    )

    fun assertIsVisible() {
        interaction.check(matches(isDisplayed()))
    }

    fun assertIsNotVisible() {
        interaction.check(matches(not(isDisplayed())))
    }

    fun assertDoesNotExist() {
        interaction.check(doesNotExist())
    }

    fun assertHasText(textResId: Int) {
        interaction.check(matches(isDisplayed()))
            .check(matches(withText(textResId)))
    }

    fun waitTillVisible() {
        onView(isRoot()).perform(waitTillDisplayed(id, 4000))
    }

    fun waitTillDoesntExist() {
        onView(isRoot()).perform(waitTillDoesntExist(id, 4000))
    }
}