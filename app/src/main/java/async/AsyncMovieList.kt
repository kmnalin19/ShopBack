package async

import com.ShopBack.shopback.mvp.movies.IMovieListPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class AsyncMovieList {

    val client by lazy {
        RetrofitClient.createClient()
    }

    var disposable: Disposable? = null

    fun requestMovieList(iMovieListPresenter : IMovieListPresenter,pageNumber : Int ) {

        disposable = client.requestMovieList(api_key = ApiConst.API_KEY,primary_release_date = "2016-12-31",
            sort_by = "release_date.desc", page = pageNumber
        )
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    iMovieListPresenter.onMovieListSuccess(it)
                },
                {
                    iMovieListPresenter.onMovieListFail(it)
                }

            )
    }

}