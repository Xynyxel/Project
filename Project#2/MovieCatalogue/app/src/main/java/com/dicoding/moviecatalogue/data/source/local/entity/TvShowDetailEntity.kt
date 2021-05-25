package com.dicoding.moviecatalogue.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.*

@Entity(tableName = "tvshowdetail" )
data class TvShowDetailEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tvshowdetail_id")
    var tvshowdetail_id: Int,

    var title: String,

    var poster: String,

    var genres: String,

    var overview: String,

    var backdrop: String,

    var userScore: Double,

    var date: String,

    var duration: Int,

    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false,
)