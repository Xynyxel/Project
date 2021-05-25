package com.dicoding.moviecatalogue.data.source.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.dicoding.moviecatalogue.data.source.local.LocalDataSource
import com.dicoding.moviecatalogue.data.source.local.entity.MovieDetailEntity
import com.dicoding.moviecatalogue.data.source.local.entity.MoviesEntity
import com.dicoding.moviecatalogue.data.source.local.entity.TvShowDetailEntity
import com.dicoding.moviecatalogue.data.source.local.entity.TvShowEntity
import com.dicoding.moviecatalogue.utils.*
import com.dicoding.moviecatalogue.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.*

class CatalogueRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val testExecutors: AppExecutors = AppExecutors(TestExecutor(), TestExecutor(), TestExecutor())
    private val catalogueRepository = FakeCatalogueRepository(remote, local, appExecutors)

    private val tvShowResponse = DataDummy.generateRemoteDummyTvShow()
    private val tvshowDetailResponse = DataDummy.generateRemoteDummyDetailTvShowIndex0()
    private val tvShowDetailResponseid = tvshowDetailResponse.id

    private val movieResponse = DataDummy.generateRemoteDummyMovies()
    private val movieDetailResponse = DataDummy.generateRemoteDummyDetailMoviesIndex0()
    private val movieDetailResponseid = movieDetailResponse.id

    @Test
    fun testGetPopularTvShow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getPopularTvShow()).thenReturn(dataSourceFactory)
        catalogueRepository.getPopularTvShow()

        val tvshowEntities = Resource.success(PagedListUtil.mockPagedList((DataDummy.generateDummyTvShow())))
        verify(local).getPopularTvShow()
        Assert.assertNotNull(tvshowEntities.data)
        assertEquals(tvShowResponse.size.toLong(), tvshowEntities.data?.size?.toLong())
    }

    @Test
    fun testGetDetailTvShow() {
        val dummyDetailtvshow = MutableLiveData<TvShowDetailEntity>()
        dummyDetailtvshow.value = DataDummy.generateDummyDetailTvShowIndex0()
        `when`(local.getDetailTvShow(tvShowDetailResponseid.toString())).thenReturn(
            dummyDetailtvshow
        )

        val tvShowDetailEntitiesContent =
            LiveDataTestUtil.getValue(catalogueRepository.getDetailTvShow(tvShowDetailResponseid.toString()))
        verify(local)
            .getDetailTvShow(tvShowDetailResponseid.toString())

        Assert.assertNotNull(tvShowDetailEntitiesContent)
    }

    @Test
    fun testGetPopularMovie() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MoviesEntity>
        `when`(local.getPopularMovie()).thenReturn(dataSourceFactory)
        catalogueRepository.getPopularMovie()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getPopularMovie()
        Assert.assertNotNull(movieEntities.data)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun testGetDetailMovie() {
        val dummyDetailmovie = MutableLiveData<MovieDetailEntity>()
        dummyDetailmovie.value = DataDummy.generateDummyDetailMoviesIndex0()
        `when`(local.getDetailMovie(movieDetailResponseid.toString())).thenReturn(dummyDetailmovie)

        val movieDetailEntitiesContent =
            LiveDataTestUtil.getValue(catalogueRepository.getDetailMovie(movieDetailResponseid.toString()))
        verify(local)
            .getDetailMovie(movieDetailResponseid.toString())

        Assert.assertNotNull(movieDetailEntitiesContent)
    }

    @Test
    fun setFavoriteTvShow(){
        `when`(appExecutors.diskIO()).thenReturn(testExecutors.diskIO())
        val tvShow: TvShowDetailEntity = DataDummy.generateDummyDetailTvShowIndex0()

        // set true favorite
        `when`(local.setFavoriteTvShow(tvShow, true)).thenReturn(tvShow.tvshowdetail_id)
        catalogueRepository.setFavoriteTvShow(tvShow, true)
        verify(local, times(1)).setFavoriteTvShow(tvShow, true)

        // set false favorite
        `when`(local.setFavoriteTvShow(tvShow, false)).thenReturn(tvShow.tvshowdetail_id)
        catalogueRepository.setFavoriteTvShow(tvShow, false)
        verify(local, times(1)).setFavoriteTvShow(tvShow, true)
    }

    @Test
    fun setFavoriteMovie(){
        `when`(appExecutors.diskIO()).thenReturn(testExecutors.diskIO())
        val movie: MovieDetailEntity = DataDummy.generateDummyDetailMoviesIndex0()

        // set true favorite
        `when`(local.setFavoriteMovie(movie, true)).thenReturn(movie.moviedetail_id)
        catalogueRepository.setFavoriteMovie(movie, true)
        verify(local, times(1)).setFavoriteMovie(movie, true)

        // set false favorite
        `when`(local.setFavoriteMovie(movie, false)).thenReturn(movie.moviedetail_id)
        catalogueRepository.setFavoriteMovie(movie, false)
        verify(local, times(1)).setFavoriteMovie(movie, true)
    }
}