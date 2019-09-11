package ie.eoinahern.imdbapp.domain.main

import ie.eoinahern.imdbapp.data.api.TMDBApi
import ie.eoinahern.imdbapp.data.model.MovieSearchWrapper
import ie.eoinahern.imdbapp.rules.SchedulerTestRule
import io.reactivex.Observable
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetMovieDataUsecaseTest {

    @Mock
    private lateinit var mockApi: TMDBApi

    @Mock
    private lateinit var mockObs: Observable<MovieSearchWrapper>

    private lateinit var getMovieDataUsecase: GetMovieDataUsecase

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        getMovieDataUsecase = GetMovieDataUsecase(mockApi)
    }

    @Test
    fun setSearchTerm() {
        Mockito.`when`(mockApi.searchMovie(Mockito.anyString())).thenReturn(mockObs)
        val obs = getMovieDataUsecase.buildObservable()
        Mockito.verify(mockApi).searchMovie(Mockito.anyString())
        assertTrue(obs == mockObs)
    }
}