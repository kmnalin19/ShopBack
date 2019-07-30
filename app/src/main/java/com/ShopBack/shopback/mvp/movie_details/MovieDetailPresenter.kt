package com.ShopBack.shopback.mvp.movie_details

import android.view.View
import async.ApiConst
import async.AsyncMovieDetail
import base.BasePresenter
import base.listeners.IView
import com.ShopBack.shopback.mvp.movies.MovieModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_detail_window_fg.view.*

class MovieDetailPresenter(val iMovieListDetailView : IMovieListDetailView, var view1: View,val movieModel: MovieModel) : BasePresenter<IView>(iMovieListDetailView),IMovieDetailPresenter {

    val asyncMovieDetail = AsyncMovieDetail()
    init {
        initView()
        movieModel.id.let {
            asyncMovieDetail.requestMovieDetail(this,movieModel.id.toString())
        }
    }

    fun initView(){

        Picasso.get()
            .load(ApiConst.BANNER_IMAGE_URL + movieModel.poster_path)
            .fit()
            .into(view1.movie_detail_thumb_image)
        view1.movie_synopsis.text = movieModel.overview
    }

    override fun onMovieDetailSuccess(movieDetailModel: MovieDetailModel) {

        var backdrop_path = movieDetailModel.backdrop_path

        if (movieDetailModel.backdrop_path.isNullOrEmpty()){
            backdrop_path = movieModel.poster_path
        }
        Picasso.get()
            .load(ApiConst.BANNER_IMAGE_URL + backdrop_path)
            .fit()
            .into(view1.movie_detail_image)
        view1.movie_synopsis.text = movieDetailModel.overview
        view1.movie_detail_title_tv.text = movieDetailModel.title
        view1.movie_detail_duration_tv.text = movieDetailModel.runtime.plus(" Minutes")

        for ( genres in movieDetailModel.genres) {
            view1.movie_detail_genres_tv.append(genres.name +" ")
        }
        for ( language in movieDetailModel.spoken_languages) {
            view1.movie_detail_language_tv.append(language.name +" ")
        }
    }

    override fun onMovieDetailFail(any: Any) {

    }

}

private operator fun Int.plus(s: String): CharSequence? {
    return this.toString() + s
}
