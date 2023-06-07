package com.example.thmanyahpodcast.modules.playlist.data.source.remote

import com.example.thmanyahpodcast.core.data.source.remote.MainService
import javax.inject.Inject

class PlaylistRemoteDs @Inject constructor(
    private val mainService: MainService
) {
    suspend fun getPlaylist() = mainService.getPlaylist()
}