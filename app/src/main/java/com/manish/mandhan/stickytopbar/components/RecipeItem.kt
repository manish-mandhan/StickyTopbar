package com.manish.mandhan.stickytopbar.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.manish.mandhan.stickytopbar.R
import com.manish.mandhan.stickytopbar.model.DomainRecipeModel


@Composable
fun RecipeItem(
    data: DomainRecipeModel,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .matchParentSize()
                .background(MaterialTheme.colorScheme.primary)
        ) {

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.onPrimary)
        ) {

            Image(
                modifier = Modifier.size(100.dp),
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = null, contentScale = ContentScale.FillWidth

            )
            Column(modifier = Modifier.fillMaxWidth(.70f)) {

                Text(
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    text = data.strMeal,
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .padding(start = 12.dp),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                )
                Text(
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .padding(horizontal = 12.dp),
                    text = data.strInstruction,
                    maxLines = 2,
                    fontSize = 12.sp,
                    softWrap = true,
                    overflow = TextOverflow.Ellipsis
                )

            }
            Spacer(modifier = Modifier
                .weight(1f))
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = data.strCategory,
                    modifier = Modifier.padding(end = 14.dp, top = 14.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    Modifier.padding(horizontal = 24.dp)
                )

            }
        }
    }
    Spacer(
        modifier = Modifier
            .height(16.dp)
            .background(MaterialTheme.colorScheme.primary)
    )
}
