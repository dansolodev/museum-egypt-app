package com.fs.museumegyptapp.model

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBalance
import androidx.compose.material.icons.outlined.Palette
import androidx.compose.material.icons.outlined.People
import androidx.compose.ui.graphics.vector.ImageVector
import com.fs.museumegyptapp.R

data class MuseumSection(
    val routes: MuseumRoutes,
    @StringRes val titleSection: Int,
    val icon: ImageVector
)

val museumOptions = listOf(
    MuseumSection(
        routes = MuseumRoutes.EverydayLife,
        titleSection = R.string.everyday_life_label,
        icon = Icons.Outlined.People
    ),
    MuseumSection(
        routes = MuseumRoutes.Architecture,
        titleSection = R.string.architecture_label,
        icon = Icons.Outlined.AccountBalance
    ),
    MuseumSection(
        routes = MuseumRoutes.Art,
        titleSection = R.string.art_label,
        icon = Icons.Outlined.Palette
    )
)