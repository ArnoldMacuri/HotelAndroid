package com.arnold.cursocompose.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.arnold.cursocompose.R

// Set of Material typography styles to start with
val UrbanistFontFamily = FontFamily(
    Font(R.font.urbanist_bold, FontWeight.Bold),
    Font(R.font.urbanist_medium,FontWeight.Medium),
    Font(R.font.urbanist_regular,FontWeight.Normal),
    Font(R.font.urbanist_semibold,FontWeight.SemiBold)
    )

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = UrbanistFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = UrbanistFontFamily,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = UrbanistFontFamily,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)