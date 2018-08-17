package com.certification.putintsevsergii.certification

import com.certification.putintsevsergii.certification.networking.NetworkManager
import com.certification.putintsevsergii.certification.networking.Networking
import com.certification.putintsevsergii.certification.topSongs.data.AlbumItem

class TopChartsRepository(private val networkManager: NetworkManager) {

    fun fetchTopSongCarts(count: Int): List<AlbumItem>? {
        val response = networkManager.getTopSongCharts(count).execute().body()
        return response?.feed?.results?.map {it.toAlbumItem()}
    }
}