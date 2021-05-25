package com.dicoding.moviecatalogue.ui.tvshow

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
import com.dicoding.moviecatalogue.data.source.local.entity.TvShowEntity
import com.dicoding.moviecatalogue.databinding.ItemPosterBinding
import com.dicoding.moviecatalogue.ui.detail.DetailActivity

class TvShowAdapter : PagedListAdapter<TvShowEntity, TvShowAdapter.PosterViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.tvshow_id == newItem.tvshow_id
            }
            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    private val baseImageUrl = "https://image.tmdb.org/t/p/w500"

    inner class PosterViewHolder(private val binding: ItemPosterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShowEntity) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(baseImageUrl + tvShow.poster)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)
                txtTitle.text = tvShow.title
                txtDate.text = tvShow.date

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(
                        DetailActivity.EXTRA_TVSHOW_ID,
                        tvShow.tvshow_id.toString()
                    )
                    val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        itemView.context as Activity
                    )
                    itemView.context.startActivity(intent, options.toBundle())
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosterViewHolder {
        val itemPosterBinding =
            ItemPosterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PosterViewHolder(itemPosterBinding)
    }

    override fun onBindViewHolder(holder: PosterViewHolder, position: Int) {
        val tvshow = getItem(position)
        if (tvshow != null){
            holder.bind(tvshow)
        }
    }

}