package com.vicky7230.cayennekt.ui.home.recipes

import com.vicky7230.cayennekt.data.Config
import com.vicky7230.cayennekt.data.DataManager
import com.vicky7230.cayennekt.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by vicky on 13/2/18.
 */
class RecipesPresenter<V : RecipesMvpView> @Inject constructor(
    private val dataManager: DataManager,
    private val compositeDisposable: CompositeDisposable
) : BasePresenter<V>(dataManager, compositeDisposable), RecipesMvpPresenter<V> {

    var page = 1

    override fun getRecipes() {

        compositeDisposable.addAll(
            dataManager.getRecipes(
                Config.API_KEY,
                page.toString(),
                "10"
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ recipes ->
                    if (!isViewAttached())
                        return@subscribe
                    mvpView?.hideLoading()
                    if (recipes.recipes != null) {
                        mvpView?.updateRecipeList(recipes.recipes!!)
                        ++page
                    }
                }, { throwable ->
                    if (!isViewAttached())
                        return@subscribe
                    mvpView?.hideLoading()
                    Timber.e(throwable.message)
                })

        )
    }

}