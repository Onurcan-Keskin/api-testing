package com.t4zb.kotlinapitesting.ui.contract

/**
 * 功能描述
 *
 * @author o00559125
 * @since 2021-08-23
 */
class BaseContract {
    interface ViewMain {
        fun setupViewModel()
        fun initializeViews()
    }

    interface PresenterMain {
        fun onViewsCreated()
    }
}