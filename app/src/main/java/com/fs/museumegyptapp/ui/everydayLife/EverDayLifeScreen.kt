package com.fs.museumegyptapp.ui.everydayLife

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.OndemandVideo
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fs.museumegyptapp.R
import com.fs.museumegyptapp.model.sectionsEveryDayLife
import com.fs.museumegyptapp.ui_kit.components.EgyptBodyText
import com.fs.museumegyptapp.ui_kit.components.EgyptTitleText
import com.fs.museumegyptapp.ui_kit.components.PrimaryIconButton
import com.fs.museumegyptapp.ui_kit.theme.MuseumEgyptAppTheme
import com.fs.museumegyptapp.ui_kit.theme.OutlineGold

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun EverydayLifeScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            PrimaryIconButton(
                text = stringResource(id = R.string.everyday_life_btn),
                onClick = {},
                icon = Icons.Default.OndemandVideo,
                modifier = Modifier.padding(16.dp),
                iconContentDescription = stringResource(id = R.string.everyday_life_btn)
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            sectionsEveryDayLife.forEach { section ->
                stickyHeader {
                    EgyptTitleText(
                        textIdRes = section.header,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = MaterialTheme.colorScheme.primaryContainer)
                    )
                }

                itemsIndexed(section.sections) { index, item ->
                    EgyptBodyText(textIdRes = item)
                    if (index != sectionsEveryDayLife.size - 1) {
                        HorizontalDivider(thickness = 2.dp, color = OutlineGold)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun EverydayLifeScreenPreview() {
    MuseumEgyptAppTheme {
        EverydayLifeScreen()
    }
}