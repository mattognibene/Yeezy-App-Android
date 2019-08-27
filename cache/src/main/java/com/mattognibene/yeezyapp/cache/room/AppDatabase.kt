package com.mattognibene.yeezyapp.cache.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mattognibene.yeezyapp.cache.room.model.ToBeDeleted

@Database(entities = [
    ToBeDeleted::class
], version = 1)
abstract class AppDatabase : RoomDatabase()