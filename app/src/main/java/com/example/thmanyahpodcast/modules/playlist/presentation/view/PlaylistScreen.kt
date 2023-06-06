package com.example.thmanyahpodcast.modules.playlist.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.thmanyahpodcast.modules.playlist.presentation.components.BottomNavigationBar
import com.example.thmanyahpodcast.modules.playlist.presentation.components.EpisodeItem
import com.example.thmanyahpodcast.modules.playlist.presentation.components.EpisodesHeader
import com.example.thmanyahpodcast.modules.playlist.presentation.components.ErrorComponent
import com.example.thmanyahpodcast.modules.playlist.presentation.components.LoadingComponent
import com.example.thmanyahpodcast.modules.playlist.presentation.components.PlaylistHeader
import com.example.thmanyahpodcast.modules.playlist.presentation.viewmodel.PlaylistViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaylistScreen(viewModel: PlaylistViewModel = viewModel()) {
    val uiModel = viewModel.uiModel.collectAsState()
    Scaffold(bottomBar = {
        BottomNavigationBar(modifier = Modifier.shadow(elevation = 20.dp))
    }) {
        if (uiModel.value.isLoading) {
            LoadingComponent(modifier = Modifier.fillMaxSize())
        } else if (uiModel.value.error != null) {
            ErrorComponent(
                title = uiModel.value.error!!,
                modifier = Modifier.fillMaxSize()
            ) {
                viewModel.getPlaylist()
            }
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = it) {
                item {
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
                        onPlayClick = { },
                        onDownloadClick = {},
                    )
                }
                item {
                    EpisodesHeader(
                        title = uiModel.value.episodeCountDuration,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                items(uiModel.value.episodes) {
                    EpisodeItem(
                        episode = it,
                        modifier = Modifier
                            .background(color = Color.White)
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                            .fillMaxWidth(),
                        onPlayClick = {},
                        onMoreClick = {}
                    )
                }
            }
        }
    }
}