package com.synngate.expertcourselemonade.game

import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.synngate.expertcourselemonade.R
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher

class TextUi(
    containerIdMatcher: Matcher<View>,
    containerClassTypeMatcher: Matcher<View>
) {

    private val interaction: ViewInteraction = onView(
        allOf(
            containerIdMatcher,
            containerClassTypeMatcher,
            withId(R.id.instructionTextView),
            isAssignableFrom(TextView::class.java)
        )
    )

    fun assertHasText(textResId: Int) {
        interaction.check(matches(isDisplayed()))
            .check(matches(withText(textResId)))
    }
}