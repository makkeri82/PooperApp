@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.pooperapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pooperapp.ui.theme.PooperAppTheme
import com.google.android.gms.maps.model.LatLng

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
            PooperAppTheme {
                    MyApp()
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    val ouluLocation = LatLng(65.0121, 25.4651)
    val poopData = PoopData()

    Scaffold { innerPadding ->

        Maps(
            modifier = Modifier.padding(innerPadding),
            location = ouluLocation,
            poopData = poopData.getPoopData()
            //mapProps = props
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    PooperAppTheme {
        MyApp()
    }
}