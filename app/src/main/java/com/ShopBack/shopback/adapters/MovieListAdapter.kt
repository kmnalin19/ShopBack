package com.ShopBack.shopback.adapters

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import async.ApiConst
import com.ShopBack.shopback.R
import com.ShopBack.shopback.mvp.movies.MovieModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_list_row.view.*
import listners.ListItemClickListner
import java.util.*
import kotlin.collections.ArrayList

class MovieListAdapter( val context: Context,private var movies: ArrayList<MovieModel>,val recycleViewClickListner : ListItemClickListner) : RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder>() {

    private val mRandom = Random()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        return MovieListViewHolder(LayoutInflater.from(context).inflate(R.layout.movie_list_row, parent, false))
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {

        val movie = movies[position]
            Picasso.get()
                .load(ApiConst.BANNER_IMAGE_URL + movies[position].poster_path)
                .fit()
                .into(holder.view.movie_list_thumb)

        movie.title.let { holder.view.movie_list_title.text = it }
        movie.popularity.let { holder.view.movie_list_popularity.text = it.toString() }

        holder.view.movie_list_view.layoutParams.height = getRandomIntInRange(1000, 750)
        holder.view.tag = movie
        holder.view.setOnClickListener {
            recycleViewClickListner.setOnSelectListener(it.tag as MovieModel)
        }
    }


    class MovieListViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var view: View = v
    }

    private fun getRandomIntInRange(max: Int, min: Int): Int {
        val mRandomHeight =  mRandom.nextInt(max - min + min) + min
        return if (mRandomHeight in 700..1000) mRandomHeight else 700
    }

    fun refreshCollection(movieList: ArrayList<MovieModel>){
        movies = movieList
    }

    fun updateCollection(movieList: List<MovieModel>){
        movies.addAll(movieList)
    }
}