package com.example.thmanyahpodcast.modules.playlist.domain.interactor

import com.example.thmanyahpodcast.modules.playlist.domain.entity.PlaylistEntity
import com.example.thmanyahpodcast.modules.playlist.domain.repository.PlaylistRepository
import javax.inject.Inject

class GetPlaylistUseCase @Inject constructor(private val repository: PlaylistRepository) {
    suspend operator fun invoke(): PlaylistEntity {
        return repository.getPlaylist()
    }
}