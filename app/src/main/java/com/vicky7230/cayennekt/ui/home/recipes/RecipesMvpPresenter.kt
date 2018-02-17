package com.vicky7230.cayennekt.ui.home.recipes

import com.vicky7230.cayennekt.data.network.model.recipes.Recipe
import com.vicky7230.cayennekt.ui.base.MvpPresenter

/**
 * Created by vicky on 13/2/18.
 */
interface RecipesMvpPresenter<V : RecipesMvpView> : MvpPresenter<V> {
    fun getRecipes()
    fun getRecipe(recipeId: String)
    fun saveRecipe(recipe: Recipe?)
}