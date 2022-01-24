package com.kimadrian.notes.ui.view

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.kimadrian.notes.R
import com.kimadrian.notes.data.model.Note
import com.kimadrian.notes.data.repository.NoteRepository
import com.kimadrian.notes.data.repository.room.NoteDatabase
import com.kimadrian.notes.databinding.FragmentEditNoteBinding
import com.kimadrian.notes.ui.viewmodel.NotesViewModel
import com.kimadrian.notes.ui.viewmodel.NotesViewModelFactory
import com.skydoves.colorpickerview.ColorPickerDialog
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener
import timber.log.Timber

class EditNoteFragment : Fragment() {

    private lateinit var binding: FragmentEditNoteBinding
    private lateinit var viewModel: NotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val noteDatabase = NoteDatabase.getInstance(requireActivity())
        val noteRepository = NoteRepository(noteDatabase)
        val viewModelFactory = NotesViewModelFactory(noteRepository)
        var color = Color.WHITE
        var id: Int = -1
        // Inflate the layout for this fragment
        binding = FragmentEditNoteBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this, viewModelFactory)[NotesViewModel::class.java]



        //Receive data from recyclerView
        arguments.let {
            val args = EditNoteFragmentArgs.fromBundle(it!!)
            viewModel.getAllNotes.observe(viewLifecycleOwner, {
                binding.titleInput.setText(args.title)
                binding.descriptionInput.setText(args.description)
                binding.parent.setBackgroundColor(args.color)
                color = args.color
                id = args.id
            })
        }

        //customize color
        binding.customizeColor.setOnClickListener {
            ColorPickerDialog.Builder(activity)
                .setTitle("Pick color")
                .setPreferenceName("MyColorPickerDialog")
                .setPositiveButton("Confirm", ColorEnvelopeListener { envelope, _ ->
                    binding.parent.setBackgroundColor(envelope.color)
                    color = envelope.color
                    Timber.d(envelope.color.toString())
                    Timber.d(envelope.hexCode)
                    Timber.d(envelope.argb.toString())
                })
                .setNegativeButton("Close") { dialogInterface, _ ->
                    dialogInterface.dismiss()
                }.show()
        }

        binding.updateNoteFab.setOnClickListener {
            val title = binding.titleInput.text.toString()
            val description = binding.descriptionInput.text.toString()

            when {
                title.isEmpty() -> {
                    binding.titleInput.error = "Field cannot be empty"
                }
                description.isEmpty() -> {
                    binding.descriptionInput.error = "Field cannot be empty"
                }
                //Update existing note
                else -> {
                    viewModel.updateNote(Note(id, title, description, color))
                    Toast.makeText(activity, "Note updated", Toast.LENGTH_LONG).show()
                    findNavController().navigate(R.id.action_editNoteFragment_to_notesHomeFragment)
                }
            }
        }

        binding.deleteNoteFab.setOnClickListener {
            val title = binding.titleInput.text.toString()
            val description = binding.descriptionInput.text.toString()

            viewModel.deleteNote(Note(id, title, description, color))
            Toast.makeText(activity, "Note deleted", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_editNoteFragment_to_notesHomeFragment)
        }

        activity?.onBackPressedDispatcher?.addCallback(requireActivity(), object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().navigate(R.id.action_editNoteFragment_to_notesHomeFragment)
            }
        })


        return binding.root
    }

}