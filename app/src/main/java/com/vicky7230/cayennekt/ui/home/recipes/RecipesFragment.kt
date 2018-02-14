package com.vicky7230.cayennekt.ui.home.recipes

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vicky7230.cayennekt.R
import com.vicky7230.cayennekt.data.network.model.Recipe
import com.vicky7230.cayennekt.ui.base.BaseFragment
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_recipes.*
import javax.inject.Inject

class RecipesFragment : BaseFragment(), RecipesMvpView {
    @Inject
    lateinit var presenter: RecipesMvpPresenter<RecipesMvpView>

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager
    @Inject
    lateinit var itemOffsetDecoration: ItemOffsetDecoration
    @Inject
    lateinit var recipesAdapter: RecipesAdapter

    var isLoading = false

    companion object {

        fun newInstance() = RecipesFragment()
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recipes, container, false)
        presenter.onAttach(this)
        return view
    }

    override fun setUp(view: View) {
        recipeList.layoutManager = linearLayoutManager
        recipeList.addItemDecoration(itemOffsetDecoration)
        recipeList.adapter = recipesAdapter

        recipeList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val visibleItemCount = linearLayoutManager.childCount
                val totalItemCount = linearLayoutManager.itemCount
                val pastVisibleItems = linearLayoutManager.findFirstVisibleItemPosition()

                if (visibleItemCount + pastVisibleItems >= totalItemCount && !isLoading) {
                    recipesAdapter.addItem(Recipe(type = "LOADING"))
                    presenter.getRecipes()
                    isLoading = true
                }
            }
        })

        showLoading()
        presenter.getRecipes()
    }

    override fun updateRecipeList(recipes: MutableList<Recipe>) {
        if (recipesAdapter.itemCount > 0)
            recipesAdapter.removeItem()
        recipesAdapter.addItems(recipes)
        isLoading = false
    }

    override fun onDestroyView() {
        presenter.onDetach()
        super.onDestroyView()
    }
}
