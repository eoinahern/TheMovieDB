package ie.eoinahern.imdbapp.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer


fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, observe: (T) -> Unit) {
    liveData.observe(this, Observer(observe))
}

fun <T : ErrorState, L : LiveData<T>> LifecycleOwner.onError(liveData: L, observe: (T) -> Unit) {
    liveData.observe(this, Observer(observe))
}