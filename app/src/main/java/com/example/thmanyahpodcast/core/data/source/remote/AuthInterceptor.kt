package com.example.thmanyahpodcast.core.data.source.remote

import com.example.thmanyahpodcast.core.data.source.local.AuthorizationLocalDs
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val authorizationLocalDs: AuthorizationLocalDs,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token: String? = runBlocking {
            authorizationLocalDs.getAccessToken()
        }
        val request = chain.request().newBuilder()
        request.addHeader("Authorization", "Bearer $token")
        return chain.proceed(request.build())
    }
}