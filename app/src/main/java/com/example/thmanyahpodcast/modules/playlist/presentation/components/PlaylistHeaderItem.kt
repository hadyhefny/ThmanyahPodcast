package com.example.thmanyahpodcast.modules.playlist.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.example.thmanyahpodcast.R

@Composable
fun PlaylistHeader(
    title: String,
    description: String,
    image: String,
    modifier: Modifier = Modifier,
    onMoreClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    onBackClick: () -> Unit,
    onShuffleClick: () -> Unit,
    onPlayClick: () -> Unit
) {
    ConstraintLayout(modifier = modifier) {
        val (back, favorite, more, titleText, descText, shuffleBtn, playBtn) = createRefs()
        AsyncImage(
            model = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)),
            contentScale = ContentScale.FillBounds,
        )

        BackButton(
            modifier = Modifier
                .padding(top = 53.dp, start = 16.dp)
                .constrainAs(back) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }, onClick = onBackClick
        )

        MoreButton(
            modifier = Modifier
                .padding(top = 53.dp, end = 16.dp)
                .constrainAs(more) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }, onClick = onMoreClick
        )

        FavoriteButton(
            modifier = Modifier
                .padding(top = 53.dp, end = 11.dp)
                .constrainAs(favorite) {
                    top.linkTo(parent.top)
                    end.linkTo(more.start)
                }, onClick = onFavoriteClick
        )

        Text(text = title,
            fontSize = 22.sp,
            fontFamily = FontFamily(Font(R.font.ibm_plex_sans_arabic_semi_bold)),
            color = Color.White,
            modifier = Modifier
                .wrapContentSize()
                .padding(top = 60.dp)
                .constrainAs(titleText) {
                    top.linkTo(back.bottom)
                    linkTo(
                        parent.start,
                        parent.end,
                        bias = 0f,
                        startMargin = 22.dp,
                        endMargin = 22.dp
                    )
                })

        Text(text = description,
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.ibm_plex_sans_arabic_regular)),
            color = Color.White,
            modifier = Modifier
                .wrapContentSize()
                .padding(top = 16.dp)
                .constrainAs(descText) {
                    top.linkTo(titleText.bottom)
                    linkTo(
                        parent.start,
                        parent.end,
                        bias = 0f,
                        startMargin = 22.dp,
                        endMargin = 22.dp
                    )
                })

        Button(onClick = onShuffleClick,
            shape = RoundedCornerShape(30.dp),
            contentPadding = PaddingValues(vertical = 0.dp, horizontal = 24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.blue)),
            modifier = Modifier
                .padding(top = 16.dp)
                .height(39.dp)
                .constrainAs(shuffleBtn) {
                    linkTo(parent.start, parent.end, bias = 0f, startMargin = 31.dp)
                    linkTo(
                        descText.bottom,
                        parent.bottom,
                        bias = 1f,
                        bottomMargin = 38.dp
                    )
                }) {
            Image(
                painter = painterResource(id = R.drawable.ic_shuffle),
                modifier = Modifier.padding(end = 4.dp),
                contentDescription = null
            )
            Text(
                text = stringResource(id = R.string.shuffle_play),
                color = Color.White,
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.ibm_plex_sans_arabic_medium))
            )
        }

        PlayButton(
            modifier = Modifier
                .padding(top = 16.dp)
                .size(38.dp)
                .constrainAs(playBtn) {
                    linkTo(parent.start, parent.end, bias = 1f, endMargin = 17.dp)
                    linkTo(shuffleBtn.top, shuffleBtn.bottom)
                }, onClick = onPlayClick
        )

    }
}

@Preview
@Composable
private fun PlaylistHeaderPreview() {
    MaterialTheme {
        PlaylistHeader(
            title = "title",
            description = "description",
            image = "",
            onMoreClick = {},
            onFavoriteClick = {},
            onBackClick = {},
            onShuffleClick = {},
            onPlayClick = {}
        )
    }
}