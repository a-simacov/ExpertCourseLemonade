package com.synngate.expertcourselemonade.load

import android.view.View
import android.widget.ProgressBar
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.synngate.expertcourselemonade.R
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf

class ProgressUi(
    parentMatcher: Matcher<View>,
) {

    private val interaction: ViewInteraction = onView(
        allOf(
            withId(R.id.progressBar),
            isAssignableFrom(ProgressBar::class.java),
            parentMatcher
        )
    )

    fun assertIsVisible() {
        interaction.check(matches(isDisplayed()))
    }

    fun assertIsNotVisible() {
        interaction.check(matches(not(isDisplayed())))
    }
}