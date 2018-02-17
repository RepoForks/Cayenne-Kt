package com.vicky7230.cayennekt.data.db.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.vicky7230.cayenne.data.db.room.RecipeDao
import com.vicky7230.cayennekt.data.network.model.recipes.Recipe

/**
 * Created by vicky on 31/12/17.
 */
@Database(entities = [Recipe::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun recipeDao(): RecipeDao
}