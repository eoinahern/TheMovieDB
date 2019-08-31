package ie.eoinahern.imdbapp.domain

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

abstract class BaseUsecase<T> {

    private val disposables = CompositeDisposable()

    fun execute(dispObserver: DisposableObserver<T>) {
        disposables.add(
            buildObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(dispObserver)
        )
    }

    fun clearDsiposables() {
        disposables.clear()
    }

    abstract fun buildObservable(): Observable<T>
}