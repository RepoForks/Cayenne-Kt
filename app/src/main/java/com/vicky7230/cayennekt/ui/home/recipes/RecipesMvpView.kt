package com.vicky7230.cayennekt.ui.home.recipes

import com.vicky7230.cayennekt.data.network.model.recipes.Recipe
import com.vicky7230.cayennekt.ui.base.MvpView

/**
 * Created by vicky on 13/2/18.
 */
interface RecipesMvpView : MvpView {
    fun updateRecipeList(recipes: MutableList<Recipe>)
    fun showIngredients(ingredients: List<String>?)
    fun showErrorInRecyclerView()
}