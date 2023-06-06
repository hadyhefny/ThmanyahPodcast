package com.example.thmanyahpodcast.modules.playlist.presentation.view

import android.content.Context
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.thmanyahpodcast.core.extension.changeLanguage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun attachBaseContext(newBase: Context?) {
        val ctx = newBase?.changeLanguage()
        super.attachBaseContext(ctx ?: newBase)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaylistScreen()
        }
    }
}