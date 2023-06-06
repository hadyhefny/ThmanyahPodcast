package com.example.thmanyahpodcast.modules.playlist.presentation.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.thmanyahpodcast.R

@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier) {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf(
        stringResource(id = R.string.main),
        stringResource(id = R.string.search),
        stringResource(id = R.string.library)
    )
    NavigationBar(containerColor = Color.White, modifier = modifier) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    when (index) {
                        0 -> Icon(
                            painterResource(id = R.drawable.ic_home),
                            contentDescription = item
                        )

                        1 -> Icon(
                            painterResource(id = R.drawable.ic_search),
                            contentDescription = item
                        )

                        2 -> Icon(
                            painterResource(id = R.drawable.ic_library),
                            contentDescription = item
                        )
                    }
                },
                label = {
                    Text(item)
                },
                selected = selectedItem == index,
                onClick = { selectedItem = index },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = colorResource(id = R.color.blue),
                    unselectedIconColor = colorResource(id = R.color.grey),
                    selectedTextColor = colorResource(id = R.color.blue),
                    unselectedTextColor = colorResource(id = R.color.grey),
                    indicatorColor = Color.White
                )
            )
        }
    }
}

