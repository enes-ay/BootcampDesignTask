package com.enesay.bootcampdesigntask

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enesay.bootcampdesigntask.ui.theme.GrayBackground

@Composable
fun AliBabaHomePage() {
    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(GrayBackground),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            //TabLayout()
            val pages = listOf("Ürünler", "Üreticiler", "Bölgesel malzemeleri")
            val category_tabs =
                listOf("Hepsi", "Tüketici Elektroniği", "İnşaat ve Gayrimenkul", "Ev Aletleri")
            Column {
                CustomTabLayout(pages)
                SearchBar()
            }
            CategoryTabLayout(category_tabs)
            FlashDealsLazyRow("Flash Deals", "En iyi tekliflerle bir adım önde olun")
            FlashDealsLazyRow("Yeni Gelenler", "Alibaba.com'da en düşük fiyatları kapın")
            // Navbar()
        }
    }
}

@Composable
fun FlashDealItem(
    extra: String = "",
    isShowFlashDeal: Boolean = false
) {
    Column(
        modifier = Modifier
            .width(150.dp) // Item genişliği
            .padding(8.dp)
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            //.border(1.dp, Color.LightGray, shape = RoundedCornerShape(8.dp))
    ) {
        // Üst kısım: "Flaş Teklif" etiketi
      if (isShowFlashDeal){
          Box(
              modifier = Modifier
                  .wrapContentWidth()
                  .clip(
                      RoundedCornerShape(
                          topStart = 8.dp, // Sol üst köşe radius
                          topEnd = 0.dp,   // Sağ üst köşe radius
                          bottomStart = 0.dp, // Sol alt köşe radius
                          bottomEnd = 8.dp  // Sağ alt köşe radius
                      )
                  )
                  .background(Color(0xFFFF6D00)) // Turuncu arka plan
                  .padding(horizontal = 8.dp, vertical = 4.dp),
              contentAlignment = Alignment.Center
          ) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                  Icon(
                      imageVector = Icons.Filled.KeyboardArrowLeft, // Şimşek ikonu (Material Icon)
                      contentDescription = "Flash Icon",
                      tint = Color.White, // İkon rengi
                      modifier = Modifier.size(16.dp) // İkon boyutu
                  )
                  Spacer(modifier = Modifier.width(2.dp)) // İkon ile yazı arasında boşluk
                  Text(
                      text = "Flaş Teklif",
                      color = Color.White,
                      style = MaterialTheme.typography.bodySmall,
                      fontWeight = FontWeight.Bold
                  )
              }
          }


      }

        // Görsel
        Image(
            painter = painterResource(id = R.drawable.growth), // Örnek resim
            contentDescription = "Ürün Görseli",
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(8.dp),
            contentScale = ContentScale.Crop
        )

        // Fiyat ve İndirim Bilgisi
        Column(modifier = Modifier.padding(horizontal = 8.dp)) {
            Text(
                text = "₺21,58",
                color = Color.Red,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = extra,
                color = Color.Black,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
fun FlashDealsLazyRow(title: String, description: String) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .background(Color.White)
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    title,
                    modifier = Modifier.padding(start = 15.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    description,
                    modifier = Modifier.padding(start = 15.dp),
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }
            Column(modifier = Modifier.padding(end = 6.dp)) {
                Icon(Icons.Default.ArrowForward, contentDescription = "right icon")
            }
        }
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 8.dp)
        ) {
            items(2) { // 10 örnek ürün
                FlashDealItem(extra = "Ekstra %10 indirim", isShowFlashDeal = true)
            }
            items(2) {
                FlashDealItem(extra = "180 günün en düşük fiyatı")
            }
        }
    }
}


@Composable
fun CustomTabLayout(tabs: List<String> = listOf()) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color(0xFFFF6D00)), // Arka plan rengi
        horizontalArrangement = Arrangement.Start // Sola yaslama
    ) {
        tabs.forEachIndexed { index, title ->
            Text(
                text = title,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp) // Kenar boşlukları
                    .clickable { selectedTabIndex = index } // Tıklama davranışı
                    .drawBehind {
                        if (selectedTabIndex == index) {
                            val lineWidth = size.width
                            val lineHeight = 2.5.dp.toPx() // Çizgi kalınlığı
                            val lineSpacing = 4.dp.toPx() // Çizgi ile yazı arasındaki boşluk
                            drawLine(
                                color = Color.White,
                                start = Offset(0f, size.height + lineSpacing),
                                end = Offset(lineWidth, size.height + lineSpacing),
                                strokeWidth = lineHeight
                            )
                        }
                    },
                color = if (selectedTabIndex == index) Color.White else Color.LightGray,
                style = if (selectedTabIndex == index) {
                    TextStyle(fontWeight = FontWeight.Bold) // Seçili sekme kalın yazı
                } else {
                    TextStyle(fontWeight = FontWeight.Normal)
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFF6D00)) // Turuncu arka plan
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(30.dp)) // Beyaz oval arka plan
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Arama metni
            TextField(
                value = "",
                onValueChange = {},
                placeholder = {
                    Text(
                        text = "Ürün veya tedarikçi arayın",
                        color = Color.Black,
                        style = MaterialTheme.typography.bodyMedium
                    )
                },
                modifier = Modifier
                    .weight(1f) // Metin alanı için kalan boşluğu kullan
                    .padding(end = 8.dp), // Sağ kenardan boşluk
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    cursorColor = Color.Black,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            // Kamera ikonu
            Icon(
                imageVector = Icons.Outlined.LocationOn,
                contentDescription = "Kamera",
                tint = Color.Black,
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 8.dp)
                    .clickable { /* Kamera açılma işlemi */ }
            )

            // Arama ikonu
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Arama",
                tint = Color.Black,
                modifier = Modifier
                    .size(24.dp)
                    .clickable { /* Arama işlemi */ }
            )
        }
    }
}

@Composable
fun CategoryTabLayout(tabs: List<String> = listOf()) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(GrayBackground), // Arka plan rengi
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically// Sola yaslama
    ) {
        tabs.forEachIndexed { index, title ->
            Text(
                text = title,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp) // Kenar boşlukları
                    .clickable { selectedTabIndex = index }, // Tıklama davranışı
                color = if (selectedTabIndex == index) Color.Black else Color.Gray,
                style = TextStyle(fontWeight = FontWeight.Bold) // Seçili sekme kalın yazı

            )
        }
    }
}
