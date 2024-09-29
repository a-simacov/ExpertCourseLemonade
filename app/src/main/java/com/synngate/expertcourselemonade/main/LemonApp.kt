package com.synngate.expertcourselemonade.main

import android.app.Application
import android.content.Context
import com.synngate.expertcourselemonade.game.data.GameRepository
import com.synngate.expertcourselemonade.game.presentation.GameViewModel

class LemonApp : Application() {

    lateinit var viewModel: GameViewModel

    override fun onCreate() {
        super.onCreate()

        val sharedPreferences =
            applicationContext.getSharedPreferences("LemonGameData", Context.MODE_PRIVATE)

        viewModel = GameViewModel(
            repository = GameRepository.Base(
                index = IntCache.Base(sharedPreferences, "indexKey", 0),
                tapsToSqueeze = IntCache.Base(sharedPreferences, "tapsToSqueezeKey", 0),
                squeezeTapped = IntCache.Base(sharedPreferences, "squeezeTappedKey", 0),
            )
        )
    }
}