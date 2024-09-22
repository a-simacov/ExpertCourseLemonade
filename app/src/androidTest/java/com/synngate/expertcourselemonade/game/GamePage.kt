package com.synngate.expertcourselemonade.game

import android.view.View
import android.widget.LinearLayout
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import com.synngate.expertcourselemonade.R
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher

class GamePage() {

    private val parentMatcher = allOf(
        withParent(withId(R.id.rootLayout)),
        withParent(isAssignableFrom(LinearLayout::class.java))
    )

    private val pictureUi = PictureUi(parentMatcher = parentMatcher)
    private val textUi = TextUi(
        id = R.id.instructionTextView,
        parentMatcher = parentMatcher
    )
    private val clickNumber = 3

    fun assertLemonState() {
        pictureUi.assertHasPicture(pictureResId = R.drawable.lemon)
        textUi.assertHasText(textResId = R.string.lemon)
    }

    fun assertSqueezeState() {
        pictureUi.assertHasPicture(pictureResId = R.drawable.squeeze)
        textUi.assertHasText(textResId = R.string.squeeze)
    }

    fun assertDrinkState() {
        pictureUi.assertHasPicture(pictureResId = R.drawable.drink)
        textUi.assertHasText(textResId = R.string.drink)
    }

    fun assertEmptyState() {
        pictureUi.assertHasPicture(pictureResId = R.drawable.empty)
        textUi.assertHasText(textResId = R.string.empty)
    }

    fun clickPicture() {
        pictureUi.click()
    }

    fun clickPictureSeveralTimes() {
        repeat(clickNumber) {
            clickPicture()
        }
    }

    fun assertDoesNotExist() {
        textUi.assertDoesNotExist()
    }
}