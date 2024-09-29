package com.synngate.expertcourselemonade.game.presentation

import com.synngate.expertcourselemonade.views.imagebutton.PictureButtonUiState
import com.synngate.expertcourselemonade.views.imagebutton.UpdatePictureButton
import com.synngate.expertcourselemonade.views.text.UpdateInstructionText

interface GameUiState {
    fun update(
        textView: UpdateInstructionText,
        imageButton: UpdatePictureButton
    )

    data class Base(val pictureResId: Int, val textResId: Int) : GameUiState {

        override fun update(textView: UpdateInstructionText, imageButton: UpdatePictureButton) {
            textView.update(textResId = textResId)
            imageButton.updateUi(uiState = PictureButtonUiState.Base(pictureResId = pictureResId))
        }
    }

    object Empty : GameUiState {

        override fun update(textView: UpdateInstructionText, imageButton: UpdatePictureButton) = Unit
    }
}
