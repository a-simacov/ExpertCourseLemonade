package com.synngate.expertcourselemonade

import com.synngate.expertcourselemonade.game.data.Choice
import com.synngate.expertcourselemonade.game.data.Drink
import com.synngate.expertcourselemonade.game.data.Empty
import com.synngate.expertcourselemonade.game.data.GameRepository
import com.synngate.expertcourselemonade.game.data.Lemon
import com.synngate.expertcourselemonade.game.data.Squeeze
import com.synngate.expertcourselemonade.game.presentation.GameUiState
import com.synngate.expertcourselemonade.game.presentation.GameViewModel
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

    private val list = listOf(Lemon, Squeeze, Drink, Empty)

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

    override fun current(): Choice {
        return list[index]
    }
}