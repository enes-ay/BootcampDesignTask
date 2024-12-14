package com.enesay.bootcampdesigntask

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screens(val route: String, @StringRes val labelResId: Int, val icon: ImageVector) {
    object Profile : Screens("profile", R.string.profileScreen, Icons.Filled.Person)
    object Home : Screens("foodList", R.string.homeScreen,  Icons.Outlined.Home)
    object Favorites : Screens("favorites", R.string.favScreen, Icons.Outlined.FavoriteBorder)
}