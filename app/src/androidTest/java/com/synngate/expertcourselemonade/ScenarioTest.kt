package com.synngate.expertcourselemonade

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.synngate.expertcourselemonade.game.GamePage
import com.synngate.expertcourselemonade.load.LoadPage
import com.synngate.expertcourselemonade.start.StartPage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ScenarioTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun caseNumber1() {
        val startPage = StartPage()
        assertWithRecreate { startPage.assertInitState() }

        startPage.clickNewGame()
        startPage.assertDoesNotExist()

        val loadPage = LoadPage()
        assertWithRecreate { loadPage.assertProgressState() }

        loadPage.waitTillError()
        assertWithRecreate { loadPage.assertErrorState() }

        loadPage.clickRetry()
        assertWithRecreate { loadPage.assertProgressState() }

        loadPage.waitTillGone()
        loadPage.assertDoesNotExist()

        val gamePage = GamePage()
        assertWithRecreate { gamePage.assertLemonState() }

        gamePage.clickPicture()
        assertWithRecreate { gamePage.assertSqueezeState() }

        gamePage.clickPictureSeveralTimes()
        assertWithRecreate { gamePage.assertDrinkState() }

        gamePage.clickPicture()
        assertWithRecreate { gamePage.assertEmptyState() }

        gamePage.clickPicture()
        gamePage.assertDoesNotExist()

        assertWithRecreate { startPage.assertInitState() }
    }

    private fun assertWithRecreate(assertion: () -> Unit) {
        activityScenarioRule.scenario.recreate()
        assertion.invoke()
        activityScenarioRule.scenario.recreate()
    }
}