package com.certification.putintsevsergii.certification.networking.data

import com.certification.putintsevsergii.certification.topSongs.data.AlbumItem
import com.squareup.moshi.Json

data class Result(
        @Json(name = "id") val id: String,
        @Json(name = "artistName") val artistName: String,
        @Json(name = "name") val name: String,
        @Json(name = "releaseDate") val releaseDate: String,
        @Json(name = "copyright") val copyright: String,
        @Json(name = "artistId") val artistId: String,
        @Json(name = "artworkUrl100") val artworkUrl100: String
) {
    fun toAlbumItem() = AlbumItem(id, artistName, name, releaseDate, copyright, artistId, artworkUrl100)
}