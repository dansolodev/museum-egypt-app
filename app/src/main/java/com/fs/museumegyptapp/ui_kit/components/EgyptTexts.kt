package com.fs.museumegyptapp.ui_kit.components

import androidx.annotation.StringRes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.fs.museumegyptapp.R
import com.fs.museumegyptapp.ui_kit.theme.MuseumEgyptAppTheme
import com.fs.museumegyptapp.ui_kit.theme.Typography

@Composable
internal fun EgyptTitleText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        modifier = modifier,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        style = Typography.displayMedium
    )
}

@Composable
internal fun EgyptTitleText(
    @StringRes textIdRes: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(id = textIdRes),
        modifier = modifier,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        style = Typography.displayMedium
    )
}

@Preview(showBackground = true)
@Composable
private fun EgyptTitleTextPreview() {
    MuseumEgyptAppTheme {
        EgyptTitleText(textIdRes = R.string.app_name)
    }
}

@Composable
internal fun EgyptBodyText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(text = text, modifier = modifier, style = Typography.bodyMedium)
}

@Composable
internal fun EgyptBodyText(
    @StringRes textIdRes: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(id = textIdRes),
        modifier = modifier,
        style = Typography.bodyMedium
    )
}

@Preview(showBackground = true)
@Composable
private fun EgyptBodyTextPreview() {
    MuseumEgyptAppTheme {
        EgyptBodyText(
            textIdRes = R.string.app_name
        )
    }
}
