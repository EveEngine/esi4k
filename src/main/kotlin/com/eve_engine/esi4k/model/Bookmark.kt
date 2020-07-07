package com.eve_engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Bookmark(
    @JsonProperty("bookmark_id") val bookmarkId: Int,
    @JsonProperty("item") val item: Item? = null,
    @JsonProperty("notes") val notes: String ,
    @JsonProperty("created") val created: String,
    @JsonProperty("coordinates") val coordinates: Position? = null,
    @JsonProperty("creator_id") val creatorId: Int,
    @JsonProperty("label") val label: String,
    @JsonProperty("folder_id") val folderId: Int? = null,
    @JsonProperty("location_id") val locationId: Int
)

data class BookmarkFolder(
    @JsonProperty("folder_id") val folderId: Int,
    @JsonProperty("name") val name: String
)

