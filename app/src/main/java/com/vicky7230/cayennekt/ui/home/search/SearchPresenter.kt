package com.vicky7230.cayennekt.ui.home.search

import com.vicky7230.cayennekt.data.DataManager
import com.vicky7230.cayennekt.ui.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by vicky on 17/2/18.
 */
class SearchPresenter<V : SearchMvpView> @Inject constructor(
    private val dataManager: DataManager,
    private val compositeDisposable: CompositeDisposable
) : BasePresenter<V>(dataManager, compositeDisposable), SearchMvpPresenter<V> {


}