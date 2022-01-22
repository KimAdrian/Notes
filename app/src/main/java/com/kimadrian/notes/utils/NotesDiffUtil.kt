package com.kimadrian.notes.utils

import androidx.recyclerview.widget.DiffUtil
import com.kimadrian.notes.data.model.Note

class NotesDiffUtil: DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem == newItem
    }
}