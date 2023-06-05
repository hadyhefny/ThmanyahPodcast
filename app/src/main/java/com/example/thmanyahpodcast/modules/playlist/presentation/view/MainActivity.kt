package com.example.thmanyahpodcast.modules.playlist.presentation.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.thmanyahpodcast.databinding.ActivityMainBinding
import com.example.thmanyahpodcast.modules.playlist.presentation.viewmodel.PlaylistViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<PlaylistViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }
        collectUiState()
        collectEffect()
    }

    private fun collectUiState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiModel.collectLatest { uiModel ->
                    binding.clLoading.isVisible = uiModel.isLoading
                }
            }
        }
    }

    private fun collectEffect() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.effect.collectLatest { effect ->
                    binding.clError.isVisible = effect != null
                    binding.errorTv.text = effect?.let { getString(it) }
                }
            }
        }
    }
}