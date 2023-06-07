package com.example.thmanyahpodcast.modules.playlist.presentation.uimodel.mapper

import android.app.Application
import com.example.thmanyahpodcast.R
import com.example.thmanyahpodcast.modules.playlist.domain.entity.EpisodeEntity
import com.example.thmanyahpodcast.modules.playlist.presentation.uimodel.EpisodeUiModel
import com.example.thmanyahpodcast.modules.playlist.presentation.uimodel.PlaylistUiModel
import com.example.thmanyahpodcast.modules.playlist.presentation.uimodel.PlaylistUiState
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

fun PlaylistUiState.toUiModel(context: Application) = PlaylistUiModel(
    isLoading = isLoading,
    name = playlistEntity?.name ?: "",
    description = playlistEntity?.description ?: "",
    image = playlistEntity?.image ?: "",
    episodeCountDuration = context.getString(
        R.string.episode_count_duration,
        playlistEntity?.episodeCount.toString(),
        playlistEntity?.episodeTotalDuration?.getEpisodeDurationInHour().toString()
    ),
    episodes = playlistEntity?.episodes?.map { episode ->
        episode.toUiModel(context)
    } ?: emptyList(),
    error = error?.let { context.getString(it) }
)

fun EpisodeEntity.toUiModel(context: Application) =
    EpisodeUiModel(
        id = id,
        name = name,
        image = image,
        audioLink = audioLink,
        podcastName = podcastName,
        episodeDateAndTime = context.getString(
            R.string.episode_date_time,
            releaseDate.getFormattedDate(),
            duration.getEpisodeDurationInHour().toString()
        )
    )

private fun Long.getEpisodeDurationInHour(): Long {
    return this / (60 * 60)
}

private fun String.getFormattedDate(): String {
    if (this.isBlank()) return ""
    val sdf = SimpleDateFormat("yyyy-MM-dd")
    sdf.timeZone = TimeZone.getTimeZone("UTC")
    val date = sdf.parse(this)
    val formatterMonth = SimpleDateFormat("MMMM", Locale("ar"))
    val formatterYear = SimpleDateFormat("yyyy", Locale("en"))
    return formatterMonth.format(date) + " " + formatterYear.format(date)
}