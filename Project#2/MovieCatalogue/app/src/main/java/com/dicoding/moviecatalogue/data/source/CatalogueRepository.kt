package com.dicoding.moviecatalogue.data.source

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dicoding.moviecatalogue.data.source.local.LocalDataSource
import com.dicoding.moviecatalogue.data.source.local.entity.MovieDetailEntity
import com.dicoding.moviecatalogue.data.source.local.entity.MoviesEntity
import com.dicoding.moviecatalogue.data.source.local.entity.TvShowDetailEntity
import com.dicoding.moviecatalogue.data.source.local.entity.TvShowEntity
import com.dicoding.moviecatalogue.data.source.remote.ApiResponse
import com.dicoding.moviecatalogue.data.source.remote.RemoteDataSource
import com.dicoding.moviecatalogue.data.source.remote.response.MovieDetailResponse
import com.dicoding.moviecatalogue.data.source.remote.response.MovieResponse
import com.dicoding.moviecatalogue.data.source.remote.response.TvShowDetailResponse
import com.dicoding.moviecatalogue.data.source.remote.response.TvShowResponse
import com.dicoding.moviecatalogue.utils.AppExecutors
import com.dicoding.moviecatalogue.vo.Resource

class CatalogueRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) :
    CatalogueDataSource {

    companion object {
        @Volatile
        private var instance: CatalogueRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): CatalogueRepository =
            instance ?: synchronized(this) {
                instance ?: CatalogueRepository(
                    remoteData,
                    localData,
                    appExecutors
                ).apply { instance = this }
            }
    }

    override fun getPopularTvShow(): LiveData<Resource<PagedList<TvShowEntity>>> {
        return object :
            NetworkBoundResource<PagedList<TvShowEntity>, List<TvShowResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getPopularTvShow(), config).build()
            }


            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> =
                remoteDataSource.getPopularTvShow()

            override fun saveCallResult(data: List<TvShowResponse>) {
                val tvshowList = ArrayList<TvShowEntity>()
                for (respose in data) {
                    val tvshow = TvShowEntity(
                        respose.id,
                        respose.title,
                        respose.date,
                        respose.poster
                    )
                    tvshowList.add(tvshow)
                }
                localDataSource.insertPopularTvShow(tvshowList)
            }
        }.asLiveData()
    }

    override fun getDetailTvShow(id: String): LiveData<Resource<TvShowDetailEntity>> {
        return object :
            NetworkBoundResource<TvShowDetailEntity, TvShowDetailResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<TvShowDetailEntity> =
                localDataSource.getDetailTvShow(id)

            override fun shouldFetch(data: TvShowDetailEntity?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<TvShowDetailResponse>> =
                remoteDataSource.getDetailTvShow(id)

            override fun saveCallResult(data: TvShowDetailResponse) {
                Log.d("Test", data.duration.toString())
                var durasi: Int = 0
                if (data.duration.isNotEmpty()) {
                    durasi = data.duration[0]
                }
                val tvshowDetail = TvShowDetailEntity(
                    data.id,
                    data.title,
                    data.poster,
                    data.genres.joinToString {
                        it.name
                    },
                    data.overview,
                    data.backdrop,
                    data.userScore,
                    data.date,
                    durasi
                )
                localDataSource.insertDetailTvShow(tvshowDetail)
            }
        }.asLiveData()
    }

    override fun getPopularMovie(): LiveData<Resource<PagedList<MoviesEntity>>> {
        return object :
            NetworkBoundResource<PagedList<MoviesEntity>, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<MoviesEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getPopularMovie(), config).build()
            }


            override fun shouldFetch(data: PagedList<MoviesEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getPopularMovie()

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MoviesEntity>()
                for (response in data) {
                    val movie = MoviesEntity(
                        movie_id = response.id,
                        title = response.title,
                        date = response.date,
                        poster = response.poster
                    )
                    movieList.add(movie)
                }
                localDataSource.insertPopularMovie(movieList)
            }
        }.asLiveData()
    }

    override fun getDetailMovie(id: String): LiveData<Resource<MovieDetailEntity>> {
        return object :
            NetworkBoundResource<MovieDetailEntity, MovieDetailResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<MovieDetailEntity> =
                localDataSource.getDetailMovie(id)

            override fun shouldFetch(data: MovieDetailEntity?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<MovieDetailResponse>> =
                remoteDataSource.getDetailMovie(id)

            override fun saveCallResult(data: MovieDetailResponse) {
                val movieDetail = MovieDetailEntity(
                    data.id,
                    data.title,
                    data.poster,
                    data.genres.joinToString {
                        it.name
                    },
                    data.overview,
                    data.backdrop,
                    data.userScore,
                    data.date,
                    data.duration
                )
                localDataSource.insertDetailMovie(movieDetail)
            }
        }.asLiveData()
    }

    override fun setFavoriteTvShow(tvShow: TvShowDetailEntity, state: Boolean): Int {
        appExecutors.diskIO().execute { localDataSource.setFavoriteTvShow(tvShow, state) }
        return tvShow.tvshowdetail_id
    }

    override fun setFavoriteMovie(movie: MovieDetailEntity, state: Boolean): Int {
        appExecutors.diskIO().execute { localDataSource.setFavoriteMovie(movie, state) }
        return movie.moviedetail_id
    }

    override fun getFavoriteTvShow(): LiveData<PagedList<TvShowDetailEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteTvShow(), config).build()
    }


    override fun getFavoriteMovie(): LiveData<PagedList<MovieDetailEntity>>{
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovie(), config).build()
    }



}
