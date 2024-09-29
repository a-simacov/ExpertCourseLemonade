package com.synngate.expertcourselemonade.di

import com.synngate.expertcourselemonade.game.di.ProvideGameViewModel
import ru.easycode.expertcoursequizgame.Core

interface ProvideViewModel {

    fun <T : MyViewModel> makeViewModel(clasz: Class<T>): T

    class Make(core: Core) : ProvideViewModel {

        private var chain: ProvideViewModel

        init {
            chain = Error()
            chain = ProvideGameViewModel(core, chain)
        }

        override fun <T : MyViewModel> makeViewModel(clasz: Class<T>): T =
            chain.makeViewModel(clasz)
    }

    class Error : ProvideViewModel {

        override fun <T : MyViewModel> makeViewModel(clasz: Class<T>): T {
            throw IllegalStateException("unknown class $clasz")
        }
    }
}