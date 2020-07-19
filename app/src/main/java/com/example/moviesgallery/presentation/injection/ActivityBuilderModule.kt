package com.example.moviesgallery.presentation.injection

import com.example.moviesgallery.presentation.view.home.HomeActivity
import com.example.moviesgallery.presentation.view.home.HomeViewModelModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [HomeViewModelModule::class])
    internal abstract fun bindsHomeActivity(): HomeActivity
}