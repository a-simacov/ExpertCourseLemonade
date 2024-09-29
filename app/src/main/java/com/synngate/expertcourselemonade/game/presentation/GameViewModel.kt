package com.synngate.expertcourselemonade.game.presentation

import com.synngate.expertcourselemonade.game.data.GameRepository

class GameViewModel(private val repository: GameRepository) {

    fun current(firstRun: Boolean = true): GameUiState {
        if (firstRun) {
            val data = repository.current()

            return GameUiState.Base(
                pictureResId = data.pictureResId,
                textResId = data.textResId
            )
        } else
            return GameUiState.Empty
    }

    fun next(): GameUiState {
        val data = repository.next()

        return GameUiState.Base(
            pictureResId = data.pictureResId,
            textResId = data.textResId
        )
    }
}