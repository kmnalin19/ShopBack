package com.ShopBack.shopback.mvp.movies

import android.view.View
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import async.AsyncMovieList
import base.BasePresenter
import base.listeners.IView
import com.ShopBack.shopback.adapters.MovieListAdapter
import kotlinx.android.synthetic.main.movie_list_window_fg.view.*
import listners.ListItemClickListner
import androidx.recyclerview.widget.RecyclerView



class MovieListPresenter(val iMovieListView: IMovieListView, var view1: View) :
    BasePresenter<IView>(iMovieListView), IMovieListPresenter, ListItemClickListner {

    val asyncMovieDetail = AsyncMovieList()
    private var loading = true
    private var pullToRefresh = false

    companion object{

        var listPageNumber = 1
    }

    init {
        initView()
        requestMovieList(listPageNumber)
        view1.movielist_loading_spinner.visibility = View.GONE
    }

    fun requestMovieList(pageNumber : Int = 1) {
        view1.movielist_loading_spinner.visibility = View.VISIBLE
        asyncMovieDetail.requestMovieList(this,pageNumber)
    }

    fun initView() {
        view1.movielist_recyclerview!!.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        view1.swipe_container.setOnRefreshListener {
            pullToRefresh = true
            requestMovieList(1)
        }
        view1.movielist_recyclerview!!.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val staggeredGridLayoutManager = recyclerView.layoutManager as StaggeredGridLayoutManager?

                //requestMovieList(4)
                if (dy > 0) {

                   val totalItemCount = staggeredGridLayoutManager!!.itemCount
                    val positions = IntArray(2)
                   val lastPositions = staggeredGridLayoutManager!!.findLastVisibleItemPositions(positions)
                   val lastVisibleItem = Math.max(lastPositions[0], lastPositions[1]);//findMax(lastPositions);

                    if (!loading  && totalItemCount - 2 <= lastVisibleItem ) {
                        listPageNumber ++
                        requestMovieList(listPageNumber)
                        loading = true
                    }
                }
            }
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

        })
    }

    override fun onMovieListSuccess(movieListModel: MovieListModel) {

        view1.movielist_loading_spinner.visibility = View.GONE
        if (view1.movielist_recyclerview!!.adapter == null) {
            view1.movielist_recyclerview!!.adapter = MovieListAdapter(iMovieListView.requestContext(), movieListModel.results.filter {
                !it.poster_path.isNullOrEmpty()
            } as ArrayList<MovieModel>, this)
        } else {
            if (pullToRefresh) {
                (view1.movielist_recyclerview!!.adapter as MovieListAdapter).refreshCollection(movieListModel.results.filter {
                    !it.poster_path.isNullOrEmpty()
                } as ArrayList<MovieModel>)
            }
            else{
                (view1.movielist_recyclerview!!.adapter as MovieListAdapter).updateCollection(movieListModel.results.filter {
                    !it.poster_path.isNullOrEmpty()
                } as ArrayList<MovieModel>)
            }
            view1.movielist_recyclerview!!.adapter!!.notifyDataSetChanged()
        }
        view1.swipe_container.isRefreshing = false
        loading = false
    }

    override fun onMovieListFail(any: Any) {
        view1.movielist_loading_spinner.visibility = View.GONE
        view1.swipe_container.isRefreshing = false
        loading = false
        pullToRefresh = false
    }

    override fun setOnSelectListener(value: MovieModel) {
        iMovieListView.onMovieSelectListener(value)
    }

    override fun setOnDeSelectListener(value: MovieModel) {

    }
}