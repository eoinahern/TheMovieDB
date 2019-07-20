package ie.eoinahern.imdbapp.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ie.eoinahern.imdbapp.R
import ie.eoinahern.imdbapp.data.model.MovieDetails
import ie.eoinahern.imdbapp.util.IMAGE_URL
import kotlinx.android.synthetic.main.movie_item_layout.view.*
import okhttp3.HttpUrl
import javax.inject.Inject

class MainActivityAdapter @Inject constructor() : RecyclerView.Adapter<MainActivityAdapter.ViewHolder>() {

    private var movieList: MutableList<MovieDetails> = mutableListOf()
    var listener: (MovieDetails) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.movie_item_layout,
            parent, false
        )

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    fun updataAdapter(listIn: List<MovieDetails>) {
        movieList.addAll(movieList.size, listIn)
        notifyDataSetChanged()
    }

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        private val image: ImageView by lazy { v.findViewById(R.id.movieImage) }
        private val movieTitle: TextView by lazy { v.findViewById(R.id.movieTitle) }
        private val movieYear: TextView by lazy { v.findViewById(R.id.movieYear) }

        init {
            itemView.setOnClickListener { listener(movieList[adapterPosition]) }
        }

        fun bind(movie: MovieDetails) {
            Glide.with(image.context)
                .load(HttpUrl.parse(IMAGE_URL.plus(movie.poster_path)))
                .into(image)

            movieTitle.text = movie.title
            movieYear.text = movie.release_date
        }

    }
}