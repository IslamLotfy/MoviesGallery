package com.example.moviesgallery.presentation.injection

import android.app.Application
import com.example.moviesgallery.data.injection.RepositoryModule
import com.example.moviesgallery.data.injection.RetrofitModule
import com.example.moviesgallery.domain.UseCasesModule
import com.example.moviesgallery.presentation.MoviesGallery
import com.we.movieapp.ui.di.ViewModelFactory
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ViewModelFactory::class,
        ActivityBuilderModule::class,
        RetrofitModule::class,
        RepositoryModule::class,
        UseCasesModule::class,
        AppModule::class
    ]
)
interface AppComponent : AndroidInjector<MoviesGallery> {


    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}