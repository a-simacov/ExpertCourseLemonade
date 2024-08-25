package com.synngate.expertcourselemonade.views.imagebutton

interface PictureButtonUiState {

    fun update(button: UpdatePictureButton)

    data class Base(val pictureResId: Int) : PictureButtonUiState {

        override fun update(button: UpdatePictureButton) {
            button.update(pictureResId = pictureResId)
        }
    }
}