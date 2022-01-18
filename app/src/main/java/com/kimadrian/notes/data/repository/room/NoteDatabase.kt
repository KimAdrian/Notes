package com.kimadrian.notes.data.repository.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kimadrian.notes.data.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase :RoomDatabase(){

    abstract val noteDatabaseDao: NoteDatabaseDao

    companion object{
        @Volatile
        private var INSTANCE: NoteDatabase? = null

        fun getInstance(context: Context): NoteDatabase{
            synchronized(this){
                var instance = INSTANCE

                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NoteDatabase::class.java,
                        "notes_database"
                    ).build()
                }
                return instance
            }
        }
    }
}