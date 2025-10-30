package com.example.pooperapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pooperapp.R

@Composable
fun ShowDrawerButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    FloatingActionButton(
        onClick = onClick,
        modifier = modifier
            .clip(CircleShape)
            .size(75.dp)
            .border(1.dp, Color.Black, CircleShape)
    ) {
        Image(
            painter = painterResource(R.drawable.profile_placeholder),
            contentDescription = null,
        )
    }
}