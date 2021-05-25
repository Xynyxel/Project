package com.dicoding.moviecatalogue.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MoviesEntity(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "movie_id")
        var movie_id: Int,
        var title: String,
        var date: String,
        var poster: String
)
