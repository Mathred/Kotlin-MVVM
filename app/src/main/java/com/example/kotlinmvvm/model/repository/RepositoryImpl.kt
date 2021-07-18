package com.example.kotlinmvvm.model.repository

import com.example.kotlinmvvm.model.entities.ActorList
import com.example.kotlinmvvm.model.entities.Movie
import com.example.kotlinmvvm.model.entities.MovieCategory
import com.example.kotlinmvvm.model.entities.TV
import com.example.kotlinmvvm.model.rest_entities.trending_list.TrendingMovieListDTO
import com.example.kotlinmvvm.model.rest_entities.trending_list.TrendingMovieListLoader

class RepositoryImpl : Repository {

    val defaultCategoryList = listOf<MovieCategory>()

    override fun getMovieFromServer(id: Int?): Movie {
        return Movie()
    }

    override fun getMovieFromLocalStorage(id: Int?): Movie {
        return Movie()
    }

    override fun getMovieListFromServer(id: Int?): MovieCategory {
        return MovieCategory()
    }

    override fun getMovieListFromLocalStorage(id: Int?): MovieCategory {
        return MovieCategory()
    }

    override fun getActorListFromServer(id: Int?): ActorList {
        return ActorList()
    }

    override fun getActorListFromLocalStorage(id: Int?): ActorList {
        return ActorList()
    }

    override fun getDefaultCategoriesList(): List<MovieCategory> {
        return listOf(
            MovieCategory("default1"),
            MovieCategory("default2"),
            MovieCategory("default3"),
            MovieCategory("default4")
        )
    }

    override fun getTrendingMoviesListToday(): MovieCategory {
        val dto : TrendingMovieListDTO = TrendingMovieListLoader.loadTrendingMovieList(TrendingMovieListLoader.TimeWindow.DAY,TrendingMovieListLoader.MediaType.MOVIE) as TrendingMovieListDTO
        val movieCategory = MovieCategory(categoryTitle = "Movies trending today")
        var movie: Movie
        for (i in 0..10) {
            movie = Movie(
                id = dto?.results?.getOrNull(i)?.id,
                title = dto?.results?.getOrNull(i)?.title,
                voteAverage = dto?.results?.getOrNull(i)?.vote_average
            )
            movieCategory.movieList.add(movie)
        }
        return movieCategory
    }

    override fun getTrendingMoviesListWeek(): List<Movie> {
        TODO("Not yet implemented")
    }

    override fun getTrendingTVListToday(): List<TV> {
        TODO("Not yet implemented")
    }

    override fun getTrendingTVListWeek(): List<TV> {
        TODO("Not yet implemented")
    }

    override fun getNowPlayingMoviesList(): List<Movie> {
        TODO("Not yet implemented")
    }

    override fun getPopularMoviesList(): List<Movie> {
        TODO("Not yet implemented")
    }

    override fun getTopRatedMoviesList(): List<Movie> {
        TODO("Not yet implemented")
    }

    override fun getUpcomingMoviesList(): List<Movie> {
        TODO("Not yet implemented")
    }

    companion object {
        const val API_KEY_V3 = "24574bb4e0503d28dcac21318ff13d30"
    }
}