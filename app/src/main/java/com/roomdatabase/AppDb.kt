package com.roomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database (entities = [(BookEntity::class)],version = 1)
abstract class AppDb : RoomDatabase() {

    abstract fun bookDao(): BookDAO
}