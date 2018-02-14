package com.vicky7230.cayennekt.data

import com.vicky7230.cayennekt.data.network.AppApiHelper
import javax.inject.Inject

/**
 * Created by vicky on 31/12/17.
 */
class AppDataManager @Inject
constructor(private val appApiHelper: AppApiHelper) : DataManager {
    override fun getRecipes(key: String, page: String, count: String) =
        appApiHelper.getRecipes(key, page, count)
}