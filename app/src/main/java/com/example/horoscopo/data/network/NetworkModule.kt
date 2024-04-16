package com.example.horoscopo.data.network

import com.example.horoscopo.BuildConfig.BASE_URL
import com.example.horoscopo.core.data.AuthInterceptor
import com.example.horoscopo.data.HoroscopeRepositoryImpl
import com.example.horoscopo.domain.HoroscopeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit{
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideInterceptor(authInterceptor: AuthInterceptor):OkHttpClient{
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .addInterceptor(authInterceptor)
            .build()
    }

    @Provides
    fun provideHoroscopeApiService(retrofit: Retrofit):HoroscopeApiService{
        return retrofit.create(HoroscopeApiService::class.java)
    }

    @Provides
    fun provideHoroscopeRepository(apiService: HoroscopeApiService):HoroscopeRepository{
        return HoroscopeRepositoryImpl(apiService)
    }

}