package com.example.thmanyahpodcast.modules.playlist.domain.repository

import com.example.thmanyahpodcast.modules.playlist.domain.entity.PlaylistEntity

interface PlaylistRepository {
    suspend fun getPlaylist(): PlaylistEntity
}