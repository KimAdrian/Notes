package com.kimadrian.notes.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kimadrian.notes.data.model.Note

class NotesRecyclerViewAdapter(private val noteList: List<Note>, private val context: Context): RecyclerView.Adapter<NoteRecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteRecyclerViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: NoteRecyclerViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = noteList.size


}

class NoteRecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

}