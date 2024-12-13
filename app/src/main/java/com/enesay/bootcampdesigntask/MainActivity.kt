package com.enesay.bootcampdesigntask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enesay.bootcampdesigntask.ui.theme.BlackColor
import com.enesay.bootcampdesigntask.ui.theme.BootcampDesignTaskTheme
import com.enesay.bootcampdesigntask.ui.theme.LightBlue
import com.enesay.bootcampdesigntask.ui.theme.LightCoral
import com.enesay.bootcampdesigntask.ui.theme.LightGreen
import com.enesay.bootcampdesigntask.ui.theme.MainColor
import com.enesay.bootcampdesigntask.ui.theme.TextColor
import com.enesay.bootcampdesigntask.ui.theme.TextColorSecondary
import com.enesay.bootcampdesigntask.ui.theme.WhiteColor
import com.enesay.bootcampdesigntask.ui.theme.roboto

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BootcampDesignTaskTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = stringResource(R.string.app_name),
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = roboto
                                )
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MainColor,
                                titleContentColor = Color.White
                            )
                        )
                    }, modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    HomePage(innerPadding)
                }
            }
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
            .fillMaxSize()
            .padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.elevatedCardColors(
                    contentColor = TextColor,
                    containerColor = MainColor
                )
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = stringResource(R.string.yourProgress),
                        fontSize = (screenWidth / 13).sp,
                        fontWeight = FontWeight.Bold,
                        color = TextColor,
                        fontFamily = roboto
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Column {
                            Text(
                                text = stringResource(R.string.taskCompleted),
                                color = TextColor,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Start,
                                fontFamily = roboto
                            )
                            Text(
                                text = "12/20",
                                fontWeight = FontWeight.ExtraBold,
                                color = TextColorSecondary,
                                fontFamily = roboto
                            )
                        }
                        Column {
                            Text(
                                text = stringResource(R.string.timeSpent),
                                fontWeight = FontWeight.Bold,
                                color = TextColor,
                                textAlign = TextAlign.Start,
                                fontFamily = roboto
                            )
                            Text(
                                text = "10 hours",
                                fontWeight = FontWeight.ExtraBold,
                                color = TextColorSecondary,
                                fontFamily = roboto
                            )
                        }
                        Column {
                            Text(
                                text = stringResource(R.string.avgScore),
                                fontWeight = FontWeight.Bold,
                                color = TextColor,
                                textAlign = TextAlign.Start,
                                fontFamily = roboto
                            )
                            Text(
                                text = "85%",
                                fontWeight = FontWeight.ExtraBold,
                                color = TextColorSecondary,
                                fontFamily = roboto
                            )
                        }
                    }
                }
            }
            Column(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(vertical = 10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                TrainingItem(
                    step = stringResource(R.string.level) +
                            " 1",
                    description = stringResource(R.string.levelContent1),
                    backgroundColor = LightBlue,
                    isDarkMode
                )
                TrainingItem(
                    step = stringResource(R.string.level) + " 2",
                    description = stringResource(R.string.levelContent2),
                    backgroundColor = LightGreen,
                    isDarkMode
                )
                TrainingItem(
                    step = stringResource(R.string.level) + " 3",
                    description = stringResource(R.string.levelContent3),
                    backgroundColor = LightCoral,
                    isDarkMode
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
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = step,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = TextColor,
                        fontFamily = roboto
                    )
                    Text(
                        text = description,
                        fontSize = 14.sp,
                        color = TextColor,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        fontFamily = roboto
                    )
                }
                ElevatedButton(onClick = { /*TODO: Add action*/ }) {
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

@Preview(showBackground = true, locale = "tr")
@Composable
fun GreetingPreview() {
    BootcampDesignTaskTheme {
        HomePage(PaddingValues(16.dp))
    }
}