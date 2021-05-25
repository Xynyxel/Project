package com.dicoding.moviecatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.moviecatalogue.data.source.CatalogueRepository
import com.dicoding.moviecatalogue.data.source.local.entity.MovieDetailEntity
import com.dicoding.moviecatalogue.data.source.local.entity.TvShowDetailEntity
import com.dicoding.moviecatalogue.utils.DataDummy
import com.dicoding.moviecatalogue.vo.Resource
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel

    private val dummyMovie = Resource.success(DataDummy.generateDummyDetailMoviesIndex0())
    private val dummyMovieId = dummyMovie.data?.moviedetail_id

    private val dummyTvShow = Resource.success(DataDummy.generateDummyDetailTvShowIndex0())
    private val dummyTvShowId = dummyTvShow.data?.tvshowdetail_id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var observerMovie: Observer<Resource<MovieDetailEntity>>


    @Mock
    private lateinit var observerTvShow: Observer<Resource<TvShowDetailEntity>>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(catalogueRepository)
    }

    @Test
    fun getDetailMovie() {
        viewModel.setSelectedMovie(dummyMovieId.toString())
        val movie = MutableLiveData<Resource<MovieDetailEntity>>()
        movie.value = dummyMovie
        `when`(catalogueRepository.getDetailMovie(dummyMovieId.toString())).thenReturn(movie)
        viewModel.getDetailMovie().observeForever(observerMovie)
        verify(observerMovie).onChanged(dummyMovie)
    }

    @Test
    fun getDetailTvShow() {
        viewModel.setSelectedTvShow(dummyTvShowId.toString())
        val tvshow = MutableLiveData<Resource<TvShowDetailEntity>>()
        tvshow.value = dummyTvShow
        `when`(catalogueRepository.getDetailTvShow(dummyTvShowId.toString())).thenReturn(tvshow)
        viewModel.getDetailTvShow().observeForever(observerTvShow)
        verify(observerTvShow).onChanged(dummyTvShow)
    }

    @Test
    fun setFavoriteTvShow() {
        val tvshow = DataDummy.generateDummyDetailTvShowIndex0()

        // set true favorite
        tvshow.favorite = true
        val addFavorite = viewModel.setFavoriteTvShow(tvshow)
        assertNotNull(addFavorite)

        // set false favorite
        tvshow.favorite = false
        val removeFavorite = viewModel.setFavoriteTvShow(tvshow)
        assertNotNull(removeFavorite)
    }

    @Test
    fun setFavoriteMovie() {
        val movie = DataDummy.generateDummyDetailMoviesIndex0()

        // set true favorite
        movie.favorite = true
        val addFavorite = viewModel.setFavoriteMovie(movie)
        assertNotNull(addFavorite)

        // set false favorite
        movie.favorite = false
        val removeFavorite = viewModel.setFavoriteMovie(movie)
        assertNotNull(removeFavorite)
    }


}