package com.certification.putintsevsergii.certification

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.certification.putintsevsergii.certification.extensions.asyncAwait
import com.certification.putintsevsergii.certification.extensions.launchOnUI
import com.certification.putintsevsergii.certification.topSongs.data.AlbumItem

class TopChartsViewModel(private val topChartsRepository: TopChartsRepository): ViewModel() {

    var networkOperationProgress: MutableLiveData<Boolean> = MutableLiveData()
    val albums: MutableLiveData<List<AlbumItem?>> = MutableLiveData()

    init {
        loadTopCharts()
    }

    fun loadTopCharts() {
        launchOnUI {
            networkOperationProgress.postValue(true)
            try {
                val result = asyncAwait{
                    topChartsRepository.fetchTopSongCarts(10)// todo get from SP
                }
                albums.postValue(result)
                networkOperationProgress.postValue(false)
            } catch (e: Exception) {
                networkOperationProgress.postValue(false)

            }


        }
    }

}