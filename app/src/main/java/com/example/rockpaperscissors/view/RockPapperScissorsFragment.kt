/*
 * *
 *  * Copyright (c) $YEAR $USER. All rights reserved.
 *  *
 *  * Created by $USER on $DATE.
 *  * Filename: $NAME
 *
 */

package com.example.rockpaperscissors.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import com.example.rockpaperscissors.R
import com.example.rockpaperscissors.model.Choice
import com.example.rockpaperscissors.viewmodel.GameViewModel
import com.example.rockpaperscissors.databinding.FragmentRockPapperScissorsBinding;

/**
 * A simple [Fragment] subclass.
 * Use the [RockPapperScissorsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RockPapperScissorsFragment : Fragment() {
    private final var TAG: String = RockPapperScissorsFragment::class.java.toString()
    private var _binding: FragmentRockPapperScissorsBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel : GameViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentRockPapperScissorsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: ")
        initViewModel()
        initButtonListener()
    }

    fun initButtonListener() {
        Log.d(TAG, "initButtonListener: ")
        binding.rockButton.setOnClickListener {
            Log.d(TAG, "initButtonListener: ROCK")
            viewModel.play(Choice.ROCK)
        }
        binding.paperButton.setOnClickListener {
            Log.d(TAG, "initButtonListener: PAPER")
            viewModel.play(Choice.PAPER)
        }
        binding.scissorsButton.setOnClickListener {
            Log.d(TAG, "initButtonListener: SCISSORS")
            viewModel.play(Choice.SCISSORS)
        }
    }
    
    fun initViewModel() {
        Log.d(TAG, "initViewModel: ")
        viewModel = ViewModelProvider(requireActivity()).get(GameViewModel::class.java)
        viewModel.result.observe(viewLifecycleOwner) { result ->
            binding.resultTextView.text = result
        }
        viewModel.computerChoice.observe(viewLifecycleOwner) { choice ->
            binding.computerChoiceTextView.text = "Computer chose: $choice"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView: ")
        _binding = null
    }
}