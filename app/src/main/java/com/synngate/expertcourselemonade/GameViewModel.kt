package com.synngate.expertcourselemonade

class GameViewModel(private val repository: GameRepository) {

    fun current(): GameUiState {
        val data = repository.current()

        return GameUiState.Base(
            pictureResId = data.pictureResId,
            textResId = data.textResId
        )
    }

    fun next(): GameUiState {
        val data = repository.next()

        return GameUiState.Base(
            pictureResId = data.pictureResId,
            textResId = data.textResId
        )
    }
}