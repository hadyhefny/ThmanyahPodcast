package com.example.thmanyahpodcast.modules.playlist.presentation.uimodel

import com.example.thmanyahpodcast.modules.playlist.domain.entity.PlaylistEntity

data class PlaylistUiState(
    val isLoading: Boolean = false,
    val playlistEntity: PlaylistEntity? = null
)