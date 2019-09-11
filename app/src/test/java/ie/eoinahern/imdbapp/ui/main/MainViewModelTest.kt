package ie.eoinahern.imdbapp.ui.main

import ie.eoinahern.imdbapp.domain.main.GetMovieDataUsecase
import ie.eoinahern.imdbapp.rules.SchedulerTestRule
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import ie.eoinahern.imdbapp.data.api.TMDBApi
import ie.eoinahern.imdbapp.data.model.MovieDetails
import ie.eoinahern.imdbapp.data.model.MovieSearchWrapper
import io.reactivex.Observable
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    private lateinit var useCase: GetMovieDataUsecase

    @Mock
    private lateinit var mockApi: TMDBApi

    @Mock
    private lateinit var mockList: List<MovieDetails>

    @Mock
    private lateinit var mockMovieWrapper: MovieSearchWrapper

    @get : Rule
    val schedulerRule: SchedulerTestRule = SchedulerTestRule()

    @get : Rule
    val instatntTaskExRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        useCase = GetMovieDataUsecase(mockApi)
        this.viewModel = MainViewModel(useCase)
    }

    @Test
    fun searchMovie() {

        Mockito.`when`(mockApi.searchMovie(anyString()))
            .thenReturn(Observable.just(mockMovieWrapper))
        Mockito.`when`(mockMovieWrapper.results).thenReturn(mockList)

        viewModel.searchMovie("")

        viewModel.getMovieLiveData().observeForever {
            assertEquals(it[0].original_language, "boo")
        }

        Mockito.verify(useCase).setSearchTerm(Mockito.anyString())
    }

    @Test
    fun getMovieLiveData() {
    }
}