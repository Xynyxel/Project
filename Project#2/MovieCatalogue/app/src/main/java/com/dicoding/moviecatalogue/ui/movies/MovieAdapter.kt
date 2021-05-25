package com.dicoding.moviecatalogue.ui.movies

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.moviecatalogue.R
import com.dicoding.moviecatalogue.data.source.local.entity.MoviesEntity
import com.dicoding.moviecatalogue.databinding.ItemPosterBinding
import com.dicoding.moviecatalogue.ui.detail.DetailActivity


class MovieAdapter : PagedListAdapter<MoviesEntity, MovieAdapter.PosterViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MoviesEntity>() {
            override fun areItemsTheSame(oldItem: MoviesEntity, newItem: MoviesEntity): Boolean {
                return oldItem.movie_id == newItem.movie_id
            }
            override fun areContentsTheSame(oldItem: MoviesEntity, newItem: MoviesEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    private var listMovies = ArrayList<MoviesEntity>()
    private val baseImageUrl = "https://image.tmdb.org/t/p/w500"

    inner class PosterViewHolder(private val binding: ItemPosterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: MoviesEntity) {
            Log.d("Test", movies.toString())
            with(binding) {
                Glide.with(itemView.context)
                    .load(baseImageUrl + movies.poster)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)
                txtTitle.text = movies.title
                txtDate.text = movies.date

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_MOVIE_ID, movies.movie_id.toString())
                    val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        itemView.context as Activity
                    )
                    itemView.context.startActivity(intent, options.toBundle())
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosterViewHolder {
        val itemPosterBinding = ItemPosterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PosterViewHolder(itemPosterBinding)
    }

    override fun onBindViewHolder(holder: PosterViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie!=null){
            holder.bind(movie)
        }
    }


}