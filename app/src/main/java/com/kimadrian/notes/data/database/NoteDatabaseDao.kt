package com.kimadrian.notes.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.kimadrian.notes.data.model.Note

@Dao
interface NoteDatabaseDao {
    //Insert a new note
    @Insert
    suspend fun insertNote(note: Note)

    //Update existing note
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateExistingNote(note: Note)

    //Delete Note
    @Delete
    suspend fun deleteNote(note: Note)

    //Fetch all notes into list ordered in descending order
    @Query("SELECT * FROM notes_table ORDER BY id DESC")
    fun getAllNotes(): LiveData<List<Note>>
}