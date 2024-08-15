package com.synngate.expertcourselemonade

class GameViewModel(private val repository: GameRepository) {

    fun next(): GameUiState {
        val data = repository.next()
        return GameUiState.Base(
            pictureResId = data.pictureResId,
            textResId = data.textResId
        )
    }
}