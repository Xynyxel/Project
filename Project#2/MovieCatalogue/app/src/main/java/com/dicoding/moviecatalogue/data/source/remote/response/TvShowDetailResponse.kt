package com.dicoding.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowDetailResponse(

    @SerializedName("backdrop_path")
    var backdrop : String,

    @SerializedName("poster_path")
    var poster: String,

    @SerializedName("original_name")
    var title: String,

    @SerializedName("genres")
    var genres: ArrayList<GenreResponse>,

    var overview: String,

    @SerializedName("vote_average")
    var userScore: Double,

    var id: Int,

    @SerializedName("first_air_date")
    var date: String,

    @SerializedName("episode_run_time")
    var duration: ArrayList<Int>
) : Parcelable