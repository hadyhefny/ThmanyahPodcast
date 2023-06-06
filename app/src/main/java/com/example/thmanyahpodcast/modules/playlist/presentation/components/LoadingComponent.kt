package com.example.thmanyahpodcast.modules.playlist.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thmanyahpodcast.R

@Composable
fun LoadingComponent(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Surface(
            modifier = Modifier
                .size(50.dp)
                .align(Alignment.Center),
            color = Color.White,
            shape = CircleShape,
            shadowElevation = 10.dp
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .padding(10.dp),
                color = colorResource(id = R.color.blue)
            )
        }
    }
}

@Composable
@Preview(device = Devices.PHONE)
private fun LoadingComponentPreview() {
    LoadingComponent(modifier = Modifier.fillMaxSize())
}

