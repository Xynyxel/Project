package com.dicoding.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieDetailResponse(

    @SerializedName("backdrop_path")
    var backdrop : String,

    @SerializedName("poster_path")
    var poster: String,

    @SerializedName("original_title")
    var title: String,

    @SerializedName("genres")
    var genres : ArrayList<GenreResponse>,

    var overview: String,

    @SerializedName("vote_average")
    var userScore: Double,

    var id: Int,

    @SerializedName("release_date")
    var date: String,

    @SerializedName("runtime")
    var duration: Int
) : Parcelable