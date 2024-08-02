package com.arnold.cursocompose.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.platform.LocalContext


@Composable
fun CursoComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> darkColorScheme(
            primary = LocalHotelColorSchema.current.dark1,
            secondary = LocalHotelColorSchema.current.secundario1,
            background = LocalHotelColorSchema.current.dark2
        )
        else -> lightColorScheme(
            primary = LocalHotelColorSchema.current.primario1,
            secondary = LocalHotelColorSchema.current.secundario1,
            background = LocalHotelColorSchema.current.white
        )
    }
    CompositionLocalProvider(LocalHotelColorSchema provides hotelColorSchema) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }

}
