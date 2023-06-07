package com.example.thmanyahpodcast.core.data.model

import com.google.gson.annotations.SerializedName

data class Data(

	@field:SerializedName("playlist")
	val playlist: Playlist,

	@field:SerializedName("episodes")
	val episodes: List<EpisodesItem>
)