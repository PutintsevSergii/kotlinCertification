package com.certification.putintsevsergii.certification

import android.arch.lifecycle.*
import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import com.certification.putintsevsergii.certification.extensions.asyncAwait
import com.certification.putintsevsergii.certification.extensions.launchOnUI
import com.certification.putintsevsergii.certification.topSongs.data.AlbumItem

class TopChartsViewModel(private val topChartsRepository: TopChartsRepository): ViewModel(), LifecycleObserver {

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

    fun loadTopCharts() {
        launchOnUI {
            networkOperationProgress.postValue(true)
            albums.value = try { asyncAwait {topChartsRepository.fetchTopSongCarts(10) }}
            catch (error: Throwable ) { asyncAwait { topChartsRepository.getOfflineAlbums() } }
            networkOperationProgress.postValue(false)
        }
    }


    //might look like anti pattern
    private var mediaPlayer: MediaPlayer? = null
    private var isInitialPlayState = true

    fun resetPlayState() {
        isInitialPlayState = true
    }

    fun addObserver(lifecycleOwner: LifecycleOwner?){
        lifecycleOwner?.lifecycle?.addObserver(this)
    }

    fun startMusic(context: Context?) {
        isInitialPlayState = false
        mediaPlayer?.let {
            if (it.isPlaying) {
                it.pause()
            } else {
                it.start()
            }
        } ?: run {
            mediaPlayer = MediaPlayer.create(context, Uri.parse(currentlySelectedAlbum.value?.audioUrl))
            mediaPlayer?.start()
        }

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(){
        mediaPlayer?.let {
            if (it.isPlaying) {
                 it.stop()
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun pauseMusic() {
        mediaPlayer?.pause()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resumeMusic() {
        if (!isInitialPlayState) mediaPlayer?.start()

    }

}