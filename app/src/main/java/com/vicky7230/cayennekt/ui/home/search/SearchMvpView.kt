package com.vicky7230.cayennekt.ui.home.search

import com.vicky7230.cayennekt.data.network.model.recipes.Recipe
import com.vicky7230.cayennekt.ui.base.MvpView

/**
 * Created by vicky on 17/2/18.
 */
interface SearchMvpView : MvpView {
    fun refreshSearchList(recipes: MutableList<Recipe>)
    fun updateRecipeList(recipes: MutableList<Recipe>)
    fun showErrorInRecyclerView()
}