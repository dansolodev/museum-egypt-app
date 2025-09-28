package com.fs.museumegyptapp.model

sealed class MuseumRoutes(val route: String) {
    data object Home : MuseumRoutes(route = "home")
    data object EverydayLife : MuseumRoutes(route = "everyday_life")
    data object Architecture : MuseumRoutes(route = "architecture")
    data object Art : MuseumRoutes(route = "art")
}
