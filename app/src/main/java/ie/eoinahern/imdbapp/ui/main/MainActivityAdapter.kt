package ie.eoinahern.imdbapp.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ie.eoinahern.imdbapp.R
import ie.eoinahern.imdbapp.data.model.MovieDetails
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

        init {
            itemView.setOnClickListener { listener(movieList[adapterPosition]) }
        }

        fun bind(movie: MovieDetails) {

        }
    }
}