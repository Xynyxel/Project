package com.dicoding.moviecatalogue.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.moviecatalogue.data.source.CatalogueRepository
import com.dicoding.moviecatalogue.data.source.local.entity.MovieDetailEntity
import com.dicoding.moviecatalogue.data.source.local.entity.TvShowDetailEntity

class FavoriteViewModel(private val mCatalogueRepository: CatalogueRepository) : ViewModel() {
    fun getFavoriteTvShow(): LiveData<PagedList<TvShowDetailEntity>> {
        return mCatalogueRepository.getFavoriteTvShow()
    }

    fun getFavoriteMovie(): LiveData<PagedList<MovieDetailEntity>> {
        return mCatalogueRepository.getFavoriteMovie()
    }
}