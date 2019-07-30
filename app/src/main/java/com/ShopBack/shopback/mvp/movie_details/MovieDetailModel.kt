package com.ShopBack.shopback.mvp.movie_details

import com.google.gson.annotations.SerializedName
import java.util.*

data class MovieDetailModel(
    @SerializedName("adult") val adult: Boolean,
    @SerializedName("backdrop_path") val backdrop_path: String,
    @SerializedName("budget") val budget: Double,
    @SerializedName("belongs_to_collection") val belongs_to_collection: BelongsToCollection,
    @SerializedName("genres") val genres: ArrayList<Genres>,
    @SerializedName("homepage") val homepage: String,
    @SerializedName("id") val id: Int,
    @SerializedName("imdb_id") val imdb_id: String,
    @SerializedName("original_language") val original_language: String,
    @SerializedName("original_title") val original_title: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("popularity") val popularity: Float,
    @SerializedName("poster_path") val poster_path: String,
    @SerializedName("production_companies") val production_companies: ArrayList<ProductionCompanies>,
    @SerializedName("production_countries") val production_countries: ArrayList<ProductionCountries>,
    @SerializedName("release_date") val release_date: String,
    @SerializedName("revenue") val revenue: Double,
    @SerializedName("runtime") val runtime: Int,
    @SerializedName("spoken_languages") val spoken_languages: ArrayList<SpokenLanguages>,
    @SerializedName("status") val status: String,
    @SerializedName("tagline") val tagline: String,
    @SerializedName("title") val title: String,
    @SerializedName("video") val video: Boolean,
    @SerializedName("vote_average") val vote_average: Float,
    @SerializedName("vote_count") val vote_count: Int
)


data class BelongsToCollection(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("poster_path") val poster_path: String,
    @SerializedName("backdrop_path") val backdrop_path: String
)

data class Genres(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
)


data class ProductionCompanies(
    @SerializedName("id") val id: Int,
    @SerializedName("logo_path") val logo_path: String,
    @SerializedName("name") val name: String,
    @SerializedName("origin_country") val origin_country: String
)


data class ProductionCountries(
    @SerializedName("iso_3166_1") val iso_3166_1: String,
    @SerializedName("name") val name: String
)


data class SpokenLanguages(
    @SerializedName("iso_639_1") val iso_639_1: String,
    @SerializedName("name") val name: String
)

