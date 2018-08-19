package com.certification.putintsevsergii.certification.database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.certification.putintsevsergii.certification.topSongs.data.AlbumItem

@Entity(tableName = "albums")
data class AlbumItemData(
                        @PrimaryKey(autoGenerate = true) var remoteId: Long?,
                        @ColumnInfo(name = "id") val id: String,
                        @ColumnInfo(name = "artistName") val artistName: String,
                        @ColumnInfo(name = "name") val name: String,
                        @ColumnInfo(name = "releaseDate") val releaseDate: String,
                        @ColumnInfo(name = "copyright")  val copyright: String,
                        @ColumnInfo(name = "artistId")  val artistId: String,
                        @ColumnInfo(name = "imageUrl")  val imageUrl: String
)
{
    fun toAlbumItem() = AlbumItem(id, artistName, name, releaseDate, copyright, artistId, imageUrl)
}