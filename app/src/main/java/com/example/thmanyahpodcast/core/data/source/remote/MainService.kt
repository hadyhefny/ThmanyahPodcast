package com.example.thmanyahpodcast.core.data.source.remote

import com.example.thmanyahpodcast.core.data.model.LoginResponse
import com.example.thmanyahpodcast.core.data.model.PlaylistResponse
import com.example.thmanyahpodcast.core.data.model.request.LoginRequest
import retrofit2.http.Body
import retrofit2.http.GET

interface MainService {
    @GET("auth/login")
    suspend fun login(
        @Body loginBody: LoginRequest = LoginRequest()
    ): LoginResponse

    @GET("playlist/01GVD0TTY5RRMHH6YMCW7N1H70")
    suspend fun getPlaylist(): PlaylistResponse
}