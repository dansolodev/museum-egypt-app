package com.fs.museumegyptapp.ui_kit.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.fs.museumegyptapp.R
import com.fs.museumegyptapp.ui_kit.theme.MuseumEgyptAppTheme
import com.fs.museumegyptapp.ui_kit.theme.Typography

@Composable
fun EgyptSquareCard(
    @DrawableRes cardImageIdRed: Int,
    @StringRes textCardIdRes: Int,
    modifier: Modifier = Modifier,
    cardImageContentDescription: String? = null
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = cardImageIdRed),
            contentDescription = cardImageContentDescription,
            contentScale = ContentScale.Crop
        )
        Text(
            text = stringResource(id = textCardIdRes),
            modifier = Modifier.fillMaxWidth(),
            style = Typography.titleLarge,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
private fun EgyptSquareCardPreview() {
    MuseumEgyptAppTheme {
        EgyptSquareCard(
            cardImageIdRed = R.drawable.mastabas,
            textCardIdRes = R.string.art_label
        )
    }
}