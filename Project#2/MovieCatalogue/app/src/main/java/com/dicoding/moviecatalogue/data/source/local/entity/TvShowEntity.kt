package com.dicoding.moviecatalogue.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tvshow")
data class TvShowEntity(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "tvshow_id")
        var tvshow_id: Int,

        var title: String,

        var date: String,

        var poster: String
)
