package com.example.pooperapp

import android.R
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class Navigation {
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PooperTopBar() {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        ),
        title = { Text("Pooper Map") }
    )
}

@Composable
fun PooperBottomBar(modifier: Modifier = Modifier) {
    BottomAppBar(

    ){
        Text(
            text = "BOTTOM",
            modifier = Modifier.padding(12.dp)
        )}
}