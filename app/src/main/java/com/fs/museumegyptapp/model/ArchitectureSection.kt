package com.fs.museumegyptapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.fs.museumegyptapp.R

data class ArchitectureSection(
    @DrawableRes val cardImage: Int,
    @StringRes val title: Int
)

val sectionsArchitectureSection = listOf(
    ArchitectureSection(
        cardImage = R.drawable.mastabas,
        title = R.string.architecture_mastabas
    ),
    ArchitectureSection(
        cardImage = R.drawable.piramides,
        title = R.string.architecture_pyramids
    ),
    ArchitectureSection(
        cardImage = R.drawable.obelisco,
        title = R.string.architecture_obelisk
    ),
    ArchitectureSection(
        cardImage = R.drawable.templo,
        title = R.string.architecture_temple
    ),
    ArchitectureSection(
        cardImage = R.drawable.contrucciones,
        title = R.string.architecture_constructions
    )
)
