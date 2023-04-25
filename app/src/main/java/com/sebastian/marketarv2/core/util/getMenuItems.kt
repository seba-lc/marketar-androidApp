package com.sebastian.marketarv2.core.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ShoppingCart

fun getMenuItems() : List<MenuItem> = listOf(
    MenuItem(
        id = "products",
        title = "Home",
        contentDescription = "Go to Home Screen",
        icon = Icons.Default.Home
    ),
    MenuItem(
        id = "products",
        title = "Landing",
        contentDescription = "Go to Landing Screen",
        icon = Icons.Default.List
    ),
    MenuItem(
        id = "products",
        title = "Products",
        contentDescription = "Go to Products Screen",
        icon = Icons.Default.Info
    ),
    MenuItem(
        id = "checkout",
        title = "Checkout",
        contentDescription = "Go to Checkout Screen",
        icon = Icons.Default.ShoppingCart
    )
)