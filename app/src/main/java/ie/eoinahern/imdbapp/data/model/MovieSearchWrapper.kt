package ie.eoinahern.imdbapp.data.model

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class MovieSearchWrapper(
    val page: Int,
    val total_results: Int,
    val total_pages: Int,
    val results: List<MovieDetails>
)