package com.certification.putintsevsergii.certification.topSongs

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.certification.putintsevsergii.certification.R
import com.certification.putintsevsergii.certification.TopChartsViewModel
import com.certification.putintsevsergii.certification.extensions.afterTextChanged
import com.certification.putintsevsergii.certification.extensions.observe
import com.certification.putintsevsergii.certification.extensions.withViewModel
import com.certification.putintsevsergii.certification.topSongs.adapters.AlbumsAdapter
import com.certification.putintsevsergii.certification.topSongs.data.AlbumItem
import kotlinx.android.synthetic.main.fragment_top_charts.*

class TopSongsFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_top_charts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.withViewModel<TopChartsViewModel>{
            observe(albums, ::onAlbums)
        }

        searchField.afterTextChanged {

        }
    }

    private fun onAlbums(albums: List<AlbumItem>?) {
        albums?.let {
            albumsList.layoutManager = LinearLayoutManager(activity)
            albumsList.adapter = AlbumsAdapter(it) {
            }
        }
    }

}