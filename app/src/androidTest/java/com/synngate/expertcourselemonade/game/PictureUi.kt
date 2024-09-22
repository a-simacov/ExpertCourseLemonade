package com.synngate.expertcourselemonade.game

import android.view.View
import android.widget.ImageButton
import androidx.annotation.DrawableRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.synngate.expertcourselemonade.DrawableResMatcher
import com.synngate.expertcourselemonade.R
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher

class PictureUi(
    parentMatcher: Matcher<View>
) {

    private val interaction: ViewInteraction = onView(
        allOf(
            parentMatcher,
            withId(R.id.gameImageButton),
            isAssignableFrom(ImageButton::class.java),
        )
    )

    fun assertHasPicture(@DrawableRes pictureResId: Int) {
        interaction.check(matches(isDisplayed()))
            .check(matches(DrawableResMatcher(pictureResId)))
    }

    fun click() {
        interaction.perform(androidx.test.espresso.action.ViewActions.click())
    }
}