package com.roomdatabase

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import androidx.room.Room

class MainActivity : AppCompatActivity() {

    @SuppressLint("LogConditional")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var db = Room.databaseBuilder(applicationContext, AppDb::class.java, "BookDB").build()


        //Insert Case
        val thread = Thread {
            var bookEntity = BookEntity()
            bookEntity.bookId = 1
            bookEntity.bookName = "Kotlin for Android Developer"

            db.bookDao().saveBooks(bookEntity)

            //fetch Records
            db.bookDao().getAllBooks().forEach()
            {
                Log.i("Fetch Records", "Id:  : ${it.bookId}")
                Log.i("Fetch Records", "Name:  : ${it.bookName}")
            }
        }
        thread.start()


    }
}
