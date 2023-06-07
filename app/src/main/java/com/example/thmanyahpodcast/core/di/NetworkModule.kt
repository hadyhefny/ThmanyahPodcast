package com.example.thmanyahpodcast.core.di

import android.content.SharedPreferences
import com.example.thmanyahpodcast.BuildConfig
import com.example.thmanyahpodcast.core.data.source.local.AuthorizationLocalDs
import com.example.thmanyahpodcast.core.data.source.remote.AuthInterceptor
import com.example.thmanyahpodcast.core.data.source.remote.LoginService
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
import javax.inject.Named
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
    fun provideAuthInterceptor(authorizationLocalDs: AuthorizationLocalDs, loginService: LoginService): Interceptor {
        return AuthInterceptor(authorizationLocalDs, loginService)
    }

    @Singleton
    @Provides
    fun provideTokenAuthenticator(
        authorizationLocalDs: AuthorizationLocalDs,
        loginService: LoginService
    ): Authenticator {
        return TokenAuthenticator(authorizationLocalDs, loginService)
    }

    @Named("main")
    @Singleton
    @Provides
    fun provideMainOkHttpClient(
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

    @Named("login")
    @Singleton
    @Provides
    fun provideLoginOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(loggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideGsonConverter(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Named("main")
    @Singleton
    @Provides
    fun provideRetrofit(
        @Named("main") okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
    }


    @Named("login")
    @Singleton
    @Provides
    fun provideLoginRetrofit(
        @Named("login") okHttpClient: OkHttpClient,
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
    fun provideMainService( @Named("main") retrofit: Retrofit): MainService {
        return retrofit.create(MainService::class.java)
    }

    @Singleton
    @Provides
    fun provideLoginService(@Named("login") retrofit: Retrofit): LoginService {
        return retrofit.create(LoginService::class.java)
    }

    @Singleton
    @Provides
    fun provideAuthorizationLocalDs(sharedPreferences: SharedPreferences): AuthorizationLocalDs {
        return AuthorizationLocalDs(sharedPreferences)
    }

}