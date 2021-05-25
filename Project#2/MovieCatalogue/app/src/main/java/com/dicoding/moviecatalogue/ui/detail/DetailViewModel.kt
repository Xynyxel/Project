package com.dicoding.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.dicoding.moviecatalogue.data.source.CatalogueRepository
import com.dicoding.moviecatalogue.data.source.local.entity.MovieDetailEntity
import com.dicoding.moviecatalogue.data.source.local.entity.TvShowDetailEntity
import com.dicoding.moviecatalogue.vo.Resource

class DetailViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    val tvShowId = MutableLiveData<String>()
    val movieId = MutableLiveData<String>()

    fun setSelectedTvShow(tvShowId: String) {
        this.tvShowId.value = tvShowId
    }

    fun getDetailTvShow(): LiveData<Resource<TvShowDetailEntity>> = Transformations.switchMap(tvShowId) { mtvshowId ->
        catalogueRepository.getDetailTvShow(mtvshowId)
    }

    fun setSelectedMovie(movieId: String) {
        this.movieId.value = movieId
    }

    fun getDetailMovie(): LiveData<Resource<MovieDetailEntity>> = Transformations.switchMap(movieId) { mmovieId ->
        catalogueRepository.getDetailMovie(mmovieId)
    }

    fun setFavoriteTvShow(tvShowDetailEntity: TvShowDetailEntity) {
        val newState = !tvShowDetailEntity.favorite
        catalogueRepository.setFavoriteTvShow(tvShowDetailEntity, newState)
    }

    fun setFavoriteMovie(movieDetailEntity: MovieDetailEntity) {
        val newState = !movieDetailEntity.favorite
        catalogueRepository.setFavoriteMovie(movieDetailEntity, newState)
    }
}