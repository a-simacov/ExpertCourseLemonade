package com.synngate.expertcourselemonade.di

interface Module<T : MyViewModel> {

    fun viewModel(): T
}