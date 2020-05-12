package com.example.movies.data.api

import com.example.movies.data.vo.MovieDetails
import com.example.movies.data.vo.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieDbInterface {

    @GET("movie/popular")
    fun getPopularMovie(@Query("page") page: Int): Single<MovieResponse>

    @GET("movie/latest")
    fun getLatestMovie(@Query("page") page: Int): Single<MovieResponse>

    @GET("movie/upcoming")
    fun getUpcomingMovie(@Query("page") page: Int): Single<MovieResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id: Int): Single<MovieDetails>
}