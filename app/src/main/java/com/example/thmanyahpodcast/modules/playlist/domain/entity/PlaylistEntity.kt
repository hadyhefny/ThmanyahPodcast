package com.example.thmanyahpodcast.modules.playlist.domain.entity

data class PlaylistEntity(
    val id: String,
    val name: String,
    val description: String,
    val image: String,
    val episodeCount: Int,
    val episodeTotalDuration: Long,
    val episodes: List<EpisodeEntity>
)

data class EpisodeEntity(
    val id: String,
    val name: String,
    val image: String,
    val audioLink: String,
    val duration: Long,
    val podcastName: String,
    val releaseDate: String
)
