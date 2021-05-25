package com.dicoding.moviecatalogue.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "moviedetail")
data class MovieDetailEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "moviedetail_id")
    var moviedetail_id: Int,
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