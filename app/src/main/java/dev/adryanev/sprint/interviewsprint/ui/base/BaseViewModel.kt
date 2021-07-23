package dev.adryanev.sprint.interviewsprint.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.adryanev.sprint.interviewsprint.utils.SingleLiveEvent
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import retrofit2.Response
import java.net.ConnectException
import java.net.HttpURLConnection
import java.net.SocketTimeoutException
import java.net.UnknownHostException

open class BaseViewModel : ViewModel() {

    // loading flag
    val isLoading by lazy { MutableLiveData(false) }

    // error message
    val errorMessage by lazy { SingleLiveEvent<String>() }

    // exception handler for coroutine
    private val exceptionHandler by lazy {
        CoroutineExceptionHandler { _, throwable ->
            viewModelScope.launch {
                onError(throwable)
            }
        }
    }
    protected val viewModelScopeExceptionHandler by lazy { viewModelScope + exceptionHandler }

    /**
     * handle throwable when load fail
     */
    protected open fun onError(throwable: Throwable) {
        hideLoading()
    }

    open fun showError(e: Throwable) {
        errorMessage.value = e.message
    }

    fun showLoading() {
        isLoading.value = true
    }

    fun hideLoading() {
        isLoading.value = false
    }

    inline fun <T> launchPagingAsync(
        crossinline execute: suspend () -> Flow<T>,
        crossinline onSuccess: (Flow<T>) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val result = execute()
                onSuccess(result)
            } catch (ex: Exception) {
                errorMessage.value = ex.message
            }
        }
    }

    inline fun <T> launchAsync(
        crossinline execute: suspend () -> Response<T>,
        crossinline onSuccess: (T) -> Unit,
        showProgress: Boolean = true
    ) {
        viewModelScope.launch {
            if (showProgress)
                isLoading.value = true
            try {
                val result = execute()
                if (result.isSuccessful)
                    onSuccess(result.body()!!)
                else
                    errorMessage.value = result.message()
            } catch (ex: Exception) {
                errorMessage.value = ex.message
            } finally {
                isLoading.value = false
            }
        }
    }
}