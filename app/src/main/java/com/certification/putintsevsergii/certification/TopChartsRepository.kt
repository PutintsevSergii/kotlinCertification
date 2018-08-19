package com.certification.putintsevsergii.certification

import com.certification.putintsevsergii.certification.database.AppDatabase
import com.certification.putintsevsergii.certification.database.Database
import com.certification.putintsevsergii.certification.extensions.asyncAwait
import com.certification.putintsevsergii.certification.extensions.launchOnUI
import com.certification.putintsevsergii.certification.networking.NetworkManager
import com.certification.putintsevsergii.certification.networking.Networking
import com.certification.putintsevsergii.certification.topSongs.data.AlbumItem

class TopChartsRepository(private val networkManager: NetworkManager, private val database: AppDatabase?) {

    fun fetchTopSongCarts(count: Int): List<AlbumItem>? {
        val response = networkManager.getTopSongCharts(count).execute().body()
        val albumItems = response?.feed?.results?.map {it.toAlbumItem()}
        albumItems?.let {
            saveData(it)
        }
        return albumItems
    }

    private fun saveData(items: List<AlbumItem>) {

        launchOnUI {
            asyncAwait {
                // val b = a //todo save data here
            }

        }
    }
}