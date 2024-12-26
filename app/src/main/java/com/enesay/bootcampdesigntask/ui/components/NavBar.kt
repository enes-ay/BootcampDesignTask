package com.enesay.bootcampdesigntask.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enesay.bootcampdesigntask.R
import com.enesay.bootcampdesigntask.ui.theme.MainColor

@Composable
fun CustomBottomNavigationBar(
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    val items = listOf(
        "Anasayfa" to R.drawable.ic_alibaba,
        "İpuçları" to R.drawable.ic_vision,
        "Mesajlaşma" to R.drawable.ic_message,
        "Sepet" to R.drawable.ic_cart,
        "Alibabam" to R.drawable.ic_user
    )

    NavigationBar (
        modifier = Modifier.wrapContentSize(),
        containerColor = Color.White,
        contentColor = Color.Gray,
    ) {
        items.forEachIndexed { index, (label, icon) ->
            val isSelected = selectedIndex == index
            NavigationBarItem(
                icon = {
                    if(label == "Anasayfa"){
                       Image(painter = painterResource(id = icon),
                           contentDescription = label,
                           modifier = Modifier.size(30.dp))
                    }
                    else{
                        Icon(
                            painter = painterResource(id = icon),
                            contentDescription = label,
                            modifier = if (isSelected) Modifier.size(40.dp) else Modifier.size(24.dp),
                        )
                    }

                },
                label = {
                    Text(
                        text = label,
                        fontSize = if (isSelected) 13.sp else 11.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        color = if (isSelected) MainColor else Color.Gray
                    )
                },
                selected = selectedIndex == index,
                onClick = { onItemSelected(index) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFFFF6F00), // Alibaba orange
                    unselectedIconColor = Color.Gray,
                    selectedTextColor = MainColor,
                    indicatorColor = Color.Transparent
                ),

                )
        }
    }
}