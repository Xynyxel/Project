package com.dicoding.moviecatalogue.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.moviecatalogue.data.source.CatalogueRepository
import com.dicoding.moviecatalogue.data.source.local.entity.MovieDetailEntity
import com.dicoding.moviecatalogue.data.source.local.entity.MoviesEntity
import com.dicoding.moviecatalogue.data.source.local.entity.TvShowDetailEntity
import com.dicoding.moviecatalogue.ui.movies.MovieViewModel
import com.dicoding.moviecatalogue.vo.Resource
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest{

    private lateinit var viewModel: FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var pagedListMovie: PagedList<MovieDetailEntity>

    @Mock
    private lateinit var pagedListTvShow: PagedList<TvShowDetailEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteViewModel(catalogueRepository)
    }

    @Test
    fun getFavoriteMovie() {
        val movie = MutableLiveData<PagedList<MovieDetailEntity>>()
        movie.value = pagedListMovie

        `when`(catalogueRepository.getFavoriteMovie()).thenReturn(movie)
        val listMovie = viewModel.getFavoriteMovie().value
        verify(catalogueRepository).getFavoriteMovie()
        assertNotNull(listMovie)
    }

    @Test
    fun getFavoriteTvShow() {
        val tvshow = MutableLiveData<PagedList<TvShowDetailEntity>>()
        tvshow.value = pagedListTvShow

        `when`(catalogueRepository.getFavoriteTvShow()).thenReturn(tvshow)
        val listTvShow = viewModel.getFavoriteTvShow().value
        verify(catalogueRepository).getFavoriteTvShow()
        assertNotNull(listTvShow)
    }
}