package com.manish.mandhan.stickytopbar

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.manish.mandhan.stickytopbar.components.RecipeItem
import kotlin.math.roundToInt


@Composable
fun RecipeListScreen(
) {
    //density
    val density = LocalDensity.current

    // padding and sizing
    val padding = WindowInsets.statusBars.asPaddingValues()
    val state = getRecipeList()
    val topBarSize = remember {
        mutableStateOf(0)
    }

    // offset
    val newOffset = remember {
        mutableStateOf(0f)
    }
    val currentOffset = remember {
        mutableStateOf(0f)
    }


    val nestedScroll = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                newOffset.value = available.y + currentOffset.value

                val previousOffset = currentOffset.value

                // used negative pixels here, because offset in negative causes topbar to go up.
                currentOffset.value = newOffset.value.coerceIn(
                    minimumValue = with(density) { -(130.dp.toPx()) },
                    maximumValue = 0f
                )



                Log.d(
                    "DEBUGGING LOG",
                    "y : ${available.y}\noffSet : ${currentOffset.value}\ncosumed: ${currentOffset.value - previousOffset}"
                )


                // previous value and current value will be same, if the new offset exceeds from the give bounds
                return Offset(0f, currentOffset.value - previousOffset)

            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(nestedScroll)
    ) {

        MyTopBar(modifier = Modifier
            .graphicsLayer {
                translationY = currentOffset.value
            }
            .onSizeChanged {
                topBarSize.value = it.height
            }
            .zIndex(4f)
            .shadow(elevation = 6.dp)
            .background(MaterialTheme.colorScheme.primary)
            .padding(padding)
            .fillMaxWidth()
            .padding(bottom = 16.dp),
            gap = {
                Spacer(
                    modifier = Modifier.height(
                        with(density) {
                            -(currentOffset.value * .2f).toDp()
                        }
                    )
                )
            }

        )
        LazyColumn(
            contentPadding = PaddingValues(top = 16.dp),
            modifier = Modifier
                .fillMaxSize()
                .offset { IntOffset(0, topBarSize.value + currentOffset.value.roundToInt()) }
                .background(MaterialTheme.colorScheme.primary)
                .padding(bottom = with(density) { topBarSize.value.toDp() + currentOffset.value.toDp() })
        ) {
            items(state) { item ->
                RecipeItem(data = item)
            }
        }
    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(
    modifier: Modifier = Modifier,
    gap: @Composable ColumnScope.() -> Unit
) {
    val density = LocalDensity.current


    Column(
        modifier = modifier
    ) {

        Text(
            fontSize = 26.sp,
            text = "Search Recipes",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
                .padding(horizontal = 12.dp)
        )
        Text(
            modifier = Modifier.padding(horizontal = 12.dp),
            fontSize = 16.sp,
            text = "Browse your favorite recipes",
        )
        gap()


        SearchBar(
            windowInsets = WindowInsets(top = SearchBarDefaults.windowInsets.getTop(density = density) / 2),
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary),
            inputField = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primary),
                    contentAlignment = Alignment.Center
                ) {

                    TextField(
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = MaterialTheme.colorScheme.onPrimary,
                            focusedContainerColor = MaterialTheme.colorScheme.onPrimary,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        modifier = Modifier
                            .fillMaxWidth(.9f)
                            .clip(CircleShape)
                            .height(50.dp),
                        value = "",
                        onValueChange = {},
                        leadingIcon = {
                            IconButton(onClick = {}) {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "Search"
                                )
                            }
                        },
                    )
                }
            },
            expanded = false,
            onExpandedChange = {}
        ) {

        }


    }

}
