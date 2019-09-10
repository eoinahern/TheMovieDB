package ie.eoinahern.imdbapp.ui.main

import android.os.Bundle
import androidx.appcompat.widget.SearchView
import dagger.android.AndroidInjection
import ie.eoinahern.imdbapp.R
import ie.eoinahern.imdbapp.data.model.MovieDetails
import ie.eoinahern.imdbapp.ui.base.BaseActivity
import ie.eoinahern.imdbapp.ui.details.DetailsActivity
import ie.eoinahern.imdbapp.util.*
import ie.eoinahern.imdbapp.util.LoadingView.State.GONE
import ie.eoinahern.imdbapp.util.LoadingView.State.LOADING
import ie.eoinahern.imdbapp.util.LoadingView.State.ERROR
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var adapter: MainActivityAdapter

    private val loading by lazy { findViewById<LoadingView>(R.id.loading) }
    private val search by lazy { findViewById<SearchView>(R.id.search_view) }
    private lateinit var viewModel: MainViewModel
    private class EmptyListState : ErrorState.CustomErrorState()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        showErrorText()
        loading.setErrorText(resources.getString(R.string.search_movie_above))
        initAdapter()
        initViewModel()
        initSearch()
    }

    override fun getLayout(): Int = R.layout.activity_main

    private fun initAdapter() {
        recycler.adapter = adapter
        adapter.listener = ::navigateNext
    }

    private fun initViewModel() {
        viewModel = getViewModel(MainViewModel::class.java) {
            observe(getMovieLiveData(), ::updateAdapter)
            onError(errorResponse, ::displayError)
        }
    }

    private fun initSearch() {
        search.isSubmitButtonEnabled = true
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                showLoading()
                viewModel.searchMovie(query)
                search.clearFocus()
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
    }

    private fun navigateNext(movieDetails: MovieDetails) {
        val intent = DetailsActivity.getStartIntent(this)
        intent.putExtra(MOVIE_KEY, movieDetails)
        startActivity(intent)
    }

    private fun updateAdapter(list: List<MovieDetails>) {
        hideLoading()
        adapter.updateAdapter(list)
    }

    private fun displayError(error: ErrorState) {
        showErrorText()
        when (error) {
            is EmptyListState -> {
                loading.setErrorText(resources.getString(R.string.no_movies_found))
            }
            is ErrorState.NetworkError, ErrorState.IOError -> {
                loading.setErrorText(resources.getString(R.string.network_error))
            }
        }
    }

    private fun showLoading() {
        loading.updateLoadingState(LOADING)
    }

    private fun hideLoading() {
        loading.updateLoadingState(GONE)
    }

    private fun showErrorText() {
        loading.updateLoadingState(ERROR)
    }
}
