package com.example.thmanyahpodcast.core.data.model

import com.google.gson.annotations.SerializedName

data class EpisodesItem(

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("audioLink")
	val audioLink: String,

	@field:SerializedName("durationInSeconds")
	val durationInSeconds: Long,

	@field:SerializedName("releaseDate")
	val releaseDate: String,

	@field:SerializedName("chapters")
	val chapters: List<Any>,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("imageBigger")
	val imageBigger: String,

	@field:SerializedName("sentNotification")
	val sentNotification: Boolean,

	@field:SerializedName("type")
	val type: Int,

	@field:SerializedName("podcastItunesId")
	val podcastItunesId: String,

	@field:SerializedName("duration")
	val duration: Long,

	@field:SerializedName("createdAt")
	val createdAt: String,

	@field:SerializedName("isDeleted")
	val isDeleted: Boolean,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("podcastName")
	val podcastName: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("position")
	val position: Int,

	@field:SerializedName("isEditorPick")
	val isEditorPick: Boolean,

	@field:SerializedName("views")
	val views: Int,

	@field:SerializedName("itunesId")
	val itunesId: String,

	@field:SerializedName("updatedAt")
	val updatedAt: String
)