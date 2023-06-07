package com.example.thmanyahpodcast.core.data.source.remote

import com.example.thmanyahpodcast.core.data.source.local.AuthorizationLocalDs
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class TokenAuthenticator @Inject constructor(
    private val authorizationLocalDs: AuthorizationLocalDs,
    private val loginService: LoginService
) : Authenticator {
    override fun authenticate(route: Route?, response: Response): Request {
        return runBlocking {
            val token = getAccessToken()
            authorizationLocalDs.saveAccessToken(token)
            return@runBlocking response.request.newBuilder()
                .addHeader("Authorization", "Bearer $token")
                .build()
        }
    }

    private suspend fun getAccessToken(): String {
        return try {
            loginService.login().accessToken
        } catch (e: Exception) {
            ""
        }
    }
}