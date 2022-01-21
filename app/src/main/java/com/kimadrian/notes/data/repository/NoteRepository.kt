package com.kimadrian.notes.data.repository

import com.kimadrian.notes.data.model.Note
import com.kimadrian.notes.data.repository.room.NoteDatabase

class NoteRepository(private val noteDatabase: NoteDatabase) {

    suspend fun insertNote(note: Note) = noteDatabase.noteDatabaseDao.insertNote(note)

    suspend fun updateNote(note: Note) = noteDatabase.noteDatabaseDao.updateExistingNote(note)

    suspend fun deleteNote(note: Note) = noteDatabase.noteDatabaseDao.deleteNote(note)

    fun getAllNotes() = noteDatabase.noteDatabaseDao.getAllNotes()


}