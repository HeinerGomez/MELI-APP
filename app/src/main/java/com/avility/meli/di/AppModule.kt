package com.avility.meli.di

import com.avility.data.remote.MeliAPI
import com.avility.data.repository.ProductRepositoryImpl
import com.avility.data.repository.SellerRepositoryImpl
import com.avility.domain.repository.ProductRepository
import com.avility.domain.repository.SellerRepository
import com.avility.shared.core.constants.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

/**
 * Module of application to inject the necessary dependencies
 *
 * @author Heiner Gómez
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            ).build()
    }

    @Provides
    @Singleton
    fun provideMELIAPI(client: OkHttpClient): MeliAPI {
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL_API_MELI)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideProductRepository(api: MeliAPI): ProductRepository {
        return ProductRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideSellerRepository(api: MeliAPI): SellerRepository {
        return SellerRepositoryImpl(api)
    }
}