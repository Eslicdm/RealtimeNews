package com.eslirodrigues.realtimenews.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.eslirodrigues.realtimenews.data.model.News
import com.eslirodrigues.realtimenews.ui.theme.DarkBlue
import com.eslirodrigues.realtimenews.ui.theme.LightBlue

@Composable
fun NewsListItem(news: News) {
        Column(
            modifier = Modifier
                .padding(vertical = 10.dp, horizontal = 7.dp)
                .border(2.dp, LightBlue)
                .background(DarkBlue)
        ) {
            Image(
                painter = rememberImagePainter(news.url),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .border(1.dp, LightBlue)
                    .size(width = 411.dp, height = 267.dp)
            )
            Text(
                text = news.title,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                color = Color.White,
                maxLines = 1,
                modifier = Modifier.padding(start = 10.dp)
            )
            Spacer(modifier = Modifier.padding(bottom = 16.dp))
        }
}