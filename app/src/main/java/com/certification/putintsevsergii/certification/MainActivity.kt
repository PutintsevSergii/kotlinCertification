package com.certification.putintsevsergii.certification

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.certification.putintsevsergii.certification.extensions.addFragment
import com.certification.putintsevsergii.certification.extensions.observe
import com.certification.putintsevsergii.certification.extensions.replaceFragment
import com.certification.putintsevsergii.certification.extensions.withViewModel
import com.certification.putintsevsergii.certification.topSongs.TopSongsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity() {

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

}