package com.synngate.expertcourselemonade.start

import android.widget.LinearLayout
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import com.synngate.expertcourselemonade.R
import com.synngate.expertcourselemonade.game.TextUi
import com.synngate.expertcourselemonade.load.ButtonUi
import org.hamcrest.CoreMatchers.allOf

class StartPage {

    private val parentMatcher = allOf(
        withParent(withId(R.id.rootLayout)),
        withParent(isAssignableFrom(LinearLayout::class.java))
    )

    private val titleUi = TextUi(
        id = R.id.newGameTitle,
        parentMatcher = parentMatcher
    )

    private val newGameUi = ButtonUi(
        id = R.id.newGameButton,
        textResId = R.string.new_game,
        parentMatcher = parentMatcher
    )

    fun assertInitState() {
        newGameUi.assertIsVisible()
        titleUi.assertIsVisible()
    }

    fun clickNewGame() {
        newGameUi.click()
    }

    fun assertDoesNotExist() {
        titleUi.assertDoesNotExist()
    }
}