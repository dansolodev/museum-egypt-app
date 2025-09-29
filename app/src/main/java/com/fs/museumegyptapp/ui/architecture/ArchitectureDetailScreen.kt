package com.fs.museumegyptapp.ui.architecture

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fs.museumegyptapp.R
import com.fs.museumegyptapp.model.ArchitectureSection
import com.fs.museumegyptapp.ui_kit.theme.MuseumEgyptAppTheme
import com.fs.museumegyptapp.ui_kit.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ArchitectureDetailScreen(
    item: ArchitectureSection,
    modifier: Modifier = Modifier
) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LargeTopAppBar(
                title = {
                    Text(
                        text = stringResource(id = item.title),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = Typography.displayLarge
                    )
                },
                scrollBehavior = scrollBehavior,
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    scrolledContainerColor = MaterialTheme.colorScheme.primary
                )
            )
            Image(
                painter = painterResource(id = item.cardImage),
                contentDescription = stringResource(id = item.title),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(with(LocalDensity.current) { scrollBehavior.state.heightOffset.toDp() + 180.dp })
                    .graphicsLayer {
                        alpha =
                            (1 - scrollBehavior.state.collapsedFraction) // Fade out as it collapses
                    },
                contentScale = ContentScale.Crop
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp, vertical = 16.dp)
                .verticalScroll(state = rememberScrollState())
        ) {
            Text(
                text = stringResource(id = item.content),
                style = Typography.titleMedium
            )
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun ArchitectureDetailScreenPreview() {
    MuseumEgyptAppTheme {
        ArchitectureDetailScreen(
            item = ArchitectureSection(
                id = 1,
                cardImage = R.drawable.mastabas,
                title = R.string.architecture_mastabas,
                content = R.string.architecture_mastabas_content
            )
        )
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun ArchitectureDetailScreenDarkPreview() {
    MuseumEgyptAppTheme {
        ArchitectureDetailScreen(
            item = ArchitectureSection(
                id = 1,
                cardImage = R.drawable.mastabas,
                title = R.string.architecture_mastabas,
                content = R.string.architecture_mastabas_content
            )
        )
    }
}