package com.dicoding.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.dicoding.moviecatalogue.data.source.local.entity.MovieDetailEntity
import com.dicoding.moviecatalogue.data.source.local.entity.MoviesEntity
import com.dicoding.moviecatalogue.data.source.local.entity.TvShowDetailEntity
import com.dicoding.moviecatalogue.data.source.local.entity.TvShowEntity
import com.dicoding.moviecatalogue.vo.Resource

interface CatalogueDataSource {
    fun getPopularMovie(): LiveData<Resource<PagedList<MoviesEntity>>>

    fun getPopularTvShow(): LiveData<Resource<PagedList<TvShowEntity>>>

    fun getDetailTvShow(id: String):LiveData<Resource<TvShowDetailEntity>>

    fun getDetailMovie(id: String): LiveData<Resource<MovieDetailEntity>>

    fun setFavoriteTvShow(tvShow: TvShowDetailEntity, state: Boolean) : Int

    fun setFavoriteMovie(movie: MovieDetailEntity, state: Boolean) : Int

    fun getFavoriteTvShow() : LiveData<PagedList<TvShowDetailEntity>>

    fun getFavoriteMovie() : LiveData<PagedList<MovieDetailEntity>>

}