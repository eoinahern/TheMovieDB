package ie.eoinahern.imdbapp.data.api

import ie.eoinahern.imdbapp.data.model.MovieSearchWrapper
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBApi {

    @GET("search/movie")
    fun searchMovie(@Query("query") searchTerm: String): Observable<MovieSearchWrapper>
}