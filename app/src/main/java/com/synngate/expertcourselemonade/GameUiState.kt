package com.synngate.expertcourselemonade

import com.synngate.expertcourselemonade.databinding.ActivityMainBinding

interface GameUiState {

    fun update(binding: ActivityMainBinding)

    data class Base(val pictureResId: Int, val textResId: Int) : GameUiState {

        override fun update(binding: ActivityMainBinding) {
            binding.instructionTextView.setText(textResId)
            binding.gameImageButton.setImageResource(pictureResId)
            binding.gameImageButton.tag = pictureResId
        }
    }
}
