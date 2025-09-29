package com.fs.museumegyptapp.ui.architecture

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.OndemandVideo
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fs.museumegyptapp.R
import com.fs.museumegyptapp.model.sectionsArchitectureSection
import com.fs.museumegyptapp.ui_kit.components.EgyptSquareCard
import com.fs.museumegyptapp.ui_kit.components.PrimaryIconButton
import com.fs.museumegyptapp.ui_kit.theme.MuseumEgyptAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ArchitectureScreen(
    onArchitectureItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.architecture_label))
                }
            )
        },
        bottomBar = {
            PrimaryIconButton(
                text = stringResource(id = R.string.architecture_btn),
                onClick = {

                },
                icon = Icons.Default.OndemandVideo,
                modifier = Modifier.padding(16.dp),
                iconContentDescription = stringResource(id = R.string.architecture_btn)
            )
        }
    ) { innerPadding ->
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(count = 2),
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalItemSpacing = 16.dp
        ) {
            items(items = sectionsArchitectureSection) { architectureItem ->
                EgyptSquareCard(
                    cardImageIdRed = architectureItem.cardImage,
                    textCardIdRes = architectureItem.title,
                    onCardPressed = { onArchitectureItemSelected(architectureItem.id) },
                    modifier = Modifier.height(height = 140.dp),
                    cardImageContentDescription = stringResource(id = architectureItem.title)
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun ArchitectureScreenPreview() {
    MuseumEgyptAppTheme {
        ArchitectureScreen(onArchitectureItemSelected = {})
    }
}


@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun ArchitectureScreenDarkPreview() {
    MuseumEgyptAppTheme {
        ArchitectureScreen(onArchitectureItemSelected = {})
    }
}