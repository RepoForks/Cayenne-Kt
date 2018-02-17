package com.vicky7230.cayennekt.ui.home.likes

import com.vicky7230.cayennekt.data.network.model.recipes.Recipe
import com.vicky7230.cayennekt.ui.base.MvpPresenter

/**
 * Created by vicky on 17/2/18.
 */
interface LikesMvpPresenter<V : LikesMvpView> : MvpPresenter<V> {
    fun getRecipes()
    fun getRecipe(recipeId: String)
    fun removeRecipe(recipe: Recipe)
}