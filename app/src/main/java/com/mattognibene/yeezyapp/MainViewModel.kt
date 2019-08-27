package com.mattognibene.yeezyapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mattognibene.yeezyapp.domain.interactor.kanye.GetKanyeQuote
import javax.inject.Inject
import kotlinx.coroutines.launch

class MainViewModel @Inject constructor(
    private val getKanyeQuoteUseCase: GetKanyeQuote
) : ViewModel() {

    sealed class State {
        object Loading : State()
        data class GetQuoteSuccess(val quote: String) : State()
        data class GetQuoteFailure(val error: Throwable) : State()
    }

    val state = MutableLiveData<State>().apply {
        this.value = State.Loading
    }

    fun loadKanyeQuote() {
        viewModelScope.launch {
            state.value = State.Loading
            try {
                val quote = getKanyeQuoteUseCase(Unit)
                state.value = State.GetQuoteSuccess(quote)
            } catch (e: Exception) {
                state.value = State.GetQuoteFailure(e)
            }
        }
    }

    private fun handleSuccess(quote: String) {
        state.value = State.GetQuoteSuccess(quote)
    }

    private fun handleError(error: Throwable) {
        state.value = State.GetQuoteFailure(error)
    }
}