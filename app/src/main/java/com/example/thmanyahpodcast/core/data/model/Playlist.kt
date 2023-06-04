package com.example.thmanyahpodcast.core.data.model

import com.google.gson.annotations.SerializedName

data class Playlist(

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("access")
	val access: String,

	@field:SerializedName("episodeCount")
	val episodeCount: Int,

	@field:SerializedName("episodeTotalDuration")
	val episodeTotalDuration: Long,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("type")
	val type: Int,

	@field:SerializedName("followingCount")
	val followingCount: Int,

	@field:SerializedName("userId")
	val userId: String,

	@field:SerializedName("createdAt")
	val createdAt: String,

	@field:SerializedName("isDeleted")
	val isDeleted: Boolean,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("status")
	val status: String,

	@field:SerializedName("updatedAt")
	val updatedAt: String
)