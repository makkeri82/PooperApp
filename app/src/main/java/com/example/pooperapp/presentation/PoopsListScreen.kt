package com.example.pooperapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pooperapp.ui.theme.PooperAppTheme

@Composable
fun PoopsListScreen() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Poops",
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.End),
            style = MaterialTheme.typography.titleLarge
        )
        HorizontalDivider(
            modifier = Modifier
                .padding(vertical = 8.dp)
        )


    }
}

@Preview
@Composable
fun ListPreview() {
    PooperAppTheme {
        PoopsListScreen()
    }
}