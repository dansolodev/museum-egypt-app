package com.fs.museumegyptapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.fs.museumegyptapp.R

data class ArchitectureSection(
    val id: Int,
    @DrawableRes val cardImage: Int,
    @StringRes val title: Int,
    @StringRes val content: Int
)

val sectionsArchitectureSection = listOf(
    ArchitectureSection(
        id = 1,
        cardImage = R.drawable.mastabas,
        title = R.string.architecture_mastabas,
        content = R.string.architecture_mastabas_content
    ),
    ArchitectureSection(
        id = 2,
        cardImage = R.drawable.piramides,
        title = R.string.architecture_pyramids,
        content = R.string.architecture_pyramids_content
    ),
    ArchitectureSection(
        id = 3,
        cardImage = R.drawable.obelisco,
        title = R.string.architecture_obelisk,
        content = R.string.architecture_obelisk_content
    ),
    ArchitectureSection(
        id = 4,
        cardImage = R.drawable.templo,
        title = R.string.architecture_temple,
        content = R.string.architecture_temple_content
    ),
    ArchitectureSection(
        id = 5,
        cardImage = R.drawable.contrucciones,
        title = R.string.architecture_constructions,
        content = R.string.architecture_constructions_content
    )
)
