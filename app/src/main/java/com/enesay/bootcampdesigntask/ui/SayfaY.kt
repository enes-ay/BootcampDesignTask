package com.enesay.bootcampdesigntask.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SayfaY(navController: NavController) {
    // Sayfa Y'den geri tuşuna basıldığında Ana Sayfaya direkt dönme
    BackHandler {
        navController.popBackStack("anasayfa", inclusive = false)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Sayfa Y", fontSize = 34.sp, modifier = Modifier.padding(22.dp))

        Text("Go to home")
    }
}