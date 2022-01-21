package com.kimadrian.notes.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kimadrian.notes.data.model.Note
import com.kimadrian.notes.data.repository.NoteRepository

class NotesViewModel(private val noteRepository: NoteRepository): ViewModel() {

    val note = MutableLiveData<Note>()

    fun saveNote(note: Note){

    }

    fun updateNote(note: Note){

    }

    fun deleteNote(note: Note){

    }
}