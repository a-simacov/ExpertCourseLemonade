package com.synngate.expertcourselemonade.load

import android.widget.LinearLayout
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import com.synngate.expertcourselemonade.R
import com.synngate.expertcourselemonade.game.TextUi
import org.hamcrest.CoreMatchers.allOf

class LoadPage {

    private val parentMatcher = allOf(
        withParent(withId(R.id.rootLayout)),
        withParent(isAssignableFrom(LinearLayout::class.java))
    )

    private val titleUi = TextUi(
        id = R.id.loadingTitle,
        parentMatcher = parentMatcher
    )

    private val retryUi = ButtonUi(
        id = R.id.retryButton,
        textResId = R.string.retry,
        parentMatcher = parentMatcher
    )

    private val errorUi = TextUi(
        id = R.id.errorText,
        parentMatcher = parentMatcher
    )

    private val progressUi = ProgressUi(parentMatcher = parentMatcher)

    private val imagesTextUi = TextUi(
        R.id.imagesText,
        parentMatcher = parentMatcher
    )

    fun assertProgressState() {
        titleUi.assertIsVisible()
        progressUi.assertIsVisible()
        imagesTextUi.assertIsVisible()

        retryUi.assertIsNotVisible()
        errorUi.assertIsNotVisible()
    }

    fun assertErrorState() {
        titleUi.assertIsVisible()
        retryUi.assertIsVisible()
        errorUi.assertIsVisible()

        progressUi.assertIsNotVisible()
        imagesTextUi.assertIsNotVisible()
    }

    fun clickRetry() {
        retryUi.click()
    }

    fun assertDoesNotExist() {
        titleUi.assertDoesNotExist()
    }

    fun waitTillError() {
        errorUi.waitTillVisible()
    }

    fun waitTillGone() {
        errorUi.waitTillDoesntExist()
    }
}