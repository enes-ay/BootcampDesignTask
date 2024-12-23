package com.enesay.bootcampdesigntask.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

//@Composable
//fun CustomBottomNavigationBar() {
//    BottomNavigation(
//        backgroundColor = Color.White,
//        elevation = 8.dp
//    ) {
//        val navItems = listOf(
//            NavItem("Anasayfa", R.drawable.ic_home, isSelected = true),
//            NavItem("İpuçları", R.drawable.ic_tips, isSelected = false),
//            NavItem("Mesajlaşma", R.drawable.ic_message, isSelected = false),
//            NavItem("Sepet", R.drawable.ic_cart, isSelected = false),
//            NavItem("Alibabam", R.drawable.ic_user, isSelected = false)
//        )
//
//        navItems.forEach { item ->
//            BottomNavigationItem(
//                icon = {
//                    Icon(
//                        painter = painterResource(id = item.iconRes),
//                        contentDescription = item.label,
//                        tint = if (item.isSelected) Color(0xFFFF6A00) else Color.Gray
//                    )
//                },
//                label = {
//                    Text(
//                        text = item.label,
//                        color = if (item.isSelected) Color(0xFFFF6A00) else Color.Gray,
//                        fontSize = 12.sp
//                    )
//                },
//                selected = item.isSelected,
//                onClick = { /* TODO: Implement navigation logic */ },
//                selectedContentColor = Color(0xFFFF6A00),
//                unselectedContentColor = Color.Gray
//            )
//        }
//    }
//}

data class NavItem(
    val label: String,
    val iconRes: Int,
    val isSelected: Boolean
)
