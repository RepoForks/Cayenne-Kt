package com.vicky7230.cayennekt.ui.home.search

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vicky7230.cayennekt.R
import com.vicky7230.cayennekt.data.network.model.recipes.Recipe

/**
 * Created by vicky on 17/2/18.
 */
class SearchAdapter(private val recipeList: MutableList<Recipe>?) :

    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return SearchItemViewHolder(
            LayoutInflater.from(parent?.context).inflate(
                R.layout.search_list_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return recipeList?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as SearchItemViewHolder).onBind(position)
    }

    class SearchItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(position: Int) {

        }
    }
}