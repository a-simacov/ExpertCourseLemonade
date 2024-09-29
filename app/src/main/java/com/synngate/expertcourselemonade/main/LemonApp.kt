package com.synngate.expertcourselemonade.main

import android.app.Application
import com.synngate.expertcourselemonade.di.ClearViewModel
import com.synngate.expertcourselemonade.di.ManageViewModels
import com.synngate.expertcourselemonade.di.MyViewModel
import com.synngate.expertcourselemonade.di.ProvideViewModel
import ru.easycode.expertcoursequizgame.Core

class LemonApp : Application(), ProvideViewModel {

    private lateinit var factory: ManageViewModels

    override fun onCreate() {
        super.onCreate()

        val clearViewModel = object : ClearViewModel {
            override fun clear(viewModelClass: Class<out MyViewModel>) =
                factory.clear(viewModelClass)
        }
        val make = ProvideViewModel.Make(Core(this, clearViewModel))
        factory = ManageViewModels.Factory(make)
    }

    override fun <T : MyViewModel> makeViewModel(clasz: Class<T>): T =
        factory.makeViewModel(clasz)
}