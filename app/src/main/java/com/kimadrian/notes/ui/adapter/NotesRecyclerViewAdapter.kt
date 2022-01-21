package com.kimadrian.notes.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.kimadrian.notes.R
import com.kimadrian.notes.data.model.Note

class NotesRecyclerViewAdapter(private val noteList: List<Note>, private val context: Context): RecyclerView.Adapter<NoteRecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_recycler_item, parent, false)

        return NoteRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteRecyclerViewHolder, position: Int) {
        val note = noteList[position]

        holder.title.text = note.title
        holder.description.text = note.description

        holder.itemView.setOnClickListener {
            //TODO: Implement nav args
        }
    }

    override fun getItemCount(): Int = noteList.size


}

class NoteRecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val title: TextView = itemView.findViewById(R.id.noteTitle)
    val description: TextView = itemView.findViewById(R.id.noteDescription)
}