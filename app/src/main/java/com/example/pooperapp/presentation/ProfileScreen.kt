package com.example.pooperapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pooperapp.R
import com.example.pooperapp.ui.theme.PooperAppTheme

@Composable
fun ProfileScreen() {

    val name = "Ruska Repolainen"

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = name,
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.End),
            style = MaterialTheme.typography.titleLarge
        )
        HorizontalDivider(
            modifier = Modifier
                .padding(vertical = 8.dp)
        )
        Row {
            Text(
                text = stringResource(R.string.profile_screen_age_in_months),
                modifier = Modifier
                    .padding(8.dp, 16.dp, 8.dp, 8.dp)
                    .weight(1f)
            )
            Text(
                text = "30",
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            )
        }
        Row {
            Text(
                text = stringResource(R.string.profile_screen_weight_in_kg),
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            )
            Text(
                text = "31",
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            )
        }
        Row {
            Text(
                text = stringResource(R.string.profile_screen_shoulder_height_in_cm),
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            )
            Text(
                text = "62",
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            )
        }

    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    PooperAppTheme {
        ProfileScreen()
    }
}