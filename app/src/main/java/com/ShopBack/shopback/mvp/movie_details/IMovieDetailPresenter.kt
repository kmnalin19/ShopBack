package com.ShopBack.shopback.mvp.movie_details


interface IMovieDetailPresenter {

    fun onMovieDetailSuccess(movieDetailModel : MovieDetailModel)
    fun onMovieDetailFail(any : Any)
}