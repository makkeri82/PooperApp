package com.example.pooperapp.presentation

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Help
import androidx.compose.material.icons.automirrored.filled.Outbound
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Map
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pooperapp.ui.theme.PooperAppTheme
import com.example.pooperapp.R

sealed class DrawerScreens(val title: String, val route: String, val imageVector: ImageVector) {
    object Map: DrawerScreens("Map", "map", Icons.Default.Map)
    object Profile: DrawerScreens("Profile","profile", Icons.Default.AccountCircle)
    object Poops: DrawerScreens("Poops", "poops", Icons.AutoMirrored.Default.Outbound)
}

val screens = listOf(
    DrawerScreens.Map,
    DrawerScreens.Profile,
    DrawerScreens.Poops
)

@Composable
fun Drawer(
    modifier: Modifier = Modifier,
    onDestinationClicked: (route: String) -> Unit
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(start =24.dp, 48.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.profile_placeholder),
            contentDescription = "App",
            modifier = Modifier
                .clip(CircleShape)
        )
        screens.forEach { screen ->
            Text(
                text = screen.title,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview
@Composable
fun DrawerPreview() {
    PooperAppTheme{
        //Drawer(Modifier, {})
    }
}
