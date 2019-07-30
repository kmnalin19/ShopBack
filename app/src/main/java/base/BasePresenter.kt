package base

import base.listeners.IView


/**
 * Base presenter any presenter of the application must extend. It provides initial injections and
 * required methods.
 * @param V the type of the View the presenter is based on
 * @property view the view the presenter is based on
 * @constructor Injects the required dependencies
 */
abstract class BasePresenter<out V : IView>(protected val view: V) {


    init {
        inject()
    }
    /**
     * This method may be called when the presenter view is created
     */
    protected open fun getToken(){}

    /**
     * This method may be called when the presenter view is created
     */
    open fun onViewCreated(){}

    /**
     * This method may be called when the presenter view is destroyed
     */
    open fun onViewDestroyed(){}

    open fun onResume(){}

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        //TODO: Implement this method
    }
}