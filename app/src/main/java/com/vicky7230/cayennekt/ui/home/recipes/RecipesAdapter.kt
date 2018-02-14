package com.vicky7230.cayennekt.ui.home.recipes

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.vicky7230.cayennekt.R
import com.vicky7230.cayennekt.data.network.model.Recipe
import com.vicky7230.cayennekt.utils.GlideApp
import kotlinx.android.synthetic.main.recipe_list_item.view.*


/**
 * Created by vicky on 1/1/18.
 */
class RecipesAdapter(private val recipeList: MutableList<Recipe>?) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_LOADING = -1
    private val TYPE_RECIPE = 1

    interface Callback {
        fun onLikeRecipeClick(position: Int)

        fun onRetryClick()

        fun onShareClick(sourceUrl: String)

        fun onIngredientsClick(recipeId: String)

        fun onSingleClick(recipe: Recipe)
    }

    private var callback: Callback? = null

    fun setCallback(callback: Callback) {
        this.callback = callback
    }

    fun addItems(recipeList: MutableList<Recipe>?) {

        val newRecipeList = ArrayList<Recipe>()
        newRecipeList.addAll(this.recipeList!!)
        newRecipeList.addAll(recipeList!!)

        val diffResult =
            DiffUtil.calculateDiff(RecipeDiffUtilCallback(this.recipeList, newRecipeList))
        this.recipeList.addAll(recipeList)
        diffResult.dispatchUpdatesTo(this)
    }


    fun addItem(recipe: Recipe?) {
        recipeList?.add(recipe!!)
        notifyItemInserted(recipeList!!.size - 1)
    }

    fun removeItem() {
        recipeList?.removeAt(recipeList.size - 1)
        notifyItemRemoved(recipeList!!.size)
    }

    override fun getItemViewType(position: Int): Int {
        return if (recipeList?.get(position)?.type == "LOADING") TYPE_LOADING else TYPE_RECIPE
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    fun getItem(position: Int): Recipe? {
        return if (position != RecyclerView.NO_POSITION)
            recipeList?.get(position)
        else
            null
    }

    override fun getItemCount(): Int {
        return recipeList?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        when (getItemViewType(position)) {
            TYPE_RECIPE -> (holder as RecipeViewHolder).onBind(recipeList?.get(position))
            TYPE_LOADING -> (holder as LoadingMoreViewHolder).onBind()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
        when (viewType) {
            TYPE_RECIPE ->
                return RecipeViewHolder(
                    LayoutInflater.from(parent?.context).inflate(
                        R.layout.recipe_list_item,
                        parent,
                        false
                    )
                )
            TYPE_LOADING ->
                return LoadingMoreViewHolder(
                    LayoutInflater.from(parent?.context).inflate(
                        R.layout.recipes_list_view_footer,
                        parent,
                        false
                    )
                )
        }
        return null
    }

    class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(recipe: Recipe?) {
            GlideApp
                .with(itemView.context)
                .load(recipe?.imageUrl)
                .transition(withCrossFade())
                .centerCrop()
                .into(itemView.recipe_image)
            itemView.recipe_title.text = recipe?.title
        }
    }


    class LoadingMoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind() {
            //val layoutParams: StaggeredGridLayoutManager.LayoutParams = StaggeredGridLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            //layoutParams.isFullSpan = true
            //itemView.layoutParams = layoutParams
        }
    }


}