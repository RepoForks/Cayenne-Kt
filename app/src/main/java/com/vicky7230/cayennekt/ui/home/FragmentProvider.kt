package com.vicky7230.cayennekt.ui.home

import dagger.Module
import com.vicky7230.cayennekt.ui.home.recipes.RecipesFragment
import com.vicky7230.cayennekt.ui.home.recipes.RecipesModule
import dagger.android.ContributesAndroidInjector


/**
 * Created by vicky on 11/2/18.
 */
@Module
abstract class FragmentProvider {
    @ContributesAndroidInjector(modules = [(RecipesModule::class)])
    internal abstract fun provideRecipesFragmentFactory(): RecipesFragment
}