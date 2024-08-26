package com.synngate.expertcourselemonade

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