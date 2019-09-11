package ie.eoinahern.imdbapp.domain.main

import ie.eoinahern.imdbapp.data.api.TMDBApi
import ie.eoinahern.imdbapp.data.model.MovieSearchWrapper
import ie.eoinahern.imdbapp.domain.BaseUsecase
import io.reactivex.Observable
import javax.inject.Inject


class GetMovieDataUsecase @Inject constructor(private val api: TMDBApi) :
    BaseUsecase<MovieSearchWrapper>() {

    private var searchTerm: String = ""

    fun setSearchTerm(searchTerm: String): GetMovieDataUsecase {
        this.searchTerm = searchTerm
        return this
    }

    override fun buildObservable(): Observable<MovieSearchWrapper> {
        return api.searchMovie(searchTerm)
    }
}