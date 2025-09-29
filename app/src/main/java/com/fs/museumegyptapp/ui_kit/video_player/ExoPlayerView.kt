package com.fs.museumegyptapp.ui_kit.video_player

import androidx.annotation.OptIn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.core.net.toUri
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.exoplayer.hls.HlsMediaSource

private const val M3U8_URL =
    "https://devstreaming-cdn.apple.com/videos/streaming/examples/adv_dv_atmos/main.m3u8"

@Composable
internal fun ExoPlayerView(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val exoPlayer = ExoPlayer.Builder(context).build()
    val mediaSource: MediaItem = buildMediaSource(url = M3U8_URL)

    LaunchedEffect(mediaSource) {
        exoPlayer.setMediaItem(mediaSource, false)
        exoPlayer.prepare()
    }
    DisposableEffect(Unit) {
        onDispose { exoPlayer.release() }
    }

    AndroidView(
        factory = { ctx ->
            PlayerView(ctx).apply {
                player = exoPlayer
            }
        },
        modifier = modifier.fillMaxSize()
    )
}

@OptIn(UnstableApi::class)
private fun buildMediaSource(url: String): MediaItem {
    val uri = url.toUri()
    return HlsMediaSource.Factory(DefaultHttpDataSource.Factory())
        .createMediaSource(MediaItem.fromUri(uri)).mediaItem
}
