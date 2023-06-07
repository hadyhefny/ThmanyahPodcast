package com.example.thmanyahpodcast.modules.playlist.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.example.thmanyahpodcast.R
import com.example.thmanyahpodcast.modules.playlist.presentation.uimodel.EpisodeUiModel

@Composable
fun EpisodeItem(
    episode: EpisodeUiModel,
    modifier: Modifier = Modifier,
    onPlayClick: () -> Unit,
    onMoreClick: () -> Unit
) {
    ConstraintLayout(modifier = modifier) {
        val (image, titleText, nameText, playBtn, moreBtn, dateText) = createRefs()
        AsyncImage(
            model = episode.image,
            contentDescription = null,
            modifier = Modifier
                .size(76.dp)
                .clip(RoundedCornerShape(10.dp))
                .constrainAs(image) {
                    start.linkTo(parent.start)
                })
        Text(
            text = episode.name,
            color = colorResource(id = R.color.dark_gunmetal),
            fontSize = 12.sp,
            fontFamily = FontFamily(
                Font(R.font.ibm_plex_sans_arabic_semi_bold)
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .constrainAs(titleText) {
                    linkTo(image.end, playBtn.start, bias = 0f, startMargin = 16.dp)
                    width = Dimension.fillToConstraints
                }
        )
        Text(
            text = episode.podcastName,
            color = colorResource(id = R.color.grey),
            fontSize = 10.sp,
            fontFamily = FontFamily(
                Font(R.font.ibm_plex_sans_arabic_regular)
            ),
            modifier = Modifier
                .padding(top = 4.dp, start = 15.dp)
                .constrainAs(nameText) {
                    linkTo(image.end, parent.end, bias = 0f)
                    top.linkTo(titleText.bottom)
                }
        )

        Text(
            text = episode.episodeDateAndTime,
            color = colorResource(id = R.color.grey),
            fontSize = 10.sp,
            fontFamily = FontFamily(
                Font(R.font.ibm_plex_sans_arabic_regular)
            ),
            modifier = Modifier
                .padding(top = 4.dp, start = 15.dp)
                .constrainAs(dateText) {
                    linkTo(image.end, parent.end, bias = 0f)
                    top.linkTo(nameText.bottom)
                }
        )

        PlayButton(
            modifier = Modifier
                .padding(start = 16.dp)
                .size(24.dp)
                .constrainAs(playBtn) {
                    end.linkTo(moreBtn.start)
                    top.linkTo(parent.top)
                },
            icon = R.drawable.ic_play_small,
            onClick = onPlayClick,
        )

        Button(
            onClick = onMoreClick,
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            modifier = Modifier
                .padding(start = 5.dp)
                .size(24.dp)
                .constrainAs(moreBtn) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                },
            shape = CircleShape,
            contentPadding = PaddingValues(0.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_more_menu),
                contentDescription = null
            )
        }

    }
}

@Preview
@Composable
private fun EpisodeItemPreview() {
    MaterialTheme {
        EpisodeItem(
            episode = EpisodeUiModel(
                "", "name", "", "", "", "podcast name"
            ),
            modifier = Modifier.fillMaxWidth(),
            onPlayClick = {},
            onMoreClick = {}
        )
    }
}