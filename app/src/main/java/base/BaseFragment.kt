package base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import base.listeners.IView

abstract class BaseFragment<P : BasePresenter<IView>> : IView, Fragment() {

    protected abstract fun instantiatePresenter(view: View): P

    fun replaceFragment(fragment: Fragment, container : Int){
        activity!!.supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            .replace(container, fragment, "rageComicList").addToBackStack("fragment")
            .commit()
    }

    fun replaceFragment1(fragment: Fragment, container : Int){

        // it won't add to stack
        activity!!.supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            .replace(container, fragment, "rageComicList")
            .commit()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        instantiatePresenter(view)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun requestContext(): Context {
        return activity!!.applicationContext
    }

    override fun requestActivity(): Activity {
       return activity!!
    }

    override fun onFailed(o: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSuccess(o: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(o: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}