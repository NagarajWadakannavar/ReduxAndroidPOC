package com.example.reductorpoc.di.module

import com.example.reductorpoc.redux.reducers.CounterReducer
import com.example.reductorpoc.redux.states.Counter
import com.yheriatovych.reductor.Store
import com.yheriatovych.reductor.Store.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Nagaraj on 29-04-2021.
 */
@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Singleton
    @Provides
    fun provideStore(): Store<Counter> = create<Counter>(CounterReducer.create())
}