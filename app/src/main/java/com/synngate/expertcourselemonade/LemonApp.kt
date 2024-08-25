package com.synngate.expertcourselemonade

import android.app.Application
import android.content.Context

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