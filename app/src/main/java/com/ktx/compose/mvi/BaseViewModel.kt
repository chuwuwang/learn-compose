package com.ktx.compose.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<I, S, E> : ViewModel() {

    // 页面状态（只读）
    private val _uiState = MutableStateFlow(
        initialState()
    )
    val uiState: StateFlow<S> = _uiState.asStateFlow()

    // 一次性事件（只读）
    private val _uiEffect = Channel<E>()
    val uiEffect: Flow<E> = _uiEffect.receiveAsFlow()

    // 初始化状态
    abstract fun initialState(): S

    // 接收 UI 发送的 Intent
    abstract fun onIntent(intent: I)

    // 更新状态
    protected fun setState(block: S.() -> S) {
        _uiState.value = _uiState.value.block()
    }

    // 发送一次性事件
    protected fun sendEffect(effect: E) {
        viewModelScope.launch { _uiEffect.send(effect) }
    }

}