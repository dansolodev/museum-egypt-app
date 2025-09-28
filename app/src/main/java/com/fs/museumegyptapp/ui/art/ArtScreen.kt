package com.fs.museumegyptapp.ui.art

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.fs.museumegyptapp.model.sectionsArt
import com.fs.museumegyptapp.ui_kit.components.EgyptSimpleTextIcon
import com.fs.museumegyptapp.ui_kit.theme.MuseumEgyptAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ArtScreen(
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.art_label))
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(all = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(items = sectionsArt) { itemArt ->
                EgyptSimpleTextIcon(
                    icon = itemArt.icon,
                    textCardIdRes = itemArt.title,
                    onCardPressed = { onItemSelected(itemArt.image) }
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
private fun ArtScreenPreview() {
    MuseumEgyptAppTheme {
        ArtScreen(onItemSelected = {})
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun ArtScreenDarkPreview() {
    MuseumEgyptAppTheme {
        ArtScreen(onItemSelected = {})
    }
}
