package com.synngate.expertcourselemonade

import androidx.annotation.DrawableRes
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class ScenarioTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    private lateinit var gamePage: GamePage

    @Before
    fun setup() {
        gamePage = GamePage(pictureRes = R.drawable.lemon)
    }

    @Test
    fun caseNumber1() {
        gamePage.assertLemonState()

        gamePage.clickPicture()
        gamePage.assertSqueezeState()

        gamePage.clickPicture()
        gamePage.assertDrinkState()

        gamePage.clickPicture()
        gamePage.assertEmptyState()

        gamePage.clickPicture()
        gamePage.assertLemonState()
    }
}