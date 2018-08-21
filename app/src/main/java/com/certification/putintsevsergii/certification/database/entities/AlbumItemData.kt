package com.certification.putintsevsergii.certification.database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.certification.putintsevsergii.certification.topSongs.data.AlbumItem

@Entity(tableName = "albums")
data class AlbumItemData(
                        @PrimaryKey @ColumnInfo(name = "id") val id: String,
                        @ColumnInfo(name = "artistName") val artistName: String,
                        @ColumnInfo(name = "name") val name: String,
                        @ColumnInfo(name = "releaseDate") val releaseDate: String,
                        @ColumnInfo(name = "copyright")  val copyright: String,
                        @ColumnInfo(name = "artistId")  val artistId: String,
                        @ColumnInfo(name = "imageUrl")  val imageUrl: String,
                        @ColumnInfo(name = "favourite")  val isFavourite: Boolean
)
{
    constructor(item: AlbumItem) : this(item.id, item.artistName, item.name, item.releaseDate, item.copyright, item.artistId, item.imageUrl, item.isFavouriteItem)

    fun toAlbumItem() = AlbumItem(id, artistName, name, releaseDate, copyright, artistId, imageUrl, isFavourite)
}