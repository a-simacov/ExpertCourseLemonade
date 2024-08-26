package com.synngate.expertcourselemonade.views.imagebutton

import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.os.Build

class PictureButtonSavedState : View.BaseSavedState {

    private lateinit var state: PictureButtonUiState

    constructor(superState: Parcelable) : super(superState)

      private constructor(parcelIn: Parcel) : super(parcelIn) {
       state = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
             parcelIn.readSerializable(PictureButtonUiState::class.java.classLoader, PictureButtonUiState::class.java) as PictureButtonUiState
        } else {
           parcelIn.readSerializable() as PictureButtonUiState
        }
    }

    override fun writeToParcel(out: Parcel, flags: Int) {
        super.writeToParcel(out, flags)
        out.writeSerializable(state)
    }

    fun restore(): PictureButtonUiState = state

    fun save(uiState: PictureButtonUiState) {
        state = uiState
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<PictureButtonSavedState> {
        override fun createFromParcel(parcel: Parcel): PictureButtonSavedState =
            PictureButtonSavedState(parcel)

        override fun newArray(size: Int): Array<PictureButtonSavedState?> =
            arrayOfNulls(size)
    }
}