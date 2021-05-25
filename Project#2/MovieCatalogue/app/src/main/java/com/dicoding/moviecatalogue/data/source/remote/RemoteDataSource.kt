package com.dicoding.moviecatalogue.data.source.remote

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.moviecatalogue.BuildConfig
import com.dicoding.moviecatalogue.api.ApiConfig
import com.dicoding.moviecatalogue.data.source.remote.response.*
import com.dicoding.moviecatalogue.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {
    private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource().apply { instance = this }
            }
    }

    fun getPopularTvShow(): LiveData<ApiResponse<List<TvShowResponse>>> {
        val tvshowresult = MutableLiveData<ApiResponse<List<TvShowResponse>>>()
        EspressoIdlingResource.increment()
        val client =
            ApiConfig.getApiService()
                .getPopularTvshow(BuildConfig.TMDB_TOKEN)
        client.enqueue(object : Callback<PopularTvShowResponse> {
            override fun onResponse(
                call: Call<PopularTvShowResponse>,
                response: Response<PopularTvShowResponse>
            ) {
                if (response.isSuccessful) {
                    handler.postDelayed({
                        EspressoIdlingResource.decrement()
                        tvshowresult.value =
                            ApiResponse.success(response.body()?.PopularTvshowList as ArrayList<TvShowResponse>)
                    }, SERVICE_LATENCY_IN_MILLIS)

                } else {
                    Log.e("Error", "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<PopularTvShowResponse>, t: Throwable) {
                Log.e("Error", "onFailure: ${t.message.toString()}")
            }
        })
        return tvshowresult
    }

    fun getDetailTvShow(id: String): LiveData<ApiResponse<TvShowDetailResponse>> {
        val resultdetailTvShow = MutableLiveData<ApiResponse<TvShowDetailResponse>>()
        EspressoIdlingResource.increment()
        val client =
            ApiConfig.getApiService().getDetailTvshow(id, BuildConfig.TMDB_TOKEN)
        client.enqueue(object : Callback<TvShowDetailResponse> {
            override fun onResponse(
                call: Call<TvShowDetailResponse>,
                response: Response<TvShowDetailResponse>
            ) {
                if (response.isSuccessful) {
                    handler.postDelayed({
                        EspressoIdlingResource.decrement()
                        resultdetailTvShow.value =
                            ApiResponse.success(response.body() as TvShowDetailResponse)
                    }, SERVICE_LATENCY_IN_MILLIS)
                } else {
                    Log.e("Error", "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<TvShowDetailResponse>, t: Throwable) {
                Log.e("Error", "onFailure: ${t.message.toString()}")
            }
        })
        return resultdetailTvShow
    }

    fun getPopularMovie(): LiveData<ApiResponse<List<MovieResponse>>> {
        val resultMovie = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        EspressoIdlingResource.increment()
        val client =
            ApiConfig.getApiService()
                .getPopularMovie(BuildConfig.TMDB_TOKEN)
        client.enqueue(object : Callback<PopularMovieResponse> {
            override fun onResponse(
                call: Call<PopularMovieResponse>,
                response: Response<PopularMovieResponse>
            ) {
                if (response.isSuccessful) {
                    handler.postDelayed({
                        EspressoIdlingResource.decrement()
                        resultMovie.value =
                            ApiResponse.success(response.body()?.PopularMovieList as ArrayList<MovieResponse>)
                    }, SERVICE_LATENCY_IN_MILLIS)
                } else {
                    Log.e("Error", "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<PopularMovieResponse>, t: Throwable) {
                Log.e("Error", "onFailure: ${t.message.toString()}")
            }
        })
        return resultMovie
    }

    fun getDetailMovie(id: String): LiveData<ApiResponse<MovieDetailResponse>> {
        val resultDetailMovie = MutableLiveData<ApiResponse<MovieDetailResponse>>()
        EspressoIdlingResource.increment()
        val client =
            ApiConfig.getApiService().getDetailMovie(id, BuildConfig.TMDB_TOKEN)
        client.enqueue(object : Callback<MovieDetailResponse> {
            override fun onResponse(
                call: Call<MovieDetailResponse>,
                response: Response<MovieDetailResponse>
            ) {
                if (response.isSuccessful) {
                    handler.postDelayed({
                        EspressoIdlingResource.decrement()
                        resultDetailMovie.value =
                            ApiResponse.success(response.body() as MovieDetailResponse)
                    }, SERVICE_LATENCY_IN_MILLIS)
                } else {
                    Log.e("Error", "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                Log.e("Error", "onFailure: ${t.message.toString()}")
            }
        })
        return resultDetailMovie
    }

    interface LoadTvShowsCallback {
        fun onAllTvShowReceived(tvShowResponse: ArrayList<TvShowResponse>)
    }

    interface LoadMoviesCallback {
        fun onAllMovieReceived(movieResponse: ArrayList<MovieResponse>)
    }

    interface LoadTvShowDetailCallback {
        fun onAllTvShowDetailReceived(tvShowDetailResponse: TvShowDetailResponse)
    }

    interface LoadMovieDetailCallback {
        fun onAllMovieDetailReceived(movieDetailResponse: MovieDetailResponse)
    }
}