package com.synngate.expertcourselemonade

import androidx.annotation.DrawableRes
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class GameViewModelTest {

    private lateinit var viewModel: GameViewModel
    private lateinit var squeezeNumber: Int

    @Before
    fun setup() {
        val squeezeNumber = 3
        viewModel = GameViewModel(repository = FakeRepository(squeezeNumber = squeezeNumber))
    }

    @Test
    fun case_1() {
        var actual: GameUiState = viewModel.init()
        var expected: GameUiState = GameUiState.Initial(
            pictureResId = R.drawable.lemon,
            textResId = R.string.lemon
        )
        assertEquals(expected, actual)

        actual = viewModel.next()
        expected = GameUiState.Squeeze(
            pictureResId = R.drawable.squeeze,
            textResId = R.string.squeeze
        )
        assertEquals(expected, actual)

        repeat(squeezeNumber - 1) {
            actual = viewModel.next()
            expected = GameUiState.Squeeze(
                pictureResId = R.drawable.squeeze,
                textResId = R.string.squeeze
            )
            assertEquals(expected, actual)
        }

        actual = viewModel.next()
        expected = GameUiState.Drink(
            pictureResId = R.drawable.drink,
            textResId = R.string.drink
        )
        assertEquals(expected, actual)

        actual = viewModel.next()
        expected = GameUiState.Empty(
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