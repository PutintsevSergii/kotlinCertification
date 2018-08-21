package com.certification.putintsevsergii.certification.songsDetails

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.certification.putintsevsergii.certification.R
import com.certification.putintsevsergii.certification.TopChartsViewModel
import com.certification.putintsevsergii.certification.extensions.observe
import com.certification.putintsevsergii.certification.extensions.withViewModel
import com.certification.putintsevsergii.certification.songsDetails.media.MusicObserver
import com.certification.putintsevsergii.certification.topSongs.data.AlbumItem
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        playSongBtn.setOnClickListener {
            //done really simple to show how it works in real world
            lifecycle.addObserver(MusicObserver(activity))
        }

        activity?.withViewModel<TopChartsViewModel> {
            observe(currentlySelectedAlbum, ::onSelectedItemUpdated)
        }
    }

    private fun onSelectedItemUpdated(item: AlbumItem?) {
        nameTV.text = item?.name
        releaseDateTv.text = item?.releaseDate
        copyrightTv.text = item?.copyright
    }

}