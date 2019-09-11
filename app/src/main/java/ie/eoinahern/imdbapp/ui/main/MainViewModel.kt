package ie.eoinahern.imdbapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ie.eoinahern.imdbapp.data.model.MovieDetails
import ie.eoinahern.imdbapp.data.model.MovieSearchWrapper
import ie.eoinahern.imdbapp.domain.main.GetMovieDataUsecase
import ie.eoinahern.imdbapp.ui.base.BaseViewModel
import ie.eoinahern.imdbapp.util.ErrorState
import io.reactivex.observers.DisposableObserver
import java.io.IOException
import javax.inject.Inject

class MainViewModel @Inject constructor(private val getMovieDataUsecase: GetMovieDataUsecase) :
    BaseViewModel() {

    private val searchData: MutableLiveData<List<MovieDetails>> = MutableLiveData()

    fun searchMovie(searchStr: String) {

        getMovieDataUsecase.apply { setSearchTerm(searchStr) }
            .execute(object : DisposableObserver<MovieSearchWrapper>() {
                override fun onComplete() {
                }

                override fun onNext(t: MovieSearchWrapper) {
                    searchData.value = t.results
                }

                override fun onError(e: Throwable) {
                    if (e is IOException) {
                        getErrorResult(ErrorState.IOError)
                    } else {
                        getErrorResult(ErrorState.NetworkError)
                    }
                }
            })
    }

    fun getMovieLiveData(): LiveData<List<MovieDetails>> = searchData

    override fun onCleared() {
        super.onCleared()
        getMovieDataUsecase.clearDsiposables()
    }
}