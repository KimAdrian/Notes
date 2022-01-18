package com.kimadrian.notes.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.kimadrian.notes.R
import com.kimadrian.notes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addNewNoteFab.setOnClickListener {
            findNavController(R.id.myNavHostFragment).navigate(R.id.action_notesHomeFragment_to_newNoteFragment)
        }

    }

}