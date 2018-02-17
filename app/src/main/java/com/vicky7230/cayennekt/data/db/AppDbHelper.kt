package com.vicky7230.cayennekt.data.db

import com.vicky7230.cayennekt.data.db.room.AppDatabase
import com.vicky7230.cayennekt.data.network.model.recipes.Recipe
import javax.inject.Inject

/**
 * Created by vicky on 31/12/17.
 */
class AppDbHelper @Inject
constructor(private val appDatabase: AppDatabase) : DbHelper {
    override fun insertRecipe(recipe: Recipe?) =
        appDatabase.recipeDao().insertRecipe(recipe)

    override fun selectRecipes() =
        appDatabase.recipeDao().selectRecipes()

    override fun selectRecipe(recipeId: String) =
        appDatabase.recipeDao().selectRecipe(recipeId)

    override fun deleteRecipe(recipe: Recipe?) =
        appDatabase.recipeDao().deleteRecipe(recipe)

}