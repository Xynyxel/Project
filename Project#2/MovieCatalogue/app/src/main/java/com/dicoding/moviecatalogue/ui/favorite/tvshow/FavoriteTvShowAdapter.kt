package com.dicoding.moviecatalogue.ui.favorite.tvshow

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
import com.dicoding.moviecatalogue.data.source.local.entity.TvShowDetailEntity
import com.dicoding.moviecatalogue.databinding.ItemFavoriteBinding
import com.dicoding.moviecatalogue.ui.detail.DetailActivity

class FavoriteTvShowAdapter :
    PagedListAdapter<TvShowDetailEntity, FavoriteTvShowAdapter.FavoriteTvShowViewHolder>(
        DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowDetailEntity>() {
            override fun areItemsTheSame(oldItem: TvShowDetailEntity, newItem: TvShowDetailEntity): Boolean {
                return oldItem.tvshowdetail_id == newItem.tvshowdetail_id
            }
            override fun areContentsTheSame(oldItem: TvShowDetailEntity, newItem: TvShowDetailEntity): Boolean {
                return oldItem == newItem
            }
        }
    }
    private val baseImageUrl = "https://image.tmdb.org/t/p/w500"

    inner class FavoriteTvShowViewHolder(private val binding: ItemFavoriteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvshow: TvShowDetailEntity) {
            with(binding) {
                tvItemTitle.text = tvshow.title
                tvItemDate.text = tvshow.genres
                Glide.with(itemView.context)
                    .load(baseImageUrl+tvshow.poster)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)
                itemView.setOnClickListener{
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(
                        DetailActivity.EXTRA_TVSHOW_ID,
                       tvshow.tvshowdetail_id.toString()
                    )
                    val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        itemView.context as Activity
                    )
                    itemView.context.startActivity(intent, options.toBundle())
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteTvShowViewHolder {
        val itemsFavoriteBinding =
            ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteTvShowViewHolder(itemsFavoriteBinding)
    }

    override fun onBindViewHolder(holder: FavoriteTvShowViewHolder, position: Int) {
        val tvshow = getItem(position)
        if (tvshow!=null){
            holder.bind(tvshow)
        }
    }


}