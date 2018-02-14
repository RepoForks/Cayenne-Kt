package com.vicky7230.cayennekt.ui.home

import com.vicky7230.cayennekt.data.DataManager
import com.vicky7230.cayennekt.ui.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by vicky on 11/2/18.
 */
class HomePresenter<V : HomeMvpView> @Inject constructor(
    private val dataManager: DataManager,
    private val compositeDisposable: CompositeDisposable
) : BasePresenter<V>(dataManager, compositeDisposable), HomeMvpPresenter<V> {

}