package com.fs.museumegyptapp.model

import androidx.annotation.DrawableRes
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
    @DrawableRes val image: Int
)

val sectionsArt = listOf(
    ArtSection(
        title = R.string.art_monumental_arq,
        icon = Icons.Outlined.AccountBalance,
        image = R.drawable.arte_arq_monumental
    ),
    ArtSection(
        title = R.string.art_sculpture,
        icon = Icons.Outlined.Architecture,
        image = R.drawable.arte_escultura
    ),
    ArtSection(
        title = R.string.art_mural,
        icon = Icons.Outlined.Image,
        image = R.drawable.arte_pintura_mural
    ),
    ArtSection(
        title = R.string.art_reliefs,
        icon = Icons.Outlined.Palette,
        image = R.drawable.arte_relieve
    ),
    ArtSection(
        title = R.string.art_minor_arts,
        icon = Icons.Outlined.Factory,
        image = R.drawable.arte_orfebreria
    )
)
