package com.vicky7230.cayennekt.di.module

import dagger.Module
import com.vicky7230.cayennekt.ui.home.HomeActivity
import com.vicky7230.cayennekt.ui.home.FragmentProvider
import com.vicky7230.cayennekt.ui.home.HomeActivityModule
import dagger.android.ContributesAndroidInjector


/**
 * Created by vicky on 1/1/18.
 */
@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [(HomeActivityModule::class), (FragmentProvider::class)])
    abstract fun bindHomeActivity(): HomeActivity
}