package base.listeners

import android.app.Activity
import android.content.Context

interface IView {

    /**
     * Returns the context in which the application is running.
     * @return the context in which the application is running
     */
    fun requestContext():Context
    fun requestActivity():Activity

    fun onFailed(o : Any)
    fun onSuccess(o : Any)
    fun onError(o : Any)
}