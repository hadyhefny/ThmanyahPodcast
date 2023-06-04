package com.example.thmanyahpodcast.core.di

import android.content.SharedPreferences
import com.example.thmanyahpodcast.BuildConfig
import com.example.thmanyahpodcast.core.data.source.local.AuthorizationLocalDs
import com.example.thmanyahpodcast.core.data.source.remote.AuthInterceptor
import com.example.thmanyahpodcast.core.data.source.remote.MainService
import com.example.thmanyahpodcast.core.data.source.remote.TokenAuthenticator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Authenticator
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {
    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.HEADERS
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    @Singleton
    @Provides
    fun provideAuthInterceptor(authorizationLocalDs: AuthorizationLocalDs): Interceptor {
        return AuthInterceptor(authorizationLocalDs)
    }

    @Singleton
    @Provides
    fun provideTokenAuthenticator(
        authorizationLocalDs: AuthorizationLocalDs,
        mainService: MainService
    ): Authenticator {
        return TokenAuthenticator(authorizationLocalDs, mainService)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        authInterceptor: AuthInterceptor,
        tokenAuthenticator: TokenAuthenticator
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(loggingInterceptor)
            .addInterceptor(authInterceptor)
            .authenticator(tokenAuthenticator)
            .build()
    }

    @Singleton
    @Provides
    fun provideGsonConverter(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideThmanyahService(retrofit: Retrofit): MainService {
        return retrofit.create(MainService::class.java)
    }

    @Singleton
    @Provides
    fun provideAuthorizationLocalDs(sharedPreferences: SharedPreferences): AuthorizationLocalDs {
        return AuthorizationLocalDs(sharedPreferences)
    }

}