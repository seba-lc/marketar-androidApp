package com.sebastian.marketarv2.feature_products.presentation.util

import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import com.sebastian.marketarv2.feature_products.core.presentation.components.DrawerBody
import com.sebastian.marketarv2.feature_products.core.presentation.components.Header
import com.sebastian.marketarv2.feature_products.core.util.getMenuItems
import kotlinx.coroutines.launch

@Composable
fun AppWrapper(
    navController: NavController,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    content: @Composable () -> Unit
) {

    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            Header(
                onNavigationIconClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            DrawerBody(
                items = getMenuItems(),
                onItemClick = {
                    navController.navigate(it.id)
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
                },
            )
        },
    ) {
        content()
    }


}