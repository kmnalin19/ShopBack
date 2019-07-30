package com.ShopBack.shopback.mvp.movies

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class MovieListModel(@SerializedName("page") val page: Int,
                          @SerializedName("total_results") val total_results: Int,
                          @SerializedName("total_pages") val total_pages: Int,
                          @SerializedName("results") val results: ArrayList<MovieModel>)