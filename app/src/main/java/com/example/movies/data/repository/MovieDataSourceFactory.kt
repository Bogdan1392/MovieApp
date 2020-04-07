package com.example.movies.data.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.movies.data.api.TheMovieDbInterface
import com.example.movies.data.vo.Movie
import io.reactivex.disposables.CompositeDisposable

class MovieDataSourceFactory(private val apiService : TheMovieDbInterface, private val compositeDisposable: CompositeDisposable) : DataSource.Factory<Int, Movie>() {

    val movieLiveDataSource = MutableLiveData<MovieDataSource>()

    override fun create(): DataSource<Int, Movie> {
        val movieDataSource = MovieDataSource(apiService, compositeDisposable)

        movieLiveDataSource.postValue(movieDataSource)
        return movieDataSource
    }
}