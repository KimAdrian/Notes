package com.kimadrian.notes.ui.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.kimadrian.notes.R
import com.kimadrian.notes.data.model.Note
import com.kimadrian.notes.data.repository.NoteRepository
import com.kimadrian.notes.data.repository.room.NoteDatabase
import com.kimadrian.notes.databinding.FragmentNewNoteBinding
import com.kimadrian.notes.ui.adapter.NotesRecyclerViewAdapter
import com.kimadrian.notes.ui.viewmodel.NotesViewModel
import com.kimadrian.notes.ui.viewmodel.NotesViewModelFactory
import timber.log.Timber

class NewNoteFragment : Fragment() {

    private lateinit var binding: FragmentNewNoteBinding
    private lateinit var viewModel: NotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val noteDatabase = NoteDatabase.getInstance(requireActivity())
        val noteRepository = NoteRepository(noteDatabase)
        val viewModelFactory = NotesViewModelFactory(noteRepository)

        // Inflate the layout for this fragment
        binding = FragmentNewNoteBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this, viewModelFactory)[NotesViewModel::class.java]


        binding.addNewNoteFab.setOnClickListener {
            val title = binding.titleInput.text.toString()
            val description = binding.descriptionInput.text.toString()

            when {
                title.isEmpty() -> {
                    binding.titleInput.error = "Field cannot be empty"
                }
                description.isEmpty() -> {
                    binding.descriptionInput.error = "Field cannot be empty"
                }
                else -> {

                    viewModel.saveNote(Note(0, title, description))
                    Toast.makeText(activity, "Note saved", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_newNoteFragment_to_notesHomeFragment)
                }
            }
        }

        return binding.root
    }

}