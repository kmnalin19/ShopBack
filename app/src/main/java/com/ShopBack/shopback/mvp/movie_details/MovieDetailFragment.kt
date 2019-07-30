package com.ShopBack.shopback.mvp.movie_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import base.BaseFragment
import com.ShopBack.shopback.R
import com.ShopBack.shopback.mvp.movies.MovieModel
import androidx.appcompat.app.AppCompatActivity

class MovieDetailFragment : BaseFragment<MovieDetailPresenter>(),IMovieListDetailView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.movie_detail_window_fg, container, false)
        (activity as AppCompatActivity).supportActionBar!!.hide()
        return view
    }

    override fun instantiatePresenter(view: View): MovieDetailPresenter {
        return MovieDetailPresenter(this,view,arguments!!.getParcelable("movieModel") as MovieModel)
    }
}