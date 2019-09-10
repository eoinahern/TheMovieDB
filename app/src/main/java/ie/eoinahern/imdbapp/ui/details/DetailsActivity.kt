package ie.eoinahern.imdbapp.ui.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import ie.eoinahern.imdbapp.R
import ie.eoinahern.imdbapp.data.model.MovieDetails
import ie.eoinahern.imdbapp.ui.base.BaseActivity
import ie.eoinahern.imdbapp.util.IMAGE_URL_BIG
import ie.eoinahern.imdbapp.util.MOVIE_KEY
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toolbarSetup()
        getIntentData()
    }

    private fun toolbarSetup() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun getLayout(): Int = R.layout.activity_details

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getIntentData() {
        val movie = intent.getParcelableExtra<MovieDetails>(MOVIE_KEY)
        movie?.let { setDetails(it) }
    }

    private fun setDetails(movieDetails: MovieDetails) {
        val imageurl = IMAGE_URL_BIG.plus(movieDetails.poster_path)
        Glide.with(image.context).load(imageurl).override(image.width, image.height).into(image)
        movieBlurb.text = movieDetails.overview
        supportActionBar?.title = movieDetails.title
    }

    companion object {
        fun getStartIntent(context: Context): Intent = Intent(context, DetailsActivity::class.java)
    }
}
