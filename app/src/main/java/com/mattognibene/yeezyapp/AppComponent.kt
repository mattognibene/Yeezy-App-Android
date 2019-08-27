package com.mattognibene.yeezyapp

import android.app.Application
import com.mattognibene.yeezyapp.data.injection.DataModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    BuildTypeModule::class,
    DataModule::class,
    AppBindings::class,
    ViewModelBindings::class
])
interface AppComponent : AndroidInjector<YeezyApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance fun app(app: Application): Builder
        fun build(): AppComponent
    }
}