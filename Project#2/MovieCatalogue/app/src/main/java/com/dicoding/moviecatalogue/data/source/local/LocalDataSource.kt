package com.dicoding.moviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.PagedList
import com.dicoding.moviecatalogue.data.source.local.entity.MovieDetailEntity
import com.dicoding.moviecatalogue.data.source.local.entity.MoviesEntity
import com.dicoding.moviecatalogue.data.source.local.entity.TvShowDetailEntity
import com.dicoding.moviecatalogue.data.source.local.entity.TvShowEntity
import com.dicoding.moviecatalogue.data.source.local.room.CatalogueDao

class LocalDataSource private constructor(private val mCatalogueDao: CatalogueDao){

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(catalogueDao: CatalogueDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(catalogueDao)
    }

    fun getPopularTvShow(): DataSource.Factory<Int, TvShowEntity> =  mCatalogueDao.getPopularTvShow()

    fun insertPopularTvShow(tvshows: List<TvShowEntity>) = mCatalogueDao.insertPopularTvShow(tvshows)

    fun getPopularMovie(): DataSource.Factory<Int, MoviesEntity> =  mCatalogueDao.getPopularMovie()

    fun insertPopularMovie(movie: List<MoviesEntity>) = mCatalogueDao.insertPopularMovie(movie)

    fun getDetailTvShow(id: String): LiveData<TvShowDetailEntity> = mCatalogueDao.getdetailTvShow(id)

    fun insertDetailTvShow(tvshow: TvShowDetailEntity) = mCatalogueDao.insertdetailTvShow(tvshow)

    fun getDetailMovie(id: String): LiveData<MovieDetailEntity> = mCatalogueDao.getdetailMovie(id)

    fun insertDetailMovie(movie: MovieDetailEntity) = mCatalogueDao.insertdetailMovie(movie)

    fun setFavoriteTvShow(tvShow: TvShowDetailEntity, newState: Boolean): Int {
        tvShow.favorite = newState
        mCatalogueDao.updateFavoriteTvShow(tvShow)
        return tvShow.tvshowdetail_id
    }

    fun setFavoriteMovie(movie: MovieDetailEntity, newState: Boolean): Int {
        movie.favorite = newState
        mCatalogueDao.updateFavoriteMovie(movie)
        return movie.moviedetail_id
    }

    fun getFavoriteTvShow(): DataSource.Factory<Int, TvShowDetailEntity> = mCatalogueDao.getFavoriteTvShow()

    fun getFavoriteMovie(): DataSource.Factory<Int, MovieDetailEntity> = mCatalogueDao.getFavoriteMovie()

}