package com.vicky7230.cayennekt.ui.home.search

import com.vicky7230.cayennekt.data.network.model.recipes.Recipe
import com.vicky7230.cayennekt.ui.base.MvpPresenter
import io.reactivex.subjects.PublishSubject

/**
 * Created by vicky on 17/2/18.
 */
interface SearchMvpPresenter<V : SearchMvpView> : MvpPresenter<V> {
    fun search(subject: PublishSubject<String>)
    fun getNextPage()
    fun saveRecipe(recipe: Recipe?)
}