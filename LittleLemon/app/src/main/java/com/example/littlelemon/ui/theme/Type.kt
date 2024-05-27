package com.example.littlelemon.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.littlelemon.R

val karla = FontFamily(Font(R.font.karla_regular))
val markazi = FontFamily(Font(R.font.markazi_text_regular))

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = karla, fontWeight = FontWeight.Normal, fontSize = 16.sp
    ),

    h1 = TextStyle(
        fontFamily = markazi, fontWeight = FontWeight.Bold, fontSize = 48.sp
    ),

    h3 = TextStyle(
        fontFamily = karla, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = PrimaryGreen
    ),
)