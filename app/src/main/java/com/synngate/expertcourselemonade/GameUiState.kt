package com.synngate.expertcourselemonade

import androidx.appcompat.content.res.AppCompatResources
import com.synngate.expertcourselemonade.R.*
import com.synngate.expertcourselemonade.databinding.ActivityMainBinding

interface GameUiState {

    fun update(binding: ActivityMainBinding): Unit = throw IllegalStateException("todo") // todo

    data class Base(val pictureResId: Int, val textResId: Int) : GameUiState
}
