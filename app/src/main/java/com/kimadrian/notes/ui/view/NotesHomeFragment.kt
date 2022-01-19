package com.kimadrian.notes.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.kimadrian.notes.R
import com.kimadrian.notes.databinding.FragmentNotesHomeBinding

class NotesHomeFragment : Fragment() {

    private lateinit var binding: FragmentNotesHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentNotesHomeBinding.inflate(inflater, container, false)

        binding.addNewNoteFab.setOnClickListener {
            findNavController().navigate(R.id.action_notesHomeFragment_to_newNoteFragment)
        }


        return binding.root


    }


}