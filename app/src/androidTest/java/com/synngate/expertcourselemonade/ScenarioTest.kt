package com.synngate.expertcourselemonade

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.synngate.expertcourselemonade.game.GamePage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ScenarioTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun caseNumber1() {
        val loadPage = LoadPage()
        assertWithRecreate { loadPage.assertInitState() }

        loadPage.clickNewGame()
        assertWithRecreate { loadPage.assertProgressState() }

        loadPage.waitTillError()
        assertWithRecreate { loadPage.assertErrorState() }

        loadPage.clickRetry()
        assertWithRecreate { loadPage.assertProgressState() }

        loadPage.waitTillGone()

        val gamePage = GamePage()

        assertWithRecreate { gamePage.assertLemonState() }

        gamePage.clickPicture()
        assertWithRecreate { gamePage.assertSqueezeState() }

        gamePage.clickPictureSeveralTimes()
        assertWithRecreate { gamePage.assertDrinkState() }

        gamePage.clickPicture()
        assertWithRecreate { gamePage.assertEmptyState() }

        gamePage.clickPicture()
        assertWithRecreate { loadPage.assertInitState() }
    }

    private fun assertWithRecreate(assertion: () -> Unit) {
        activityScenarioRule.scenario.recreate()
        assertion.invoke()
        activityScenarioRule.scenario.recreate()
    }
}