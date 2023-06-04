package com.example.thmanyahpodcast.core.data.source.remote

import com.example.thmanyahpodcast.core.data.source.local.AuthorizationLocalDs
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val authorizationLocalDs: AuthorizationLocalDs,
    private val loginService: LoginService
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return runBlocking {
            val request = chain.request().newBuilder()
            var accessToken = authorizationLocalDs.getAccessToken()
            if (accessToken.isNullOrBlank()) {
                accessToken = try {
                    loginService.login().accessToken
                } catch (e: Exception) {
                    ""
                }
                authorizationLocalDs.saveAccessToken(accessToken ?: "")
            }
            request.addHeader("Authorization", "Bearer $accessToken")
            chain.proceed(request.build())
        }
    }
}