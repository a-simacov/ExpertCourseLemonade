package com.synngate.expertcourselemonade

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GameViewModelTest {

    private lateinit var viewModel: GameViewModel
    private var tapsToSqueeze: Int = 0

    @Before
    fun setup() {
        tapsToSqueeze = 3
        viewModel = GameViewModel(repository = FakeRepository(squeezeTaps = tapsToSqueeze))
    }

    @Test
    fun case_1() {
        var actual: GameUiState = viewModel.next()
        var expected: GameUiState = GameUiState.Base(
            pictureResId = R.drawable.lemon,
            textResId = R.string.lemon
        )
        assertEquals(expected, actual)

        repeat(tapsToSqueeze) {
            actual = viewModel.next()
            expected = GameUiState.Base(
                pictureResId = R.drawable.squeeze,
                textResId = R.string.squeeze
            )
            assertEquals(expected, actual)
        }

        actual = viewModel.next()
        expected = GameUiState.Base(
            pictureResId = R.drawable.drink,
            textResId = R.string.drink
        )
        assertEquals(expected, actual)

        actual = viewModel.next()
        expected = GameUiState.Base(
            pictureResId = R.drawable.empty,
            textResId = R.string.empty
        )
        assertEquals(expected, actual)
    }
}

class FakeRepository(private var squeezeTaps: Int) : GameRepository {

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
                if (squeezeTapped == squeezeTaps) {
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