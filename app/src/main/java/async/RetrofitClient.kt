package async

import com.ShopBack.shopback.mvp.movie_details.MovieDetailModel
import com.ShopBack.shopback.mvp.movies.MovieListModel
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface RetrofitClient {

    //const val MOVIE_LIST_PATH = "discover/movie?api_key=328c283cd27bd1877d9080ccb1604c91&primary_release_date.lte=2016-12-31&sort_by=release_date.desc&page=1"


    @GET(ApiConst.MOVIE_LIST_PATH)
    fun requestMovieList(@Query("api_key") api_key: String ,
                         @Query("primary_release_date") primary_release_date: String ,
                         @Query("sort_by") sort_by: String ,
                         @Query("page") page: Int): Observable<MovieListModel>

    @GET(ApiConst.MOVIE_TAG+"{movie_id}"+ApiConst.API_KEY_PATH)
    fun requestMovieDetail(@Path(value = "movie_id", encoded = true) movie_id: String): Observable<MovieDetailModel>


    companion object {

        fun createClient(): RetrofitClient {
            return createRetrofitClient(ApiConst.BASE_URL)
        }

        fun createRetrofitClient(baseUrl: String): RetrofitClient {

            val client = OkHttpClient.Builder()
            client.connectTimeout(100, TimeUnit.SECONDS)
            client.readTimeout(30, TimeUnit.SECONDS)

            return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .client(client.build())
                .build().create(RetrofitClient::class.java)
        }
    }
}