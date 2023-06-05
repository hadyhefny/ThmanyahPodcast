package com.example.thmanyahpodcast.modules.playlist.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.thmanyahpodcast.R
import com.example.thmanyahpodcast.modules.playlist.domain.interactor.GetPlaylistUseCase
import com.example.thmanyahpodcast.modules.playlist.presentation.uimodel.PlaylistUiState
import com.example.thmanyahpodcast.modules.playlist.presentation.uimodel.mapper.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import okio.IOException
import javax.inject.Inject

@HiltViewModel
class PlaylistViewModel @Inject constructor(
    @ApplicationContext private val application: Application,
    private val getPlaylistUseCase: GetPlaylistUseCase
) : AndroidViewModel(application) {

    private var _uiState = PlaylistUiState()
        private set(value) {
            field = value
            uiModel.value = value.toUiModel(application)
        }

    val uiModel = MutableStateFlow(_uiState.toUiModel(application))
    val effect = MutableSharedFlow<Int?>()

    init {
        getPlaylist()
    }

    private fun getPlaylist() {
        viewModelScope.launch {
            _uiState = _uiState.copy(isLoading = true)
            _uiState = try {
                val playlist = getPlaylistUseCase()
                _uiState.copy(isLoading = false, playlistEntity = playlist)
            } catch (e: Exception) {
                effect.emit(e.handleError())
                _uiState.copy(isLoading = false)
            }
        }
    }

    private fun Throwable.handleError() = when (this) {
        is IOException -> R.string.internet_connection_error
        else -> R.string.something_went_wrong
    }
}