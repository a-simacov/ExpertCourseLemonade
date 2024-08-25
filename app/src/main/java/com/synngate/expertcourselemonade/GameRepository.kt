package com.synngate.expertcourselemonade

interface GameRepository {

    fun next(): Choice

    fun current(): Choice

    class Base(
        private var index: IntCache,
        private var tapsToSqueeze: IntCache,
        private var squeezeTapped: IntCache,
        private val tapsToSqueezeStrategy: TapsToSqueezeStrategy = TapsToSqueezeStrategy.Fixed()
    ) : GameRepository {

        init {
            if (tapsToSqueeze.read() == 0)
                tapsToSqueeze.save(tapsToSqueezeStrategy.tapsNumber())
        }

        private val list = listOf(
            Choice(pictureResId = R.drawable.lemon, textResId = R.string.lemon),
            Choice(pictureResId = R.drawable.squeeze, textResId = R.string.squeeze),
            Choice(pictureResId = R.drawable.drink, textResId = R.string.drink),
            Choice(pictureResId = R.drawable.empty, textResId = R.string.empty),
        )

        private val squeezeIndex = 1 // todo get index from list item where pictureResId = squeeze

        override fun current(): Choice {
            return list[index.read()]
        }

        override fun next(): Choice {
            if (index.read() == squeezeIndex) {
                squeezeTapped.save(squeezeTapped.read() + 1)
                if (squeezeTapped.read() == tapsToSqueeze.read()) {
                    index.save(index.read() + 1)
                    squeezeTapped.save(0)
                }
            } else
                index.save(index.read() + 1)

            if (list.size == index.read()) {
                index.save(0)
                tapsToSqueeze.save(tapsToSqueezeStrategy.tapsNumber())
            }

            return list[index.read()]
        }
    }
}

data class Choice(val pictureResId: Int, val textResId: Int)

interface TapsToSqueezeStrategy {

    fun tapsNumber(): Int

    class Base : TapsToSqueezeStrategy {

        override fun tapsNumber() = (2..4).random()
    }

    class Fixed : TapsToSqueezeStrategy {

        override fun tapsNumber() = 3
    }
}