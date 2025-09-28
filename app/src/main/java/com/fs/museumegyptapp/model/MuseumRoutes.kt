package com.fs.museumegyptapp.model

import androidx.annotation.DrawableRes

sealed class MuseumRoutes(val route: String) {
    data object Home : MuseumRoutes(route = "home")
    data object EverydayLife : MuseumRoutes(route = "everyday_life")
    data object Architecture : MuseumRoutes(route = "architecture")
    data object Art : MuseumRoutes(route = "art")

    data object ArtTransformation : MuseumRoutes(route = "art_transformation/{image}") {
        fun createRoute(@DrawableRes image: Int) = "art_transformation/$image"
    }
}
