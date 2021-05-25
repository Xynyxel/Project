package com.dicoding.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResponse(

    @SerializedName("poster_path")
    var poster: String,

    @SerializedName("original_title")
    var title: String,

    var id: Int,

    @SerializedName("release_date")
    var date: String

) : Parcelable