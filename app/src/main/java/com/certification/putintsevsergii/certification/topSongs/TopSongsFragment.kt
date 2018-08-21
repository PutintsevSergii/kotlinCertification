package com.certification.putintsevsergii.certification.topSongs

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.certification.putintsevsergii.certification.R
import com.certification.putintsevsergii.certification.TopChartsViewModel
import com.certification.putintsevsergii.certification.TopSongNavigationInterface
import com.certification.putintsevsergii.certification.extensions.afterTextChanged
import com.certification.putintsevsergii.certification.extensions.getViewModel
import com.certification.putintsevsergii.certification.extensions.observe
import com.certification.putintsevsergii.certification.extensions.withViewModel
import com.certification.putintsevsergii.certification.topSongs.adapters.AlbumsAdapter
import com.certification.putintsevsergii.certification.topSongs.data.AlbumItem
import kotlinx.android.synthetic.main.fragment_top_charts.*

class TopSongsFragment: Fragment() {

    private var listener: TopSongNavigationInterface? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_top_charts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.withViewModel<TopChartsViewModel>{
            observe(albums, ::onAlbums)
        }
//        searchField.afterTextChanged {
//
//        }
    }

    private fun onAlbums(albums: List<AlbumItem>?) {
        albums?.let {
            albumsList.layoutManager = LinearLayoutManager(activity)
            albumsList.adapter = AlbumsAdapter(it) {
                activity?.getViewModel<TopChartsViewModel>()?.changeItemSelection(it)
                listener?.onSongDetails()
            }
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is TopSongNavigationInterface) {
            listener = context
        } else {
            throw RuntimeException(context?.toString() + " must implement FragmentEvent")
        }
    }

}