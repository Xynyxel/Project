package com.dicoding.moviecatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class PopularTvShowResponse(
    @SerializedName("results")
    val PopularTvshowList: ArrayList<TvShowResponse>
)