package com.fs.museumegyptapp.model

sealed class MuseumRoutes(route: String) {
    data object EverydayLife : MuseumRoutes(route = "everyday_life")
    data object Architecture : MuseumRoutes(route = "architecture")
    data object Art : MuseumRoutes(route = "art")
}
