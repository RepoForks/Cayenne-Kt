package com.vicky7230.cayennekt.ui.home.likes

import com.vicky7230.cayennekt.data.network.model.recipes.Recipe
import com.vicky7230.cayennekt.ui.base.MvpView

/**
 * Created by vicky on 17/2/18.
 */
interface LikesMvpView : MvpView {
    fun updateLikeList(recipes: MutableList<Recipe>?)
    fun showIngredients(ingredients: List<String>?)
}