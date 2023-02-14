package dev.xascar.virginmoneydeveloperchallenge.di

import dev.xascar.virginmoneydeveloperchallenge.data.remote.ApiDetails
import dev.xascar.virginmoneydeveloperchallenge.data.remote.ApiReference
import dev.xascar.virginmoneydeveloperchallenge.data.repository.Repository
import dev.xascar.virginmoneydeveloperchallenge.data.repository.RepositoryImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//Reference: https://developer.android.com/training/dependency-injection/hilt-android
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideGson(): Gson = Gson()

    @Provides
    fun provideHttpInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

    @Provides
    fun provideRetrofit(
        gson: Gson,
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(ApiReference.BASE_RUL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()

    @Provides
    fun provideApiDetails(
        retrofit: Retrofit
    ): ApiDetails = retrofit.create(ApiDetails::class.java)

    @Provides
    fun provideRepository(
        apiDetails: ApiDetails
    ): Repository =
        RepositoryImpl(apiDetails)

}