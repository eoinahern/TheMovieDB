package ie.eoinahern.imdbapp.ui.main

import android.os.Bundle
import dagger.android.AndroidInjection
import ie.eoinahern.imdbapp.R
import ie.eoinahern.imdbapp.data.model.MovieDetails
import ie.eoinahern.imdbapp.ui.base.BaseActivity
import ie.eoinahern.imdbapp.util.ErrorState
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var adapter: MainActivityAdapter

    class EmptyListState : ErrorState.CustomErrorState()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        initAdapter()
        initViewModel()
    }

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    private fun initAdapter() {
        recycler.adapter = adapter
        adapter.listener = ::navigateNext
    }

    private fun initViewModel() {

    }

    private fun navigateNext(movieDetails: MovieDetails) {

    }

    fun updateAdapter(list: List<MovieDetails>) {
        adapter.updataAdapter(list)
    }

    fun displayError(error: ErrorState) {

        when (error) {
            is EmptyListState -> println("empty List")
            is ErrorState.NetworkError -> println("error")
            is ErrorState.IOError -> println("net error")
            else -> println("error loading")
        }
    }

    fun showLoading() {

    }

    fun hideLoading() {

    }
}
