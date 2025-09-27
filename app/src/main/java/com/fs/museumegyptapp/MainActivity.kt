package com.fs.museumegyptapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.fs.museumegyptapp.ui.MainScreen
import com.fs.museumegyptapp.ui_kit.theme.MuseumEgyptAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MuseumEgyptAppTheme {
                MainScreen()
            }
        }
    }
}
