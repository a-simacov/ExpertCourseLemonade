package com.synngate.expertcourselemonade.views.text

import android.content.Context
import android.util.AttributeSet

class InstructionText : androidx.appcompat.widget.AppCompatTextView, UpdateInstructionText {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun getFreezesText() = true

    override fun update(textResId: Int) {
        this.setText(textResId)
    }
}