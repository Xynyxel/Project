package com.dicoding.moviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.dicoding.moviecatalogue.data.source.local.entity.MovieDetailEntity
import com.dicoding.moviecatalogue.data.source.local.entity.MoviesEntity
import com.dicoding.moviecatalogue.data.source.local.entity.TvShowDetailEntity
import com.dicoding.moviecatalogue.data.source.local.entity.TvShowEntity

@Dao
interface CatalogueDao {
    // TvShow
    @Query("SELECT * FROM tvshow")
    fun getPopularTvShow(): DataSource.Factory<Int, TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPopularTvShow(tvshows: List<TvShowEntity>)

    // Detail TvShow
    @Query("SELECT * FROM tvshowdetail where tvshowdetail_id=:id")
    fun getdetailTvShow(id: String): LiveData<TvShowDetailEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertdetailTvShow(tvshow: TvShowDetailEntity)

    // Movie
    @Query("SELECT * FROM movie")
    fun getPopularMovie(): DataSource.Factory<Int, MoviesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPopularMovie(movie: List<MoviesEntity>)

    // Detail Movie
    @Query("SELECT * FROM moviedetail where moviedetail_id=:id")
    fun getdetailMovie(id: String): LiveData<MovieDetailEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertdetailMovie(movie: MovieDetailEntity)

    // Favorite Tvshow
    @Update
    fun updateFavoriteTvShow(tvshow: TvShowDetailEntity): Int

    @Query("SELECT * FROM tvshowdetail where favorite = 1")
    fun getFavoriteTvShow(): DataSource.Factory<Int, TvShowDetailEntity>

    // Favorite Movie
    @Update
    fun updateFavoriteMovie(movie: MovieDetailEntity): Int

    @Query("SELECT * FROM moviedetail where favorite = 1")
    fun getFavoriteMovie(): DataSource.Factory<Int, MovieDetailEntity>


}