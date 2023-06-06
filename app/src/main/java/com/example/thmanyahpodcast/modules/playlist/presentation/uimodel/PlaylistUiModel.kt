package com.example.thmanyahpodcast.modules.playlist.presentation.uimodel

data class PlaylistUiModel(
    val isLoading: Boolean,
    val name: String,
    val description: String,
    val image: String,
    val episodeCountDuration: String,
    val episodes: List<EpisodeUiModel>,
    val error: String?
)

data class EpisodeUiModel(
    val id: String,
    val name: String,
    val image: String,
    val audioLink: String,
    val podcastName: String,
    val episodeDateAndTime: String
)