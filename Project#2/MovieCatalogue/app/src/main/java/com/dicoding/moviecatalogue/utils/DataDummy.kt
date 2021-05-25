package com.dicoding.moviecatalogue.utils

import com.dicoding.moviecatalogue.data.source.local.entity.*
import com.dicoding.moviecatalogue.data.source.remote.response.*

object DataDummy {

    fun generateDummyMovies(): List<MoviesEntity> {
        val movies = ArrayList<MoviesEntity>()
        movies.add(
            MoviesEntity(
                movie_id = 460465,
                title = "Mortal Kombat",
                date = "2021-04-07",
                poster = "/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                movie_id = 399566,
                title = "Godzilla vs. Kong",
                date = "2021-03-24",
                poster = "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                movie_id = 635302,
                title = "劇場版「鬼滅の刃」無限列車編",
                date = "2020-10-16",
                poster = "/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                movie_id = 615457,
                title = "Nobody",
                date = "2021-03-18",
                poster = "/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg"
            )
        )

        movies.add(
            MoviesEntity(
                movie_id = 632357,
                title = "The Unholy",
                date = "2021-03-31",
                poster = "b4gYVcl8pParX8AjkN90iQrWrWO.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                movie_id = 791373,
                title = "Zack Snyder's Justice League",
                date = "2021-03-18",
                poster = "/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg"
            )
        )

        movies.add(
            MoviesEntity(
                movie_id = 634528,
                title = "The Marksman",
                date = "2021-01-15",
                poster = "/6vcDalR50RWa309vBH1NLmG2rjQ.jpg"
            )
        )

        movies.add(
            MoviesEntity(
                movie_id = 726684,
                title = "Miraculous World Shanghai, la légende de Ladydragon",
                date = "2021-04-04",
                poster = "/msI5a9TPnepx47JUb2vl88hb80R.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                movie_id = 804435,
                title = "Vanquish",
                date = "2021-04-16",
                poster = "/AoWY1gkcNzabh229Icboa1Ff0BM.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                movie_id = 615678,
                title = "Thunder Force",
                date = "2021-04-09",
                poster = "/duK11VQd4UPDa7UJrgrGx90xJOx.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                movie_id = 412656,
                title = "Chaos Walking",
                date = "2021-02-24",
                poster = "/9kg73Mg8WJKlB9Y2SAJzeDKAnuB.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                movie_id = 527774,
                title = "Raya and the Last Dragon",
                date = "2021-03-03",
                poster = "/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                movie_id = 458576,
                title = "Monster Hunter",
                date = "2020-12-03",
                poster = "/1UCOF11QCw8kcqvce8LKOO6pimh.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                movie_id = 464052,
                title = "Wonder Woman 1984",
                date = "2020-12-16",
                poster = "/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                movie_id = 663558,
                title = "新神榜：哪吒重生",
                date = "2021-02-06",
                poster = "/6goDkAD6J3br81YMQf0Gat8Bqjy.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                movie_id = 664767,
                title = "Mortal Kombat Legends: Scorpion's Revenge",
                date = "2020-04-12",
                poster = "/4VlXER3FImHeFuUjBShFamhIp9M.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                movie_id = 587807,
                title = "Tom & Jerry",
                date = "2021-02-11",
                poster = "/6KErczPBROQty7QoIsaa6wJYXZi.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                movie_id = 793723,
                title = "Sentinelle",
                date = "2021-03-05",
                poster = "/fFRq98cW9lTo6di2o4lK1qUAWaN.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                movie_id = 544401,
                title = "Cherry",
                date = "2021-02-26",
                poster = "/pwDvkDyaHEU9V7cApQhbcSJMG1w.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                movie_id = 581389,
                title = "승리호",
                date = "2021-02-05",
                poster = "/p9YDHJKvUoi7v2SCd3vLGPae1Xp.jpg"
            )
        )
        return movies

    }

    fun generateDummyDetailMoviesIndex0(): MovieDetailEntity {
        return MovieDetailEntity(
            moviedetail_id = 460465,
            title = "Mortal Kombat",
            poster = "/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg",
            genres = "Fantasy,Action,Adventure,Science Fiction,Thriller",
            overview = "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
            backdrop = "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
            userScore = 7.8,
            date = "2021-04-07",
            duration = 110
        )
    }

    fun generateRemoteDummyMovies(): List<MovieResponse> {
        val movies = ArrayList<MovieResponse>()
        movies.add(
            MovieResponse(
                id = 460465,
                title = "Mortal Kombat",
                date = "2021-04-07",
                poster = "/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg"
            )
        )
        movies.add(
            MovieResponse(
                id = 399566,
                title = "Godzilla vs. Kong",
                date = "2021-03-24",
                poster = "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg"
            )
        )
        movies.add(
            MovieResponse(
                id = 635302,
                title = "劇場版「鬼滅の刃」無限列車編",
                date = "2020-10-16",
                poster = "/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg"
            )
        )
        movies.add(
            MovieResponse(
                id = 615457,
                title = "Nobody",
                date = "2021-03-18",
                poster = "/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg"
            )
        )

        movies.add(
            MovieResponse(
                id = 632357,
                title = "The Unholy",
                date = "2021-03-31",
                poster = "b4gYVcl8pParX8AjkN90iQrWrWO.jpg"
            )
        )
        movies.add(
            MovieResponse(
                id = 791373,
                title = "Zack Snyder's Justice League",
                date = "2021-03-18",
                poster = "/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg"
            )
        )

        movies.add(
            MovieResponse(
                id = 634528,
                title = "The Marksman",
                date = "2021-01-15",
                poster = "/6vcDalR50RWa309vBH1NLmG2rjQ.jpg"
            )
        )

        movies.add(
            MovieResponse(
                id = 726684,
                title = "Miraculous World Shanghai, la légende de Ladydragon",
                date = "2021-04-04",
                poster = "/msI5a9TPnepx47JUb2vl88hb80R.jpg"
            )
        )
        movies.add(
            MovieResponse(
                id = 804435,
                title = "Vanquish",
                date = "2021-04-16",
                poster = "/AoWY1gkcNzabh229Icboa1Ff0BM.jpg"
            )
        )
        movies.add(
            MovieResponse(
                id = 615678,
                title = "Thunder Force",
                date = "2021-04-09",
                poster = "/duK11VQd4UPDa7UJrgrGx90xJOx.jpg"
            )
        )
        movies.add(
            MovieResponse
                (
                id = 412656,
                title = "Chaos Walking",
                date = "2021-02-24",
                poster = "/9kg73Mg8WJKlB9Y2SAJzeDKAnuB.jpg"
            )
        )
        movies.add(
            MovieResponse
                (
                id = 527774,
                title = "Raya and the Last Dragon",
                date = "2021-03-03",
                poster = "/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg"
            )
        )
        movies.add(
            MovieResponse(
                id = 458576,
                title = "Monster Hunter",
                date = "2020-12-03",
                poster = "/1UCOF11QCw8kcqvce8LKOO6pimh.jpg"
            )
        )
        movies.add(
            MovieResponse(
                id = 464052,
                title = "Wonder Woman 1984",
                date = "2020-12-16",
                poster = "/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg"
            )
        )
        movies.add(
            MovieResponse(
                id = 663558,
                title = "新神榜：哪吒重生",
                date = "2021-02-06",
                poster = "/6goDkAD6J3br81YMQf0Gat8Bqjy.jpg"
            )
        )
        movies.add(
            MovieResponse(
                id = 664767,
                title = "Mortal Kombat Legends: Scorpion's Revenge",
                date = "2020-04-12",
                poster = "/4VlXER3FImHeFuUjBShFamhIp9M.jpg"
            )
        )
        movies.add(
            MovieResponse(
                id = 587807,
                title = "Tom & Jerry",
                date = "2021-02-11",
                poster = "/6KErczPBROQty7QoIsaa6wJYXZi.jpg"
            )
        )
        movies.add(
            MovieResponse(
                id = 793723,
                title = "Sentinelle",
                date = "2021-03-05",
                poster = "/fFRq98cW9lTo6di2o4lK1qUAWaN.jpg"
            )
        )
        movies.add(
            MovieResponse(
                id = 544401,
                title = "Cherry",
                date = "2021-02-26",
                poster = "/pwDvkDyaHEU9V7cApQhbcSJMG1w.jpg"
            )
        )
        movies.add(
            MovieResponse(
                id = 581389,
                title = "승리호",
                date = "2021-02-05",
                poster = "/p9YDHJKvUoi7v2SCd3vLGPae1Xp.jpg"
            )
        )
        return movies
    }

    fun generateRemoteDummyDetailMoviesIndex0(): MovieDetailResponse {
        return MovieDetailResponse(
            id = 460465,
            title = "Mortal Kombat",
            poster = "/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg",
            genres = arrayListOf(
                GenreResponse(id = 14, name = "Fantasy"),
                GenreResponse(id = 28, name = "Action"),
                GenreResponse(id = 12, name = "Adventure"),
                GenreResponse(id = 878, name = "Science Fiction"),
                GenreResponse(id = 53, name = "Thriller")
            ),
            overview = "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
            backdrop = "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
            userScore = 7.9,
            date = "2021-04-07",
            duration = 110
        )
    }

    fun generateDummyTvShow(): List<TvShowEntity> {
        val tvShow = ArrayList<TvShowEntity>()
        tvShow.add(
            TvShowEntity(
                poster = "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                title = "The Falcon and the Winter Soldier",
                tvshow_id = 88396,
                date = "2021-03-19"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                title = "The Good Doctor",
                tvshow_id = 71712,
                date = "2017-09-25"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/34FaY8qpjBAVysSfrJ1l7nrAQaD.jpg",
                title = "Luis Miguel: La Serie",
                tvshow_id = 79008,
                date = "2018-04-22"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                title = "The Flash",
                tvshow_id = 60735,
                date = "2014-10-07"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/r8ODGmfNbZQlNhiJl2xQENE2jsk.jpg",
                title = "Van Helsing",
                tvshow_id = 65820,
                date = "2016-09-23"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                title = "Grey's Anatomy",
                tvshow_id = 1416,
                date = "2005-03-27"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
                title = "Invincible",
                tvshow_id = 95557,
                date = "2021-03-26"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                title = "Riverdale",
                tvshow_id = 69050,
                date = "2017-01-26"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                title = "Lucifer",
                tvshow_id = 63174,
                date = "2016-01-25"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/glKDfE6btIRcVB5zrjspRIs4r52.jpg",
                title = "WandaVision",
                tvshow_id = 85271,
                date = "2021-01-15"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg",
                title = "The Walking Dead",
                tvshow_id = 1402,
                date = "2010-10-31"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
                title = "¿Quién mató a Sara?",
                tvshow_id = 120168,
                date = "2021-03-24"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/3T5mSuziI0TMa7z9R5w3vNl2qok.jpg",
                title = "La Reina del Flow",
                tvshow_id = 80240,
                date = "2018-06-12"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                title = "Game of Thrones",
                tvshow_id = 1399,
                date = "2011-04-17"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/4UjiPdFKJGJYdxwRs2Rzg7EmWqr.jpg",
                title = "Fear the Walking Dead",
                tvshow_id = 62286,
                date = "2015-08-23"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/vlv1gn98GqMnKHLSh0dNciqGfBl.jpg",
                title = "Superman & Lois",
                tvshow_id = 95057,
                date = "2021-02-23"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/Q1ZYG3kDS8iVIHOYOJ9NQmV0q7.jpg",
                title = "Haunted: Latinoamérica",
                tvshow_id = 120587,
                date = "2021-03-31"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/qTZIgXrBKURBK1KrsT7fe3qwtl9.jpg",
                title = "Legacies",
                tvshow_id = 79460,
                date = "2018-10-25"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/bQLrHIRNEkE3PdIWQrZHynQZazu.jpg",
                title = "Vikings",
                tvshow_id = 44217,
                date = "2013-03-03"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/kLEha9zVVv8acGFKTX4gjvSR2Q0.jpg",
                title = "The Vampire Diaries",
                tvshow_id = 18165,
                date = "2009-09-10"
            )
        )
        return tvShow
    }

    fun generateDummyDetailTvShowIndex0(): TvShowDetailEntity {
        return TvShowDetailEntity(
            tvshowdetail_id = 88396,
            title = "The Falcon and the Winter Soldier",
            poster = "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
            genres = "",
            /*genres = arrayListOf(
                GenresEntity(genre_id = 10765, name = "Sci-Fi & Fantasy"),
                GenresEntity(genre_id = 10759, name = "Action & Adventure"),
                GenresEntity(genre_id = 18, name = "Drama"),
                GenresEntity(genre_id = 10768, name = "War & Politics")
            ),*/
            overview = "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
            backdrop = "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
            userScore = 7.9,
            date = "2021-03-19",
            duration = 50
        )

    }

    fun generateRemoteDummyTvShow(): List<TvShowEntity> {
        val tvShow = ArrayList<TvShowEntity>()
        tvShow.add(
            TvShowEntity(
                poster = "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                title = "The Falcon and the Winter Soldier",
                tvshow_id = 88396,
                date = "2021-03-19"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                title = "The Good Doctor",
                tvshow_id = 71712,
                date = "2017-09-25"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/34FaY8qpjBAVysSfrJ1l7nrAQaD.jpg",
                title = "Luis Miguel: La Serie",
                 tvshow_id = 79008,
                date = "2018-04-22"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                title = "The Flash",
                tvshow_id = 60735,
                date = "2014-10-07"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/r8ODGmfNbZQlNhiJl2xQENE2jsk.jpg",
                title = "Van Helsing",
                tvshow_id = 65820,
                date = "2016-09-23"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                title = "Grey's Anatomy",
                tvshow_id = 1416,
                date = "2005-03-27"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
                title = "Invincible",
                tvshow_id = 95557,
                date = "2021-03-26"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                title = "Riverdale",
                tvshow_id = 69050,
                date = "2017-01-26"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                title = "Lucifer",
                tvshow_id = 63174,
                date = "2016-01-25"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/glKDfE6btIRcVB5zrjspRIs4r52.jpg",
                title = "WandaVision",
                tvshow_id = 85271,
                date = "2021-01-15"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg",
                title = "The Walking Dead",
                tvshow_id = 1402,
                date = "2010-10-31"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
                title = "¿Quién mató a Sara?",
                tvshow_id = 120168,
                date = "2021-03-24"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/3T5mSuziI0TMa7z9R5w3vNl2qok.jpg",
                title = "La Reina del Flow",
                tvshow_id = 80240,
                date = "2018-06-12"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                title = "Game of Thrones",
                tvshow_id = 1399,
                date = "2011-04-17"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/4UjiPdFKJGJYdxwRs2Rzg7EmWqr.jpg",
                title = "Fear the Walking Dead",
                tvshow_id = 62286,
                date = "2015-08-23"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/vlv1gn98GqMnKHLSh0dNciqGfBl.jpg",
                title = "Superman & Lois",
                tvshow_id = 95057,
                date = "2021-02-23"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/Q1ZYG3kDS8iVIHOYOJ9NQmV0q7.jpg",
                title = "Haunted: Latinoamérica",
                tvshow_id = 120587,
                date = "2021-03-31"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/qTZIgXrBKURBK1KrsT7fe3qwtl9.jpg",
                title = "Legacies",
                tvshow_id = 79460,
                date = "2018-10-25"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/bQLrHIRNEkE3PdIWQrZHynQZazu.jpg",
                title = "Vikings",
                tvshow_id = 44217,
                date = "2013-03-03"
            )
        )
        tvShow.add(
            TvShowEntity(
                poster = "/kLEha9zVVv8acGFKTX4gjvSR2Q0.jpg",
                title = "The Vampire Diaries",
                tvshow_id = 18165,
                date = "2009-09-10"
            )
        )
        return tvShow
    }

    fun generateRemoteDummyDetailTvShowIndex0(): TvShowDetailResponse {
        return TvShowDetailResponse(
            id = 88396,
            title = "The Falcon and the Winter Soldier",
            poster = "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
            genres = arrayListOf(
                GenreResponse(id = 10765, name = "Sci-Fi & Fantasy"),
                GenreResponse(id = 10759, name = "Action & Adventure"),
                GenreResponse(id = 18, name = "Drama"),
                GenreResponse(id = 10768, name = "War & Politics")
            ),
            overview = "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
            backdrop = "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
            userScore = 7.9,
            date = "2021-03-19",
            duration = arrayListOf(50)
        )

    }

}