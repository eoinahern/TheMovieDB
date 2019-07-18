package ie.eoinahern.imdbapp.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ie.eoinahern.imdbapp.util.ErrorState

open class BaseViewModel : ViewModel() {

     var errorResponse: MutableLiveData<ErrorState> = MutableLiveData()

    protected fun getErrorResult(errorState : ErrorState) {
        errorResponse.value = errorState
    }
}