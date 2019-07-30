package async

import com.ShopBack.shopback.mvp.movie_details.IMovieDetailPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class AsyncMovieDetail {

    val client by lazy {
        RetrofitClient.createClient()
    }
    var disposable: Disposable? = null

    fun requestMovieDetail(iMovieDetailPresenter : IMovieDetailPresenter,movieId : String) {

        disposable = client.requestMovieDetail(movieId)
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    iMovieDetailPresenter.onMovieDetailSuccess(it)
                },
                {
                    iMovieDetailPresenter.onMovieDetailFail(it)
                }

            )
    }

}