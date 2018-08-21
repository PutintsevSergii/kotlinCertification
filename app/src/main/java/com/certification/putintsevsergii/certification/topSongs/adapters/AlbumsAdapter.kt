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
import kotlinx.android.synthetic.main.item_album.view.*

class AlbumsAdapter(private val items: List<AlbumItem>, private val clickListener: (AlbumItem) -> Unit?) : RecyclerView.Adapter<AlbumsAdapter.AlbumItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            AlbumItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_album,
            parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: AlbumItemViewHolder, position: Int) {
        val currentItem = items[position]
        holder.itemTitle?.text = currentItem.name
        holder.itemPhoto?.show(currentItem.imageUrl)
        holder.itemTitle?.setOnClickListener {
            clickListener(currentItem)
        }
    }

    class AlbumItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemTitle: TextView? = itemView.albumName
        var itemPhoto: ImageView? = itemView.albumPhoto
    }
}