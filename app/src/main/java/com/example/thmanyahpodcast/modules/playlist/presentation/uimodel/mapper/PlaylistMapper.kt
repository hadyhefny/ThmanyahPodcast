package com.example.thmanyahpodcast.modules.playlist.presentation.uimodel.mapper

import android.app.Application
import com.example.thmanyahpodcast.R
import com.example.thmanyahpodcast.modules.playlist.domain.entity.EpisodeEntity
import com.example.thmanyahpodcast.modules.playlist.presentation.uimodel.EpisodeUiModel
import com.example.thmanyahpodcast.modules.playlist.presentation.uimodel.PlaylistUiModel
import com.example.thmanyahpodcast.modules.playlist.presentation.uimodel.PlaylistUiState

fun PlaylistUiState.toUiModel(context: Application) = PlaylistUiModel(
    isLoading = isLoading,
    name = playlistEntity?.name ?: "",
    description = playlistEntity?.description ?: "",
    image = playlistEntity?.image ?: "",
    episodeCount = context.getString(
        R.string.episode_count,
        playlistEntity?.episodeCount.toString()
    ),
    episodeTotalDuration = context.getString(
        R.string.episode_duration,
        playlistEntity?.episodeTotalDuration?.getEpisodeDurationInHour().toString()
    ),
    episodes = playlistEntity?.episodes?.map { episode ->
        episode.toUiModel()
    } ?: emptyList()
)

fun EpisodeEntity.toUiModel() =
    EpisodeUiModel(
        id = id,
        name = name,
        image = image,
        audioLink = audioLink,
        duration = duration.getEpisodeDurationInHour().toString(),
        podcastName = podcastName,
        releaseDate = releaseDate
    )

private fun Long.getEpisodeDurationInHour(): Float {
    return this / (60 * 60f)
}