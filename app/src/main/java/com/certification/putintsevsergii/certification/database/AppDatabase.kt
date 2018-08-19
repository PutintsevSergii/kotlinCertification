package com.certification.putintsevsergii.certification.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.certification.putintsevsergii.certification.database.entities.AlbumItemData
import com.certification.putintsevsergii.certification.topSongs.data.database.AlbumsDao

@Database(entities = [(AlbumItemData::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun albumsDao(): AlbumsDao
}

object Database {

    var databaseInstance: AppDatabase? = null

    @Synchronized
    fun getInstance(context: Context): AppDatabase {
        if (databaseInstance == null) {
            databaseInstance = Room
                    .databaseBuilder(context.applicationContext, AppDatabase::class.java, "TopSongsDb")
                    .fallbackToDestructiveMigration()
                    .build()
        }
        return databaseInstance!!
    }

}