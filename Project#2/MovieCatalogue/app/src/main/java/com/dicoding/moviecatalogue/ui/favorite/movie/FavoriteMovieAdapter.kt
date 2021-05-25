package com.dicoding.moviecatalogue.ui.favorite.movie

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.moviecatalogue.R
import com.dicoding.moviecatalogue.data.source.local.entity.MovieDetailEntity
import com.dicoding.moviecatalogue.data.source.local.entity.TvShowDetailEntity
import com.dicoding.moviecatalogue.databinding.ItemFavoriteBinding
import com.dicoding.moviecatalogue.ui.detail.DetailActivity

class FavoriteMovieAdapter : PagedListAdapter<MovieDetailEntity, FavoriteMovieAdapter.FavoriteMovieViewHolder>(
    DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieDetailEntity>() {
            override fun areItemsTheSame(oldItem: MovieDetailEntity, newItem: MovieDetailEntity): Boolean {
                return oldItem.moviedetail_id == newItem.moviedetail_id
            }
            override fun areContentsTheSame(oldItem: MovieDetailEntity, newItem: MovieDetailEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    private val baseImageUrl = "https://image.tmdb.org/t/p/w500"

    inner class FavoriteMovieViewHolder(private val binding: ItemFavoriteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieDetailEntity) {
            with(binding) {
                tvItemTitle.text = movie.title
                tvItemDate.text = movie.genres
                Glide.with(itemView.context)
                    .load(baseImageUrl + movie.poster)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)
                itemView.setOnClickListener{
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(
                        DetailActivity.EXTRA_MOVIE_ID,
                        movie.moviedetail_id.toString()
                    )
                    val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        itemView.context as Activity
                    )
                    itemView.context.startActivity(intent, options.toBundle())
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMovieViewHolder {
        val itemsFavoriteBinding =
            ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteMovieViewHolder(itemsFavoriteBinding)
    }

    override fun onBindViewHolder(holder: FavoriteMovieViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie!=null){
            holder.bind(movie)
        }

    }

}