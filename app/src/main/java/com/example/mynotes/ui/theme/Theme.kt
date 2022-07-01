package com.example.mynotes.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = primaryColor,
    primaryVariant = primaryColor,
    secondary = blue,
    error = red,
    onBackground = backgroundColor
)

@Composable
fun MyNotesTheme(darkTheme: Boolean = true, content: @Composable () -> Unit) {
    MaterialTheme(
        colors = DarkColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}