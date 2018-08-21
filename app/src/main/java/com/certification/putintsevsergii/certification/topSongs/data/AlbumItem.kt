package com.certification.putintsevsergii.certification.topSongs.data

data class AlbumItem(
        val id: String,
        val artistName: String,
        val name: String,
        val releaseDate: String,
        val copyright: String,
        val artistId: String,
        val imageUrl: String = "",
        val isFavouriteItem: Boolean = false,
        val audioUrl: String = "https://audio-ssl.itunes.apple.com/apple-assets-us-std-000001/AudioPreview125/v4/91/85/0f/91850f1d-85b8-1aa0-6eea-e5988b0eb194/mzaf_6254647395340771291.plus.aac.p.m4a"
)