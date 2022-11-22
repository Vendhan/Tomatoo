package com.vendhan.tomatoo.di

import com.vendhan.tomatoo.repo.HomePageRepo
import com.vendhan.tomatoo.repo.HomePageRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    abstract fun provideHomePageRepoImpl(repository: HomePageRepoImpl): HomePageRepo
}
