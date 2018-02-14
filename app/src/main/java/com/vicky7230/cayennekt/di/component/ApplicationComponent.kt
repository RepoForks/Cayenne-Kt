package com.vicky7230.cayennekt.di.component

import com.vicky7230.cayennekt.CayenneApplication
import com.vicky7230.cayennekt.di.module.ActivityBindingModule
import dagger.BindsInstance
import com.vicky7230.cayennekt.di.module.ApplicationModule
import com.vicky7230.cayennekt.di.module.NetworkModule
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


/**
 * Created by vicky on 12/2/18.
 */
@Singleton
@Component(
    modules =
    [
        AndroidSupportInjectionModule::class,
        NetworkModule::class,
        ApplicationModule::class,
        ActivityBindingModule::class
    ]
)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(cayenneApplication: CayenneApplication): Builder

        fun build(): ApplicationComponent
    }

    fun inject(cayenneApplication: CayenneApplication)

}