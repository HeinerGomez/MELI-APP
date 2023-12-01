package com.avility.shared.ui.components.images

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import com.avility.shared.ui.components.containers.BasicContainer
import com.avility.shared.ui.constants.MeasureSmallDimen

@Composable
fun RemoteImage(
    url: String,
    contentScale: ContentScale = ContentScale.Crop,
) {
    return Image(
        painter = rememberAsyncImagePainter(
            model = url
        ),
        contentDescription = "",
        modifier = Modifier.fillMaxSize(),
        contentScale = contentScale
    )
}

@Composable
@Preview
fun RemoteImagePreview() {
    BasicContainer(
        modifier = Modifier.size(MeasureSmallDimen.DIMEN_X49.value),
    ) {
        RemoteImage(
            url = "https://images.pexels.com/photos/417074/pexels-photo-417074.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            contentScale = ContentScale.Fit
        )
    }
}