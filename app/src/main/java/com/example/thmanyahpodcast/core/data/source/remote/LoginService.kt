package com.example.thmanyahpodcast.core.data.source.remote

import com.example.thmanyahpodcast.core.data.model.LoginResponse
import com.example.thmanyahpodcast.core.data.model.request.LoginRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("auth/login")
    suspend fun login(
        @Body loginBody: LoginRequest = LoginRequest()
    ): LoginResponse
}