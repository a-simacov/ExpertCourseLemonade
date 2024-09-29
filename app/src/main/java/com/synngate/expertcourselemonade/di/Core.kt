package ru.easycode.expertcoursequizgame

import android.content.Context
import com.synngate.expertcourselemonade.di.ClearViewModel

class Core(context: Context, val clearViewModel: ClearViewModel) {

    val sharedPreferences = context.getSharedPreferences("LemonGameData", Context.MODE_PRIVATE)
}