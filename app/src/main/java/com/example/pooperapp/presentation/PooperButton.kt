package com.example.pooperapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.example.pooperapp.R

@Composable
fun PooperButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    FloatingActionButton(
        onClick = onClick,
        modifier = modifier
            .clip(CircleShape)
    ) {
        Image(
            painter = painterResource(R.drawable.poop_img),
            contentDescription = null

        )
        Text(
            text ="+",
            fontSize = 26.sp,
            color = Color.White
        )
    }
}