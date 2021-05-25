package com.dicoding.moviecatalogue.api

import com.dicoding.moviecatalogue.data.source.remote.response.PopularTvShowResponse
import com.dicoding.moviecatalogue.data.source.remote.response.MovieDetailResponse
import com.dicoding.moviecatalogue.data.source.remote.response.PopularMovieResponse
import com.dicoding.moviecatalogue.data.source.remote.response.TvShowDetailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("tv/{tv_id}")
    fun getDetailTvshow(
        @Path("tv_id") tv_id: String,
        @Query("api_key") api_key: String
    ): Call<TvShowDetailResponse>

    @GET("movie/{movie_id}")
    fun getDetailMovie(
        @Path("movie_id") movie_id: String,
        @Query("api_key") api_key: String
    ): Call<MovieDetailResponse>

    @GET("tv/popular")
    fun getPopularTvshow(
        @Query("api_key") api_key: String
    ): Call<PopularTvShowResponse>

    @GET("movie/popular")
    fun getPopularMovie(
        @Query("api_key") api_key: String
    ): Call<PopularMovieResponse>
}