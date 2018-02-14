package com.vicky7230.cayennekt.data.network.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Recipe(

        var type: String = "RECIPE",

        @SerializedName("publisher")
        @Expose
        var publisher: String = "",

        @SerializedName("f2f_url")
        @Expose
        var f2fUrl: String = "",

        @SerializedName("title")
        @Expose
        var title: String = "",

        @SerializedName("source_url")
        @Expose
        var sourceUrl: String = "",

        @SerializedName("recipe_id")
        @Expose
        var recipeId: String = "",

        @SerializedName("image_url")
        @Expose
        var imageUrl: String = "",

        @SerializedName("social_rank")
        @Expose
        var socialRank: Float = 0f,

        @SerializedName("publisher_url")
        @Expose
        var publisherUrl: String = ""
)
