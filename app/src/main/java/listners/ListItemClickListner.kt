package listners

import android.view.View
import com.ShopBack.shopback.mvp.movies.MovieModel

interface ListItemClickListner {

    fun setOnSelectListener(value : MovieModel)
    fun setOnDeSelectListener(value : MovieModel)
}