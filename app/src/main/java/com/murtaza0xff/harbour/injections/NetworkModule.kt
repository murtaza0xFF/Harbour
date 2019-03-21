package com.murtaza0xff.harbour.injections

import com.murtaza0xff.harbour.algolia.AlgoliaService
import com.murtaza0xff.harbour.algolia.remote.AlgoliaApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
abstract class NetworkModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        @Singleton
        fun providesOkHttp(): OkHttpClient {
            return OkHttpClient()
                .newBuilder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()
        }

        @JvmStatic
        @Provides
        @Singleton
        @Named("algolia")
        fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://hn.algolia.com/api/v1/")
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
        }

        @JvmStatic
        @Provides
        @Singleton
        fun providesAlgoliaService(@Named("algolia") retrofit: Retrofit): AlgoliaService {
            return AlgoliaService(retrofit.create(AlgoliaApi::class.java))
        }
    }
}