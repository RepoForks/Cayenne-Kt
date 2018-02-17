package com.vicky7230.cayennekt.ui.home

import android.support.v7.util.DiffUtil
import com.vicky7230.cayennekt.data.network.model.recipes.Recipe


/**
 * Created by vicky on 3/1/18.
 */

class RecipeDiffUtilCallback(
    private val oldRecipeList: MutableList<Recipe>?,
    private val newRecipeList: MutableList<Recipe>?
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldRecipeList?.size!!
    }

    override fun getNewListSize(): Int {
        return newRecipeList?.size!!
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldRecipeList?.get(oldItemPosition)?.recipeId == newRecipeList?.get(newItemPosition)?.recipeId
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldRecipeList?.get(oldItemPosition) == newRecipeList?.get(newItemPosition)
    }
}