package com.dicoding.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowResponse(

    @SerializedName("poster_path")
    var poster: String,

    @SerializedName("original_name")
    var title: String,

    var id: Int,

    @SerializedName("first_air_date")
    var date: String

) : Parcelable
