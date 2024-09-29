package com.synngate.expertcourselemonade.game.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.synngate.expertcourselemonade.GameUiState
import com.synngate.expertcourselemonade.GameViewModel
import com.synngate.expertcourselemonade.LemonApp
import com.synngate.expertcourselemonade.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    private lateinit var uiState: GameUiState
    private lateinit var viewModel: GameViewModel

    private var _binding: FragmentGameBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (requireActivity().application.applicationContext as LemonApp).viewModel

        val updateUiState: () -> Unit = {
            uiState.update(
                textView = binding.instructionTextView,
                imageButton = binding.gameImageButton
            )
        }

        binding.gameImageButton.setOnClickListener {
            uiState = viewModel.next()
            updateUiState.invoke()
        }

        uiState = viewModel.current(firstRun = (savedInstanceState == null))
        updateUiState.invoke()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}