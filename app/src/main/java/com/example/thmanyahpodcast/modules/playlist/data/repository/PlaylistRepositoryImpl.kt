package com.example.thmanyahpodcast.modules.playlist.data.repository

import com.example.thmanyahpodcast.modules.playlist.data.mapper.toEntity
import com.example.thmanyahpodcast.modules.playlist.data.source.remote.PlaylistRemoteDs
import com.example.thmanyahpodcast.modules.playlist.domain.entity.PlaylistEntity
import com.example.thmanyahpodcast.modules.playlist.domain.repository.PlaylistRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PlaylistRepositoryImpl @Inject constructor(
    private val playlistRemoteDs: PlaylistRemoteDs,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : PlaylistRepository {
    override suspend fun getPlaylist(): PlaylistEntity {
        return withContext(ioDispatcher) {
            playlistRemoteDs.getPlaylist().toEntity()
        }
    }
}