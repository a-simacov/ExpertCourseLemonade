package com.synngate.expertcourselemonade.main

import com.synngate.expertcourselemonade.game.presentation.GameScreen
import com.synngate.expertcourselemonade.game.presentation.NavigateToGame

interface Navigation : NavigateToGame {

    fun navigate(screen: Screen)

    override fun navigateToGame() {
        navigate(GameScreen)
    }
}