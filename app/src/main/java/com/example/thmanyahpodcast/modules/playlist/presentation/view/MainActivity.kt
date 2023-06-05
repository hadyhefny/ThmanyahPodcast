package com.example.thmanyahpodcast.modules.playlist.presentation.view

import android.content.Context
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.thmanyahpodcast.core.extension.changeLanguage
import com.example.thmanyahpodcast.modules.playlist.presentation.viewmodel.PlaylistViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<PlaylistViewModel>()

    override fun attachBaseContext(newBase: Context?) {
        val ctx = newBase?.changeLanguage()
        super.attachBaseContext(ctx ?: newBase)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaylistScreen()
        }
        collectUiState()
        collectEffect()
    }

    private fun collectUiState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiModel.collectLatest { uiModel ->
//                    binding.clLoading.isVisible = uiModel.isLoading
                }
            }
        }
    }

    private fun collectEffect() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.effect.collectLatest { effect ->
//                    binding.clError.isVisible = effect != null
//                    binding.errorTv.text = effect?.let { getString(it) }
                }
            }
        }
    }
}