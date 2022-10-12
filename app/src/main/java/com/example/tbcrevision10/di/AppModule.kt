package com.example.tbcrevision10.di

import com.example.tbcrevision10.data.network.ApiCall
import com.example.tbcrevision10.data.repository.MainRepositoryImpl
import com.example.tbcrevision10.domain.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun retrofitProvider(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://run.mocky.io/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideMessageApi(retrofit: Retrofit): ApiCall {
        return retrofit.create(ApiCall::class.java)
    }

    @Provides
    @Singleton
    fun provideJokesRepository(messageApi: ApiCall): MainRepository {
        return MainRepositoryImpl(messageApi)
    }

}