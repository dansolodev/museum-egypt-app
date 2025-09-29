package com.fs.museumegyptapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.fs.museumegyptapp.model.MuseumRoutes
import com.fs.museumegyptapp.model.sectionsArchitectureSection
import com.fs.museumegyptapp.ui.MainScreen
import com.fs.museumegyptapp.ui.architecture.ArchitectureDetailScreen
import com.fs.museumegyptapp.ui.architecture.ArchitectureScreen
import com.fs.museumegyptapp.ui.art.ArtImageTransformationScreen
import com.fs.museumegyptapp.ui.art.ArtScreen
import com.fs.museumegyptapp.ui.everydayLife.EverydayLifeScreen
import com.fs.museumegyptapp.ui_kit.theme.MuseumEgyptAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            MuseumEgyptAppTheme {
                NavHost(navController = navController, startDestination = MuseumRoutes.Home.route) {
                    composable(route = MuseumRoutes.Home.route) {
                        MainScreen(
                            onOptionSelected = {
                                navController.navigate(route = it)
                            }
                        )
                    }

                    composable(route = MuseumRoutes.EverydayLife.route) {
                        EverydayLifeScreen()
                    }

                    composable(route = MuseumRoutes.Architecture.route) {
                        ArchitectureScreen(
                            onArchitectureItemSelected = {
                                navController.navigate(
                                    route = MuseumRoutes.ArchitectureDetail.createRoute(id = it)
                                )
                            }
                        )
                    }

                    composable(route = MuseumRoutes.Art.route) {
                        ArtScreen(
                            onItemSelected = {
                                navController.navigate(
                                    route = MuseumRoutes.ArtTransformation.createRoute(
                                        image = it
                                    )
                                )
                            }
                        )
                    }

                    composable(
                        route = MuseumRoutes.ArtTransformation.route,
                        arguments = listOf(
                            navArgument(name = "image") { type = NavType.IntType }
                        )
                    ) { backStackEntry ->
                        backStackEntry.arguments?.getInt("image")?.let {
                            ArtImageTransformationScreen(image = it)
                        }
                    }

                    composable(
                        route = MuseumRoutes.ArchitectureDetail.route,
                        arguments = listOf(
                            navArgument(name = "id") { type = NavType.IntType }
                        )
                    ) { backStackEntry ->
                        val id = backStackEntry.arguments?.getInt("id") ?: -1
                        sectionsArchitectureSection.firstOrNull { it.id == id }?.let { item ->

                            ArchitectureDetailScreen(item = item)
                        }

                    }

                }
            }
        }
    }
}
