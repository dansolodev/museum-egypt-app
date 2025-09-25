package com.fs.museumegyptapp.ui_kit.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import com.fs.museumegyptapp.R
import com.fs.museumegyptapp.ui_kit.theme.MuseumEgyptAppTheme
import com.fs.museumegyptapp.ui_kit.theme.Typography

@Composable
fun EgyptSquareCard(
    @DrawableRes cardImageIdRed: Int,
    @StringRes textCardIdRes: Int,
    onCardPressed: () -> Unit,
    modifier: Modifier = Modifier,
    cardImageContentDescription: String? = null
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onCardPressed() },
        shape = RoundedCornerShape(topEnd = 24.dp, bottomStart = 24.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = cardImageIdRed),
                contentDescription = cardImageContentDescription,
                modifier = Modifier.weight(0.7f),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = textCardIdRes),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .weight(0.3f),
                style = Typography.titleLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
private fun EgyptSquareCardPreview() {
    MuseumEgyptAppTheme {
        EgyptSquareCard(
            cardImageIdRed = R.drawable.mastabas,
            textCardIdRes = R.string.art_label,
            onCardPressed = {}
        )
    }
}