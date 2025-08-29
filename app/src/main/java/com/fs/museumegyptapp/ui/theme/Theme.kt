package com.fs.museumegyptapp.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = Gold80,
    onPrimary = BlackEgypt,
    primaryContainer = GoldContainer,
    onPrimaryContainer = Gold20,
    secondary = Turquoise80,
    onSecondary = BlackEgypt,
    secondaryContainer = TurquoiseContainer,
    onSecondaryContainer = Turquoise20,
    tertiary = Terracotta80,
    onTertiary = SandSurface,
    tertiaryContainer = TerracottaContainer,
    onTertiaryContainer = Terracotta20,
    background = SandBackground,
    onBackground = BlackEgypt,
    surface = SandSurface,
    onSurface = BlackEgypt,
    error = ErrorRed,
    onError = ErrorOnRed,
    outline = OutlineSand
)

private val DarkColorScheme = darkColorScheme(
    primary = GoldDark80,
    onPrimary = BlackEgypt,
    primaryContainer = GoldDarkContainer,
    onPrimaryContainer = GoldDark20,
    secondary = TurquoiseDark80,
    onSecondary = WhiteEgypt,
    secondaryContainer = TurquoiseDarkContainer,
    onSecondaryContainer = TurquoiseDark20,
    tertiary = TerracottaDark80,
    onTertiary = WhiteEgypt,
    tertiaryContainer = TerracottaDarkContainer,
    onTertiaryContainer = TerracottaDark20,
    background = SandDarkBackground,
    onBackground = WhiteEgypt,
    surface = SandDarkSurface,
    onSurface = WhiteEgypt,
    error = ErrorDarkRed,
    onError = BlackEgypt,
    outline = OutlineGold
)

@Composable
fun MuseumEgyptAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}