package com.example.pooperapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Help
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pooperapp.R
import com.example.pooperapp.data.PoopMarkerData
import com.example.pooperapp.viewmodels.PooperViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.launch

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PooperScreen(
    pooperViewModel: PooperViewModel,
    navController: NavHostController = rememberNavController()
) {
    // ADD PERMISSIONS
    val locationPermission = rememberMultiplePermissionsState(
        permissions = listOf(
            "android.permission.ACCESS_FINE_LOCATION",
            "android.permission.ACCESS_COARSE_LOCATION"
        )
    )

    // REQUEST PERMISSIONS DIALOG
    LaunchedEffect(key1 = locationPermission.permissions) {
        locationPermission.launchMultiplePermissionRequest()
    }
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        val drawerState = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()

        ModalNavigationDrawer(
            drawerState = drawerState,
            gesturesEnabled = drawerState.isOpen,
            drawerContent = {
                ModalDrawerSheet {
                    Image(
                        painter = painterResource(R.drawable.profile_placeholder),
                        contentDescription = stringResource(id = R.string.pooper_screen_cd_app),
                        modifier = Modifier
                            .background(Color.Transparent)
                            .padding(16.dp)
                            .border(1.dp, Color.Black, CircleShape)
                    )
                    screens.forEach { screen ->
                        NavigationDrawerItem(
                            label = { Text(screen.title) },
                            selected = false,
                            icon = { Icon(screen.imageVector, contentDescription = null)},
                            onClick = {
                                scope.launch { drawerState.close() }
                                navController.navigate(screen.route) {
                                    popUpTo(DrawerScreens.Map.route) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    NavigationDrawerItem (
                        label = { Text(stringResource(id = R.string.pooper_screen_help_and_feedback)) },
                        selected = false,
                        icon = { Icon(Icons.AutoMirrored.Default.Help, contentDescription = null) },
                        onClick = {/* TODO() Create help and feedback screen */}
                    )
                    NavigationDrawerItem (
                        label = { Text(stringResource(id = R.string.pooper_screen_log_out)) },
                        selected = false,
                        icon = { Icon(Icons.AutoMirrored.Filled.Logout, contentDescription = "Logout")},
                        onClick = {/* TODO() Create help and log out screen */}
                    )
                }
            }
        ) {
            Scaffold (
                content = { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = DrawerScreens.Map.route,
                        ) {
                            composable(DrawerScreens.Map.route) {
                                MapScreen(
                                    modifier = Modifier.fillMaxSize(),
                                    pooperViewModel = pooperViewModel,
                                    startLocation = pooperViewModel.getCurrentLocation(),
                                    locationPermission = locationPermission
                                )
                            }
                            composable (DrawerScreens.Profile.route) {
                                ProfileScreen()
                            }
                            composable (DrawerScreens.Poops.route) {
                                PoopsListScreen()
                            }
                        }

                        ShowDrawerButton(
                            onClick = { scope.launch { drawerState.open() } },
                            modifier = Modifier
                                .align(Alignment.TopStart)
                                .padding(16.dp)
                        )
                    }
                }
            )
        }
    }
}

//@Preview
//@Composable
//fun AppPreview() {
//    PooperAppTheme {
//        PooperScreen()
//    }
//}