package com.dicoding.moviecatalogue.ui.favorite

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.moviecatalogue.R
import com.dicoding.moviecatalogue.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {

    private lateinit var favoriteBinding: ActivityFavoriteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        favoriteBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(favoriteBinding.root)

        supportActionBar?.title = "My Favorite"

        val sectionsPagerAdapterFavorite =
            SectionsPagerAdapterFavorite(this, supportFragmentManager)
        favoriteBinding.viewPager.adapter = sectionsPagerAdapterFavorite
        favoriteBinding.tabs.setupWithViewPager(favoriteBinding.viewPager)

    }

}