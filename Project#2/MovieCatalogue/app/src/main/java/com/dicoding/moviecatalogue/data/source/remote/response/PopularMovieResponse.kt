package com.dicoding.moviecatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class PopularMovieResponse(
    @SerializedName("results")
    val PopularMovieList: ArrayList<MovieResponse>
)