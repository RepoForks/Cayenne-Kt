package com.vicky7230.cayennekt.di.module

import android.app.Application
import android.content.Context
import com.vicky7230.cayennekt.CayenneApplication
import com.vicky7230.cayennekt.data.AppDataManager
import com.vicky7230.cayennekt.data.Config
import com.vicky7230.cayennekt.data.DataManager
import com.vicky7230.cayennekt.data.network.ApiHelper
import com.vicky7230.cayennekt.data.network.AppApiHelper
import com.vicky7230.cayennekt.di.ApplicationContext
import com.vicky7230.cayennekt.di.BaseUrl
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * Created by vicky on 31/12/17.
 */
@Module
class ApplicationModule {

    @Provides
    @ApplicationContext
    internal fun provideContext(cayenneApplication: CayenneApplication): Context {
        return cayenneApplication.applicationContext
    }

    @Provides
    internal fun provideApplication(cayenneApplication: CayenneApplication): Application {
        return cayenneApplication
    }

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    /*@Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, Config.DB_NAME).build()
    }*/

    @Provides
    @BaseUrl
    internal fun provideBaseUrl(): String {
        return Config.BASE_URL
    }

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    /*@Provides
    @Singleton
    internal fun provideDbHelper(appDbHelper: AppDbHelper): DbHelper {
        return appDbHelper
    }*/

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper {
        return appApiHelper
    }
}