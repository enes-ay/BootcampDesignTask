package com.enesay.bootcampdesigntask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enesay.bootcampdesigntask.ui.NavTaskApp
import com.enesay.bootcampdesigntask.ui.theme.BlackColor
import com.enesay.bootcampdesigntask.ui.theme.BootcampDesignTaskTheme
import com.enesay.bootcampdesigntask.ui.theme.GrayBorder
import com.enesay.bootcampdesigntask.ui.theme.LightBlue
import com.enesay.bootcampdesigntask.ui.theme.LightCoral
import com.enesay.bootcampdesigntask.ui.theme.LightGreen
import com.enesay.bootcampdesigntask.ui.theme.MainColor
import com.enesay.bootcampdesigntask.ui.theme.TextColor
import com.enesay.bootcampdesigntask.ui.theme.TextColorSecondary
import com.enesay.bootcampdesigntask.ui.theme.WhiteColor
import com.enesay.bootcampdesigntask.ui.theme.roboto

class MainActivity : ComponentActivity(){
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AliBabaHomePage()
        }
    }
}

@Composable
fun HomePage(innerPadding: PaddingValues) {
    val isDarkMode = isSystemInDarkTheme()
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp
    val screenWidth = configuration.screenWidthDp

    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(innerPadding),
    ) {
        LazyRow (modifier = Modifier.fillMaxWidth()) {
            items(2){
                CardItem(screenWidth)
            }
        }
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                text = stringResource(R.string.recommadationList), textAlign = TextAlign.Start,
                fontSize = 20.sp, fontWeight = FontWeight.Bold, fontFamily = roboto
            )

            Column(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(vertical = 5.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                TrainingItem(
                    step = stringResource(R.string.level) +
                            " 1",
                    description = stringResource(R.string.levelContent1),
                    backgroundColor = WhiteColor,
                    isDarkMode
                )
                TrainingItem(
                    step = stringResource(R.string.level) + " 2",
                    description = stringResource(R.string.levelContent2),
                    backgroundColor = WhiteColor,
                    isDarkMode
                )
                TrainingItem(
                    step = stringResource(R.string.level) + " 3",
                    description = stringResource(R.string.levelContent3),
                    backgroundColor = WhiteColor,
                    isDarkMode
                )
            }
        }
}

@Composable
fun CardItem(screenWidth: Int) {
    Card(
        modifier = Modifier.size(280.dp, 240.dp).padding(5.dp),
        colors = CardDefaults.elevatedCardColors(
            contentColor = TextColor,
            containerColor = WhiteColor
        ),
        border = BorderStroke(2.dp, GrayBorder)
    ) {
        Column(
            modifier = Modifier.padding(15.dp).fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            Image(
                modifier = Modifier.size(200.dp, 70.dp),
                painter = painterResource(R.drawable.growth
                ),
                contentDescription = "image",
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.yourProgress),
                    fontSize = (screenWidth / 20).sp,
                    fontWeight = FontWeight.Bold,
                    color = BlackColor,
                    fontFamily = roboto
                )
                IconButton(onClick = {}) {
                    Icon(Icons.Default.Favorite, "")
                }

            }
            Text(
                text = stringResource(R.string.taskCompleted),
                color = BlackColor,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                fontFamily = roboto
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.taskCompleted),
                    color = BlackColor,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    fontFamily = roboto
                )
                Text(
                    text = "asfasfasf",
                    fontWeight = FontWeight.ExtraBold,
                    color = TextColorSecondary,
                    fontFamily = roboto
                )
            }
        }
    }
}

@Composable
fun TrainingItem(step: String, description: String, backgroundColor: Color, isDarkMode: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            color = backgroundColor,
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxSize(),
            border = BorderStroke(2.dp, GrayBorder)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp, vertical = 2.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(5.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(painter = painterResource(R.drawable.app_icon_foreground), "place image")
                }
                Column(
                    modifier = Modifier
                        .weight(2f)
                        .padding(5.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = step,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = BlackColor,
                        fontFamily = roboto
                    )
                    Spacer(Modifier.size(5.dp))
                    Text(
                        text = description,
                        fontSize = 17.sp,
                        color = BlackColor,
                        fontWeight = FontWeight.Light,
                        textAlign = TextAlign.Start,
                        fontFamily = roboto
                    )
                }
                ElevatedButton(modifier = Modifier.weight(1f), onClick = { /*TODO: Add action*/ }) {
                    Text(
                        text = stringResource(R.string.start),
                        color = if (isDarkMode) WhiteColor else BlackColor,
                        fontWeight = FontWeight.Bold,
                        fontFamily = roboto
                    )
                }
            }
        }
    }
}

@Composable
fun BottomBar() {

    val items = listOf(
        Screens.Home,
        Screens.Profile,
        Screens.Favorites,
    )
    NavigationBar(
        modifier = Modifier.border(
            BorderStroke(1.dp, Color.Gray.copy(alpha = 0.2f)), // Şeffaf bir gri sınır
            shape = CutCornerShape(
                topStart = 0.dp,
                topEnd = 0.dp,
                bottomEnd = 0.dp,
                bottomStart = 0.dp
            ) // Sadece üst kenarda sınır
        ),
        containerColor = Color.White,
        contentColor = Color.Black,

        ) {

        items.forEach { item ->
            NavigationBarItem(
                onClick = {},
                selected = true,
                icon = {
                    Icon(item.icon, contentDescription = stringResource(id = item.labelResId))
                },
                label = {
                    Text(
                        text = stringResource(id = item.labelResId),
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MainColor,
                    selectedTextColor = MainColor,
                    indicatorColor = Color.Transparent
                )
            )
        }

    }
}

@Preview(showBackground = true, locale = "tr")
@Composable
fun GreetingPreview() {
    BootcampDesignTaskTheme {
        HomePage(PaddingValues(16.dp))
    }
}