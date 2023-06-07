package com.example.thmanyahpodcast.modules.playlist.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun EpisodesHeader(
    title: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
            .background(Color.White)
            .padding(horizontal = 20.dp)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.episodes_header_title),
                    fontSize = 15.sp,
                    fontFamily = FontFamily(
                        Font(R.font.ibm_plex_sans_arabic_semi_bold)
                    ),
                    color = colorResource(id = R.color.dark_gunmetal),
                )

                Text(
                    text = title,
                    fontSize = 12.sp,
                    fontFamily = FontFamily(
                        Font(R.font.ibm_plex_sans_arabic_regular)
                    ),
                    color = colorResource(id = R.color.light_grey),
                )
            }
        }
    }
}

@Preview
@Composable
private fun EpisodesHeaderPreview() {
    MaterialTheme {
        EpisodesHeader(modifier = Modifier.fillMaxWidth(), title = "الحلقات السابقة")
    }
}