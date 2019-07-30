package com.ShopBack.shopback.mvp.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import base.BaseFragment
import com.ShopBack.shopback.R
import com.ShopBack.shopback.mvp.movie_details.MovieDetailFragment

class MovieListFragment : BaseFragment<MovieListPresenter>(),IMovieListView{

    var rootView : View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        if (rootView == null){
            rootView = inflater.inflate(R.layout.movie_list_window_fg, container, false)
            instantiatePresenter(rootView!!)
        }
        (activity as AppCompatActivity).supportActionBar!!.show()
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    override fun instantiatePresenter(view: View): MovieListPresenter {
        return MovieListPresenter(this,view)
    }

    override fun onMovieSelectListener(movieModel: MovieModel) {

        val bundle = Bundle()
        bundle.putParcelable("movieModel", movieModel)
        val movieDetailFragment = MovieDetailFragment()
        movieDetailFragment.arguments = bundle
        replaceFragment(movieDetailFragment,R.id.content)
    }
}