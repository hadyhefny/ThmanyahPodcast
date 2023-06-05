package com.example.thmanyahpodcast.modules.playlist.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thmanyahpodcast.R

@Composable
fun PlayButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.blue)),
        modifier = modifier
            .size(38.dp),
        shape = CircleShape,
        contentPadding = PaddingValues(0.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.ic_play), contentDescription = null)
    }
}

@Preview
@Composable
private fun PlayButtonPreview() {
    MaterialTheme {
        PlayButton(onClick = {})
    }
}