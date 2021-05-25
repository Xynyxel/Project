package com.dicoding.moviecatalogue.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.moviecatalogue.data.source.CatalogueRepository
import com.dicoding.moviecatalogue.data.source.local.entity.MoviesEntity
import com.dicoding.moviecatalogue.vo.Resource

class MovieViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getPopularMovies(): LiveData<Resource<PagedList<MoviesEntity>>> =
        catalogueRepository.getPopularMovie()
}