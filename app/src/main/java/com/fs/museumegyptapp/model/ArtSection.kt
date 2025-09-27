package com.fs.museumegyptapp.model

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBalance
import androidx.compose.material.icons.outlined.Architecture
import androidx.compose.material.icons.outlined.CorporateFare
import androidx.compose.material.icons.outlined.Factory
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material.icons.outlined.Palette
import androidx.compose.ui.graphics.vector.ImageVector
import com.fs.museumegyptapp.R

data class ArtSection(
    @StringRes val title: Int,
    val icon: ImageVector,
)

val sectionsArt = listOf(
    ArtSection(
        title = R.string.art_monumental_arq,
        icon = Icons.Outlined.AccountBalance
    ),
    ArtSection(
        title = R.string.art_sculpture,
        icon = Icons.Outlined.Architecture
    ),
    ArtSection(
        title = R.string.art_mural,
        icon = Icons.Outlined.Image
    ),
    ArtSection(
        title = R.string.art_reliefs,
        icon = Icons.Outlined.Palette
    ),
    ArtSection(
        title = R.string.art_minor_arts,
        icon = Icons.Outlined.Factory
    )
)
