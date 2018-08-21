package com.certification.putintsevsergii.certification.songsDetails.media


import android.content.Context
import android.media.MediaPlayer
import android.net.Uri

class MusicManager(context: Context?) {

    private var mediaPlayer: MediaPlayer = MediaPlayer.create(context, Uri.parse("https://audio-ssl.itunes.apple.com/apple-assets-us-std-000001/AudioPreview125/v4/91/85/0f/91850f1d-85b8-1aa0-6eea-e5988b0eb194/mzaf_6254647395340771291.plus.aac.p.m4a"))

    fun start() {
        mediaPlayer.start()
    }

    fun pause() {
        mediaPlayer.pause()
    }

    fun stop() {
        mediaPlayer.stop()
        mediaPlayer.release()
    }
}