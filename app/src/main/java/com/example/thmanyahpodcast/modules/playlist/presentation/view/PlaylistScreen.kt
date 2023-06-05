package com.example.thmanyahpodcast.modules.playlist.presentation.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.thmanyahpodcast.modules.playlist.presentation.components.PlaylistHeader
import com.example.thmanyahpodcast.modules.playlist.presentation.viewmodel.PlaylistViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PlaylistScreen(viewModel: PlaylistViewModel = viewModel()) {
    val uiModel = viewModel.uiModel.collectAsState()

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        stickyHeader {
            PlaylistHeader(
                title = uiModel.value.name,
                description = uiModel.value.description,
                image = uiModel.value.image,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(388.dp),
                onMoreClick = { },
                onFavoriteClick = { },
                onBackClick = {},
                onShuffleClick = { },
                onPlayClick = { }
            )
        }
    }
}