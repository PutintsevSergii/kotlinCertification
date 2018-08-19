package com.certification.putintsevsergii.certification.topSongs.data.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.certification.putintsevsergii.certification.database.entities.AlbumItemData

@Dao
interface AlbumsDao {

    @get:Query("SELECT * FROM albums")
    val all: List<AlbumItemData>

    @Query("SELECT * FROM albums WHERE remoteId LIKE :remoteId")
    fun findById(remoteId: String): LiveData<AlbumItemData>

    @Query("SELECT * FROM albums")
    fun findByall(): LiveData<AlbumItemData>

    @Insert(onConflict = REPLACE)
    fun insert(album: AlbumItemData)

    @Update
    fun update(album: AlbumItemData)

    @Delete
    fun delete(album: AlbumItemData)
}