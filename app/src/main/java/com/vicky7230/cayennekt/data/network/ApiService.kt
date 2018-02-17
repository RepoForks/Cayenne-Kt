package com.vicky7230.cayennekt.data.network

import com.vicky7230.cayennekt.data.network.model.recipes.Recipes
import com.vicky7230.cayennekt.data.network.model.singleRecipe.SingleRecipe
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


/**
 * Created by vicky on 31/12/17.
 */
interface ApiService {
    @FormUrlEncoded
    @POST("search")
    fun getRecipes(
        @Field("key") key: String,
        @Field("page") page: String,
        @Field("count") count: String
    ): Observable<Recipes>

    @FormUrlEncoded
    @POST("get")
    fun getRecipe(
        @Field("key") key: String,
        @Field("rId") rId: String
    ): Observable<SingleRecipe>
}