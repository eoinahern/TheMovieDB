package ie.eoinahern.imdbapp.data.api

import ie.eoinahern.imdbapp.data.model.MovieSearchWrapper
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface TMDBApi {

    @GET("search/movie")
    fun searchMovie(searchTerm: String): Observable<MovieSearchWrapper>
}