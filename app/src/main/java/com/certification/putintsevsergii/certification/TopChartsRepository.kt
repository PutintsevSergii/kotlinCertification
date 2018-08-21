package com.certification.putintsevsergii.certification

import com.certification.putintsevsergii.certification.database.AppDatabase
import com.certification.putintsevsergii.certification.database.entities.AlbumItemData
import com.certification.putintsevsergii.certification.networking.NetworkManager
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

    fun getOfflineAlbums(): List<AlbumItem> {
        val result = database?.albumsDao()?.all
        result?.let {
            return it.map { it.toAlbumItem() }
        }
        return ArrayList()
    }

    fun updateItem(item: AlbumItem) {
        val dataItem = AlbumItemData(item)
        database?.albumsDao()?.update(dataItem)
    }

    private fun saveData(items: List<AlbumItem>) {
        database?.albumsDao()?.insert(items.map { AlbumItemData(it) })
    }
}