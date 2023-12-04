package com.avility.presentation.screens

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

/**
 * [BaseViewModel] to have a global strategy to handle the state in the application
 *
 * @author Heiner Gómez
 * @param [initialState] initial state that the screen begins.
 */
abstract class BaseViewModel<STATE, ACTION>(initialState: STATE) : ViewModel() {

    private val _uiState = mutableStateOf(initialState)
    val uiState: State<STATE> = _uiState

    abstract fun dispatchAction(action: ACTION)

    fun setState(state: STATE) {
        _uiState.value = state
    }
}