package com.arnold.cursocompose


import android.content.res.Resources.Theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.arnold.cursocompose.ui.theme.CursoComposeTheme
import com.arnold.cursocompose.ui.theme.UrbanistFontFamily
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){
    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate("LoginScreen"){
            popUpTo("SplashScreen"){inclusive = true}
        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.img_bienvenida),
            contentDescription = "null",
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier.fillMaxSize().padding(all = 20.dp)) {
                Text(text = "Bienvenido al\uD83D\uDC4B ",
                    fontFamily = UrbanistFontFamily,
                    fontSize = 40.sp,
                    color = Color.White)
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "Hotel Gran Palma",
                    fontFamily = UrbanistFontFamily,
                    color = Color(0xFF39E180),
                    fontSize = 48.sp,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "Las mejor estadia para ti",
                    fontFamily = UrbanistFontFamily,
                    fontSize = 40.sp,
                    color = Color.White)

            }
        }
    }
}