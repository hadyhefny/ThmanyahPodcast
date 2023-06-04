package com.example.thmanyahpodcast.core.data.model

import com.google.gson.annotations.SerializedName

data class PlaylistResponse(

	@field:SerializedName("data")
	val data: Data
)