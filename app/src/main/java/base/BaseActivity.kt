package base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


open class BaseActivity : AppCompatActivity() {

    fun replaceFragment(fragment: Fragment, container : Int){
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            .replace(container, fragment, "rageComicList")
            .commit()
    }
}