package com.example.thmanyahpodcast.modules.playlist.di

import com.example.thmanyahpodcast.core.data.source.remote.MainService
import com.example.thmanyahpodcast.modules.playlist.data.repository.PlaylistRepositoryImpl
import com.example.thmanyahpodcast.modules.playlist.data.source.remote.PlaylistRemoteDs
import com.example.thmanyahpodcast.modules.playlist.domain.repository.PlaylistRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@InstallIn(ViewModelComponent::class)
@Module
object PlaylistModule {
    @ViewModelScoped
    @Provides
    fun providePlaylistRepositoryImpl(
        playlistRemoteDs: PlaylistRemoteDs
    ): PlaylistRepository {
        return PlaylistRepositoryImpl(playlistRemoteDs)
    }

    @ViewModelScoped
    @Provides
    fun providePlaylistRemoteDs(
        mainService: MainService
    ): PlaylistRemoteDs {
        return PlaylistRemoteDs(mainService)
    }
}