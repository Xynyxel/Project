package com.dicoding.moviecatalogue.ui.detail

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.moviecatalogue.R
import com.dicoding.moviecatalogue.databinding.ActivityDetailBinding
import com.dicoding.moviecatalogue.viewmodel.ViewModelFactory
import com.dicoding.moviecatalogue.vo.Status

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_TVSHOW_ID = "extra_tvshow_ID"
        const val EXTRA_MOVIE_ID = "extra_movie_ID"
        private const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500"
    }

    private val factory = ViewModelFactory.getInstance(this)
    private val detailViewModel: DetailViewModel by viewModels { factory }

    private lateinit var activityDetailBinding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(activityDetailBinding.root)


        val tvShowId = intent.getStringExtra(EXTRA_TVSHOW_ID)
        val movieId = intent.getStringExtra(EXTRA_MOVIE_ID)

        if (tvShowId != null) {
            detailViewModel.setSelectedTvShow(tvShowId)
            detailViewModel.getDetailTvShow().observe(this, { tvShow ->
                if (tvShow != null) {
                    when (tvShow.status) {
                        Status.LOADING -> showLoading(true)
                        Status.SUCCESS ->
                            if (tvShow.data != null) {
                                showLoading(false)
                                with(activityDetailBinding) {
                                    txtTitle.text = tvShow.data.title
                                    txtDate.text = tvShow.data.date
                                    txtOverview.text = resources.getString(
                                        R.string.overview,
                                        tvShow.data.overview
                                    )
                                    txtDuration.text = resources.getString(
                                        R.string.duration,
                                        tvShow.data.duration.toString()
                                    )
                                    txtGenre.text = tvShow.data.genres
                                    txtUserScore.text = resources.getString(
                                        R.string.user_score_percent,
                                        (tvShow.data.userScore * 10).toInt().toString()
                                    )
                                    pgUserScore.progress = (tvShow.data.userScore * 10).toInt()
                                    com.bumptech.glide.Glide.with(this@DetailActivity)
                                        .load(BASE_IMAGE_URL + tvShow.data.poster)
                                        .apply(
                                            com.bumptech.glide.request.RequestOptions.placeholderOf(
                                                R.drawable.ic_loading
                                            )
                                                .error(R.drawable.ic_error)
                                        )
                                        .into(imagedt)

                                    com.bumptech.glide.Glide.with(this@DetailActivity)
                                        .load(BASE_IMAGE_URL + tvShow.data.backdrop)
                                        .apply(
                                            com.bumptech.glide.request.RequestOptions.placeholderOf(
                                                R.drawable.ic_loading
                                            )
                                                .error(R.drawable.ic_error)
                                        )
                                        .into(backdropdt)

                                    ftBack.setOnClickListener {
                                        val intent = Intent(
                                            this@DetailActivity,
                                            com.dicoding.moviecatalogue.ui.home.MainActivity::class.java
                                        )
                                        startActivity(intent)
                                    }
                                    btnFavorite.setOnClickListener {
                                        detailViewModel.setFavoriteTvShow(tvShow.data)
                                    }
                                    setFavorite(tvShow.data.favorite)
                                }

                            }
                        Status.ERROR -> {
                            showLoading(false)
                            Toast.makeText(
                                applicationContext,
                                "Terjadi kesalahan",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            })
        } else if (movieId != null) {
            detailViewModel.setSelectedMovie(movieId)
            detailViewModel.getDetailMovie().observe(this, { movie ->
                if (movie != null) {
                    when (movie.status) {
                        Status.LOADING -> showLoading(true)
                        Status.SUCCESS ->
                            if (movie.data != null) {
                                showLoading(false)
                                with(activityDetailBinding) {
                                    txtTitle.text = movie.data.title
                                    txtDate.text = movie.data.date

                                    txtGenre.text = movie.data.genres
                                    txtOverview.text = resources.getString(
                                        R.string.overview,
                                        movie.data.overview
                                    )

                                    txtDuration.text = resources.getString(
                                        R.string.duration,
                                        movie.data.duration.toString()
                                    )

                                    txtUserScore.text = resources.getString(
                                        R.string.user_score_percent,
                                        (movie.data.userScore * 10).toInt().toString()
                                    )
                                    pgUserScore.progress = (movie.data.userScore * 10).toInt()
                                    com.bumptech.glide.Glide.with(this@DetailActivity)
                                        .load(BASE_IMAGE_URL + movie.data.poster)
                                        .apply(
                                            com.bumptech.glide.request.RequestOptions.placeholderOf(
                                                R.drawable.ic_loading
                                            )
                                                .error(R.drawable.ic_error)
                                        )
                                        .into(imagedt)
                                    com.bumptech.glide.Glide.with(this@DetailActivity)
                                        .load(BASE_IMAGE_URL + movie.data.backdrop)
                                        .apply(
                                            com.bumptech.glide.request.RequestOptions.placeholderOf(
                                                R.drawable.ic_loading
                                            )
                                                .error(R.drawable.ic_error)
                                        )
                                        .into(backdropdt)
                                    ftBack.setOnClickListener {
                                        val intent = Intent(
                                            this@DetailActivity,
                                            com.dicoding.moviecatalogue.ui.home.MainActivity::class.java
                                        )
                                        startActivity(intent)
                                    }
                                    btnFavorite.setOnClickListener {
                                        detailViewModel.setFavoriteMovie(movie.data)
                                    }
                                    setFavorite(movie.data.favorite)
                                }

                            }
                        Status.ERROR -> {
                            showLoading(false)
                            Toast.makeText(
                                applicationContext,
                                "Terjadi kesalahan",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            })
        }
    }


    private fun showLoading(state: Boolean) {
        if (state) {
            activityDetailBinding.ftBack.visibility = View.GONE
            activityDetailBinding.cardView.visibility = View.GONE
            activityDetailBinding.pgUserScore.visibility = View.GONE
            activityDetailBinding.txtUserScore.visibility = View.GONE
            activityDetailBinding.txtUserScoreText.visibility = View.GONE
            activityDetailBinding.cvDuration.visibility = View.GONE
            activityDetailBinding.txtTitle.visibility = View.GONE
            activityDetailBinding.txtDate.visibility = View.GONE
            activityDetailBinding.txtGenre.visibility = View.GONE
            activityDetailBinding.separator.visibility = View.GONE
            activityDetailBinding.cvOverview.visibility = View.GONE
            activityDetailBinding.ltLoading.visibility = View.VISIBLE
            activityDetailBinding.btnFavorite.visibility = View.GONE
        } else {
            activityDetailBinding.ftBack.visibility = View.VISIBLE
            activityDetailBinding.cardView.visibility = View.VISIBLE
            activityDetailBinding.pgUserScore.visibility = View.VISIBLE
            activityDetailBinding.txtUserScore.visibility = View.VISIBLE
            activityDetailBinding.txtUserScoreText.visibility = View.VISIBLE
            activityDetailBinding.cvDuration.visibility = View.VISIBLE
            activityDetailBinding.txtTitle.visibility = View.VISIBLE
            activityDetailBinding.txtDate.visibility = View.VISIBLE
            activityDetailBinding.txtGenre.visibility = View.VISIBLE
            activityDetailBinding.separator.visibility = View.VISIBLE
            activityDetailBinding.cvOverview.visibility = View.VISIBLE
            activityDetailBinding.ltLoading.visibility = View.GONE
            activityDetailBinding.btnFavorite.visibility = View.VISIBLE
        }

    }

    private fun setFavorite(state: Boolean) {
        if (state == true) {
            activityDetailBinding.btnFavorite.setImageResource(R.drawable.ic_favorite)
        } else {
            activityDetailBinding.btnFavorite.setImageResource(R.drawable.ic_favorite_not)
        }
    }
}