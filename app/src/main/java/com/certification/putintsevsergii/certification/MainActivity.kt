package com.certification.putintsevsergii.certification

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.certification.putintsevsergii.certification.extensions.addFragment
import com.certification.putintsevsergii.certification.extensions.observe
import com.certification.putintsevsergii.certification.extensions.replaceFragment
import com.certification.putintsevsergii.certification.extensions.withViewModel
import com.certification.putintsevsergii.certification.songsDetails.DetailsFragment
import com.certification.putintsevsergii.certification.topSongs.TopSongsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity(), TopSongNavigationInterface {
    override fun onSongDetails() {
        replaceFragment(DetailsFragment(), R.id.fragmentHolder, true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        withViewModel<TopChartsViewModel> {
            observe(networkOperationProgress, ::changeLoadingStatus)
        }

        replaceFragment(TopSongsFragment(), R.id.fragmentHolder )
    }

    private fun changeLoadingStatus(status: Boolean?) {
        status?.let {
            loadingStatusBar.visibility = if (it) View.VISIBLE else View.INVISIBLE
        }
    }

    private fun isNetworkConnected(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

}