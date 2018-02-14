package com.vicky7230.cayennekt.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Recipes(
    @SerializedName("count")
    @Expose
    var count: Int? = null,
    @SerializedName("recipes")
    @Expose
    var recipes: MutableList<Recipe>? = null
)

