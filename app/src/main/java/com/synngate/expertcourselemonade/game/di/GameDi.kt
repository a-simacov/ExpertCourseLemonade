package com.synngate.expertcourselemonade.game.di

import com.synngate.expertcourselemonade.di.AbstractProvideViewModel
import com.synngate.expertcourselemonade.di.Module
import com.synngate.expertcourselemonade.di.ProvideViewModel
import com.synngate.expertcourselemonade.game.data.GameRepository
import com.synngate.expertcourselemonade.game.presentation.GameViewModel
import com.synngate.expertcourselemonade.main.IntCache
import ru.easycode.expertcoursequizgame.Core

class GameModule(private val core: Core) : Module<GameViewModel> {

    override fun viewModel() = GameViewModel(
        repository = GameRepository.Base(
            index = IntCache.Base(core.sharedPreferences, "indexKey", 0),
            tapsToSqueeze = IntCache.Base(core.sharedPreferences, "tapsToSqueezeKey", 0),
            squeezeTapped = IntCache.Base(core.sharedPreferences, "squeezeTappedKey", 0),
        ),
        clearViewModel = core.clearViewModel
    )
}

class ProvideGameViewModel(core: Core, next: ProvideViewModel) :
    AbstractProvideViewModel(core, next, GameViewModel::class.java) {

    override fun module(): Module<*> = GameModule(core)
}