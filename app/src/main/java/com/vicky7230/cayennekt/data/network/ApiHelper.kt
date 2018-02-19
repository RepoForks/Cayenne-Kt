package com.vicky7230.cayennekt.data.network

import com.vicky7230.cayennekt.data.network.model.recipes.Recipes
import com.vicky7230.cayennekt.data.network.model.singleRecipe.SingleRecipe
import io.reactivex.Observable
import retrofit2.http.Field

/**
 * Created by vicky on 31/12/17.
 */
interface ApiHelper {

    fun getRecipes(key: String, page: String, count: String): Observable<Recipes>

    fun getRecipe(key: String, rId: String): Observable<SingleRecipe>

    fun searchRecipes(key: String, query: String, page: String): Observable<Recipes>
}