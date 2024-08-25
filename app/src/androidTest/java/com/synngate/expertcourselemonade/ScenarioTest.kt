package com.synngate.expertcourselemonade

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.synngate.expertcourselemonade.game.GamePage
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ScenarioTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    private lateinit var gamePage: GamePage
    private val timesToRepeat = 3

    @Before
    fun setup() {
        gamePage = GamePage()
    }

    @Test
    fun caseNumber1() {
        repeat(timesToRepeat) {
            assertWithRecreate { gamePage.assertLemonState() }

            gamePage.clickPictureSeveralTimes()
            assertWithRecreate { gamePage.assertSqueezeState() }

            gamePage.clickPicture()
            assertWithRecreate { gamePage.assertDrinkState() }

            gamePage.clickPicture()
            assertWithRecreate { gamePage.assertEmptyState() }

            gamePage.clickPicture()
        }
    }

    private fun assertWithRecreate(assertion: () -> Unit) {
        activityScenarioRule.scenario.recreate()
        assertion.invoke()
        activityScenarioRule.scenario.recreate()
    }
}