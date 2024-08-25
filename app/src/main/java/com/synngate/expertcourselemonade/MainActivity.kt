package com.synngate.expertcourselemonade

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.synngate.expertcourselemonade.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var uiState: GameUiState
    private lateinit var viewModel: GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.rootLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewModel = (application.applicationContext as LemonApp).viewModel

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

        uiState = viewModel.current()
        updateUiState.invoke()
    }
}