package com.synngate.expertcourselemonade.views.imagebutton

import java.io.Serializable

interface PictureButtonUiState : Serializable {

    fun update(button: UpdatePictureButton)

    data class Base(val pictureResId: Int) : PictureButtonUiState {

        override fun update(button: UpdatePictureButton) {
            button.update(pictureResId = pictureResId)
        }
    }
}