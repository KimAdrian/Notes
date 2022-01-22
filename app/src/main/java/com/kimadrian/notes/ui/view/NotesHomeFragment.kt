package com.kimadrian.notes.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kimadrian.notes.R
import com.kimadrian.notes.data.model.Note
import com.kimadrian.notes.data.repository.NoteRepository
import com.kimadrian.notes.data.repository.room.NoteDatabase
import com.kimadrian.notes.databinding.FragmentNotesHomeBinding
import com.kimadrian.notes.ui.adapter.NotesRecyclerViewAdapter
import com.kimadrian.notes.ui.viewmodel.NotesViewModel
import com.kimadrian.notes.ui.viewmodel.NotesViewModelFactory
import timber.log.Timber

class NotesHomeFragment : Fragment() {

    private lateinit var binding: FragmentNotesHomeBinding
    private lateinit var viewModel: NotesViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val noteDatabase = NoteDatabase.getInstance(requireActivity())
        val noteRepository = NoteRepository(noteDatabase)
        val viewModelFactory = NotesViewModelFactory(noteRepository)

        // Inflate the layout for this fragment
        binding = FragmentNotesHomeBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this, viewModelFactory)[NotesViewModel::class.java]

        val adapter = NotesRecyclerViewAdapter()
        viewModel.getAllNotes.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
        Timber.d("${adapter.currentList.size}")

        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = adapter

        binding.addNewNoteFab.setOnClickListener {
            findNavController().navigate(R.id.action_notesHomeFragment_to_newNoteFragment)
        }


        return binding.root


    }


}




