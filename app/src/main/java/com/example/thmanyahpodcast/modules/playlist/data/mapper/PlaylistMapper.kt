package com.example.thmanyahpodcast.modules.playlist.data.mapper

import com.example.thmanyahpodcast.core.data.model.PlaylistResponse
import com.example.thmanyahpodcast.modules.playlist.domain.entity.EpisodeEntity
import com.example.thmanyahpodcast.modules.playlist.domain.entity.PlaylistEntity

fun PlaylistResponse.toEntity() = PlaylistEntity(
    id = data.playlist.id,
    name = data.playlist.name,
    description = data.playlist.description,
    image = data.playlist.image,
    episodeCount = data.playlist.episodeCount,
    episodeTotalDuration = data.playlist.episodeTotalDuration,
    episodes = data.episodes.map {
        EpisodeEntity(
            id = it.id,
            name = it.name,
            image = it.image,
            audioLink = it.audioLink,
            duration = it.duration,
            podcastName = it.podcastName,
            releaseDate = it.releaseDate
        )
    }
)