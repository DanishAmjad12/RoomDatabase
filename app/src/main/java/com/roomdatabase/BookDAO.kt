package com.roomdatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BookDAO
{
    @Insert
    fun saveBooks(book: BookEntity)


    @Query(value = "Select * from BookEntity")
    fun getAllBooks() : List<BookEntity>
}