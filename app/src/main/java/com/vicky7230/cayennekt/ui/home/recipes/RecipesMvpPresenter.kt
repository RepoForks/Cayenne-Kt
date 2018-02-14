package com.vicky7230.cayennekt.ui.home.recipes

import com.vicky7230.cayennekt.ui.base.MvpPresenter

/**
 * Created by vicky on 13/2/18.
 */
interface RecipesMvpPresenter<V : RecipesMvpView> : MvpPresenter<V> {
    fun getRecipes()
}