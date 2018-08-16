package com.certification.putintsevsergii.certification.topSongs.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.certification.putintsevsergii.certification.R
import com.certification.putintsevsergii.certification.extensions.show
import com.certification.putintsevsergii.certification.topSongs.data.AlbumItem

class AlbumsAdapter(private val items: List<AlbumItem?>?, private val clickListener: (AlbumItem?) -> Unit?) : RecyclerView.Adapter<AlbumsAdapter.AlbumItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumItemViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_album,
                parent, false)
        return AlbumItemViewHolder(v)
    }

    override fun getItemCount(): Int {
        items?.let {
            return it.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: AlbumItemViewHolder, position: Int) {
        val currentItem = items?.get(position)
        holder.itemTitle?.text = currentItem?.name
        holder.itemPhoto?.show(currentItem?.imageUrl)
        holder.itemTitle?.setOnClickListener {
            clickListener(currentItem)
        }

    }

    class AlbumItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemTitle: TextView? = null
        var itemPhoto: ImageView? = null

        init {
            itemTitle = itemView.findViewById(R.id.albumName)
            itemPhoto = itemView.findViewById(R.id.albumPhoto)
        }
    }
}