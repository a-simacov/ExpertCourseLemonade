package com.synngate.expertcourselemonade

import android.view.View
import android.widget.ImageButton
import androidx.annotation.DrawableRes
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description

class DrawableResMatcher(@DrawableRes private val drawableRes: Int) :
    BoundedMatcher<View, ImageButton>(ImageButton::class.java) {

    override fun describeTo(description: Description) {
        description.appendText("drawable resource for button doesn't match $drawableRes")
    }

    override fun matchesSafely(item: ImageButton): Boolean {
        return item.tag == drawableRes
    }
}