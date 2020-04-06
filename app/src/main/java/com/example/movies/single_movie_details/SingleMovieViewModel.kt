package com.example.movies.single_movie_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.movies.data.repository.NetworkState
import com.example.movies.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class SingleMovieViewModel (private val movieRepository: MovieDetailsRepository, movieId: Int) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    val movieDetails : LiveData<MovieDetails> = movieRepository.fetchSingleMovieDetails(compositeDisposable, movieId)
    val networkState : LiveData<NetworkState> = movieRepository.getMovieDetailsNetworkState()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}