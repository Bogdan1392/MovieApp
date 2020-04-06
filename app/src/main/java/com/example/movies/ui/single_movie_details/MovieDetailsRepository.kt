package com.example.movies.ui.single_movie_details

import androidx.lifecycle.LiveData
import com.example.movies.data.api.TheMovieDbInterface
import com.example.movies.data.repository.MovieDetailsNetworkDataSource
import com.example.movies.data.repository.NetworkState
import com.example.movies.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository(private val apiService: TheMovieDbInterface) {
    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails(compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<MovieDetails> {
        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService, compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieDetailsResponse
    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }
    // might seem like an extra step, but this would come in handy if we would want to cache de data in local storage
}