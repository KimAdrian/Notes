package com.kimadrian.notes.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kimadrian.notes.R
import com.kimadrian.notes.databinding.FragmentNewNoteBinding
import timber.log.Timber

class NewNoteFragment : Fragment() {

    private lateinit var binding: FragmentNewNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewNoteBinding.inflate(inflater, container, false)

        val title = binding.titleInput.text.toString()
        val description = binding.descriptionInput.text.toString()

        binding.addNewNoteFab.setOnClickListener {
            Timber.d(title)
            Timber.d(description)
        }

        return binding.root
    }

}