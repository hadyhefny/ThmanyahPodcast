package com.example.thmanyahpodcast.modules.playlist.presentation.view

import android.content.Context
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
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
        ViewCompat.setOnApplyWindowInsetsListener(window.decorView) { view, windowInsets ->
            val insets = windowInsets.getInsets(
                WindowInsetsCompat.Type.systemGestures()
            )
            view.updatePadding(
                insets.left,
                0,
                insets.right,
                insets.bottom
            )
            WindowInsetsCompat.CONSUMED
        }
        setContent {
            MaterialTheme(colorScheme = MaterialTheme.colorScheme.copy(background = Color.White)) {
                PlaylistScreen()
            }
        }
    }
}