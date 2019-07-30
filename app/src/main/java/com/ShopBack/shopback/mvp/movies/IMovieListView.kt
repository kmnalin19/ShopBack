package com.ShopBack.shopback.mvp.movies

import base.listeners.IView

interface IMovieListView : IView{

    fun onMovieSelectListener(movieModel : MovieModel)
}