package com.avility.shared.ui.components.containers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.avility.shared.ui.constants.MeasureSmallDimen
import com.avility.shared.ui.constants.roundedShapes
import com.avility.shared.ui.styles.DimensionParams

@Composable
fun BaseRowItem(
    leading: @Composable () -> Unit,
    trailing: (@Composable () -> Unit)? = null,
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.SpaceBetween,
    roundedCornerShape: CornerBasedShape = roundedShapes.medium,
    leadingWeight: Float = 0.4f,
    trailingWeight: Float = 0.6f,
    dimensionParams: DimensionParams = DimensionParams(null, MeasureSmallDimen.DIMEN_X36.value),
    onTap: () -> Unit = {}
) {

    return BasicContainer(
        modifier = Modifier
            .let { modifier ->
                dimensionParams.width?.let { modifier.width(it) } ?: Modifier
                    .fillMaxWidth()
            }
            .height(dimensionParams.height),
        roundedCornerShape = roundedCornerShape,
        containerColor = containerColor,
        onTap = onTap
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(MeasureSmallDimen.DIMEN_X04.value),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = horizontalArrangement
        ) {
            Row(
                modifier = Modifier.weight(leadingWeight)
            ) {
                leading()
            }
            trailing?.let {
                Row(
                    modifier = Modifier.weight(trailingWeight),
                    horizontalArrangement = Arrangement.End
                ) {
                    it()
                }
            }
        }
    }
}

@Composable
@Preview
fun BaseRowItemPreview() {
    BaseRowItem(
        leading = {
            Text(
                text = "Preview Test",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleLarge
            )
        },
    )
}