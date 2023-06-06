package com.example.thmanyahpodcast.modules.playlist.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thmanyahpodcast.R

@Composable
fun ErrorComponent(
    modifier: Modifier = Modifier,
    title: String = stringResource(id = R.string.something_went_wrong),
    onRetry: () -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = title)
        Button(
            onClick = onRetry,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 20.dp),
            shape = RoundedCornerShape(4.dp),
            border = BorderStroke(0.5.dp, Color.Red),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.white))
        ) {
            Text(
                text = stringResource(id = R.string.retry),
                color = Color.Red,
                fontSize = 13.sp,
                fontFamily = FontFamily(Font(R.font.ibm_plex_sans_arabic_regular))
            )
        }
    }
}

@Composable
@Preview()
private fun ErrorComponentPhonePreview() {
    ErrorComponent(title = "Something went wrong", modifier = Modifier.fillMaxSize()) {

    }
}