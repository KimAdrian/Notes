package com.kimadrian.notes.data.repository

import com.kimadrian.notes.data.model.Note
import com.kimadrian.notes.data.repository.room.NoteDatabase

class NoteRepository(private val noteDatabase: NoteDatabase) {

    fun insertNote(note: Note){
        noteDatabase.noteDatabaseDao.insertNewNote(note)
    }

    fun updateNote(note: Note){
        noteDatabase.noteDatabaseDao.updateExistingNote(note)
    }

    fun deleteNote(note: Note){
        noteDatabase.noteDatabaseDao.deleteNote(note)
    }

    fun getAllNotes(){
        noteDatabase.noteDatabaseDao.getAllNotes()
    }
}