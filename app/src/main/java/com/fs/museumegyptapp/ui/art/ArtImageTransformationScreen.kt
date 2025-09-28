package com.fs.museumegyptapp.ui.art

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.fs.museumegyptapp.R
import com.fs.museumegyptapp.ui_kit.theme.MuseumEgyptAppTheme

@Composable
fun ArtImageTransformationScreen(
    @DrawableRes image: Int,
    modifier: Modifier = Modifier
) {

    // set up all transformation states
    var scale by remember { mutableFloatStateOf(value = 1f) }
    var rotation by remember { mutableFloatStateOf(value = 0f) }
    var offset by remember { mutableStateOf(value = Offset.Zero) }
    val state = rememberTransformableState { zoomChange, offsetChange, rotationChange ->
        scale *= zoomChange
        rotation += rotationChange
        offset += offsetChange
    }

    Image(
        painter = painterResource(id = image),
        contentDescription = null,
        modifier = modifier
            // apply other transformations like rotation and zoom
            // on the pizza slice emoji
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale,
                rotationZ = rotation,
                translationX = offset.x,
                translationY = offset.y
            )
            // add transformable to listen to multitouch transformation events
            // after offset
            .transformable(state = state)
            .background(color = Color.Black)
            .fillMaxSize(),
        contentScale = ContentScale.Crop
    )

}

@Preview
@Composable
private fun ArtImageTransformationScreenPreview() {
    MuseumEgyptAppTheme {
        ArtImageTransformationScreen(image = R.drawable.arte_escultura)
    }
}