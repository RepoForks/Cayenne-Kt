package com.vicky7230.cayennekt.data.network

import com.vicky7230.cayennekt.data.network.model.Recipes
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
}