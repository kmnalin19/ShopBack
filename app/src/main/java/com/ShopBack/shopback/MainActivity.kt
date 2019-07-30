package com.ShopBack.shopback

import android.os.Bundle
import android.view.WindowManager
import base.BaseActivity
import com.ShopBack.shopback.mvp.movies.MovieListFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        window?.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_main)
        replaceFragment(MovieListFragment(),R.id.content)
    }
}
