package com.certification.putintsevsergii.certification

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.certification.putintsevsergii.certification.extensions.asyncAwait
import com.certification.putintsevsergii.certification.extensions.launchOnUI
import com.certification.putintsevsergii.certification.topSongs.data.AlbumItem

class TopChartsViewModel(private val topChartsRepository: TopChartsRepository): ViewModel() {

    val networkOperationProgress: MutableLiveData<Boolean> = MutableLiveData()
    val albums: MutableLiveData<List<AlbumItem>> = MutableLiveData()

    val currentlySelectedAlbum: MutableLiveData<AlbumItem> = MutableLiveData()

    init {
        loadTopCharts()
    }

    fun changeItemSelection(item: AlbumItem) {
//        launchOnUI {
//            asyncAwait {
//                topChartsRepository.updateItem(item)
//                topChartsRepository.getOfflineAlbums()
//            }
//        }
        currentlySelectedAlbum.value = item
    }

    private fun loadTopCharts() {
        launchOnUI {
            networkOperationProgress.postValue(true)
            albums.value = try { asyncAwait {topChartsRepository.fetchTopSongCarts(10) }}
            catch (error: Throwable ) { asyncAwait { topChartsRepository.getOfflineAlbums() } }
            networkOperationProgress.postValue(false)
        }
    }

}