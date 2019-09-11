package ie.eoinahern.imdbapp.ui.main

import ie.eoinahern.imdbapp.domain.main.GetMovieDataUsecase
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    @Mock
    private lateinit var useCase: GetMovieDataUsecase

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = MainViewModel(useCase)
    }

    @Test
    fun searchMovie() {
    }

    @Test
    fun getMovieLiveData() {
    }
}