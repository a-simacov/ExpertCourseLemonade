package com.synngate.expertcourselemonade

interface GameRepository {

    fun next(): Choice

    class Base(private val tapsToSqueeze: Int) : GameRepository {

        private val list = listOf(
            Choice(pictureResId = R.drawable.lemon, textResId = R.string.lemon),
            Choice(pictureResId = R.drawable.squeeze, textResId = R.string.squeeze),
            Choice(pictureResId = R.drawable.drink, textResId = R.string.drink),
            Choice(pictureResId = R.drawable.empty, textResId = R.string.empty),
        )

        private var index = -1
        private val squeezeIndex = 1
        private var squeezeTapped = 0

        override fun next(): Choice {
            when (index) {
                squeezeIndex -> {
                    squeezeTapped++
                    if (squeezeTapped == tapsToSqueeze) {
                        index++
                        squeezeTapped = 0
                    }
                }

                else -> index++
            }

            if (list.size == index)
                index = 0

            return list[index]
        }
    }
}

data class Choice(val pictureResId: Int, val textResId: Int)