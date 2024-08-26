package com.synngate.expertcourselemonade.views.imagebutton

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet

class PictureButton : androidx.appcompat.widget.AppCompatImageButton, UpdatePictureButton {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private lateinit var uiState: PictureButtonUiState

    override fun updateUi(uiState: PictureButtonUiState) {
        this.uiState = uiState
        uiState.update(this)
    }

    override fun update(pictureResId: Int) {
        this.setImageResource(pictureResId)
        this.tag = pictureResId
    }

    override fun onSaveInstanceState(): Parcelable? {
        return super.onSaveInstanceState()?.let {
            val savedUiState = PictureButtonSavedState(it)
            savedUiState.save(uiState)
            return savedUiState
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoredUiState = state as PictureButtonSavedState
        super.onRestoreInstanceState(restoredUiState.superState)
        updateUi(uiState = restoredUiState.restore())
    }
}