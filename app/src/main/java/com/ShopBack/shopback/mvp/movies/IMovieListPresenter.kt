package com.ShopBack.shopback.mvp.movies

interface IMovieListPresenter {
    fun onMovieListSuccess(movieListModel : MovieListModel)
    fun onMovieListFail(any : Any)
}