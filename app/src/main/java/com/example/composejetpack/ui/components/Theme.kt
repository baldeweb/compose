package com.example.composejetpack.ui.components

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = purple200,
    primaryVariant = ice,
    secondary = teal200,
    background = softBlack,
)

private val LightColorPalette = lightColors(
    primary = purple500,
    primaryVariant = ice,
    secondary = teal200,
    background = Color.White,
    surface = Color.Black,
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
)
//
//@Composable
//fun JetpackComposeTheme(
//    darkTheme: Boolean,
//    content: @Composable () -> Unit
//) {
//    val colors = if (darkTheme) {
//        DarkColorPalette
//    } else {
//        LightColorPalette
//    }
//
//    MaterialTheme(
//
//        colors = colors,
//        typography = typography,
//        shapes = shapes,
//        content = content
//    )
//}