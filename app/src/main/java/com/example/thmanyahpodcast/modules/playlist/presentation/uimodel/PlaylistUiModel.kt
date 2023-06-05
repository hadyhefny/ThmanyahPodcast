package com.example.thmanyahpodcast.modules.playlist.presentation.uimodel

data class PlaylistUiModel(
    val isLoading: Boolean,
    val name: String,
    val description: String,
    val image: String,
    val episodeCount: String,
    val episodeTotalDuration: String,
    val episodes: List<EpisodeUiModel>
)

data class EpisodeUiModel(
    val id: String,
    val name: String,
    val image: String,
    val audioLink: String,
    val duration: String,
    val podcastName: String,
    val releaseDate: String
)