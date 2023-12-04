package com.avility.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Badge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.avility.domain.model.ConditionProduct
import com.avility.domain.model.ProductModel
import com.avility.shared.extensions.toCurrency
import com.avility.shared.ui.components.containers.BaseRowItem
import com.avility.shared.ui.components.images.RemoteImage
import com.avility.shared.ui.constants.MeasureLargeDimen
import com.avility.shared.ui.constants.MeasureSmallDimen
import com.avility.shared.ui.constants.green200
import com.avility.shared.ui.constants.green800
import com.avility.shared.ui.constants.orange200
import com.avility.shared.ui.constants.orange800
import com.avility.shared.ui.constants.roundedShapes
import com.avility.shared.ui.styles.DimensionParams

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductItem(
    productModel: ProductModel,
    onTap: () -> Unit = {}
) {
    BaseRowItem(
        leading = {
            Box(
                modifier = Modifier.size(
                    MeasureLargeDimen.DIMEN_X15.value
                )
            ) {
                RemoteImage(
                    url = productModel.thumbnail,
                    contentScale = ContentScale.Fit
                )
            }
        },
        trailing = {
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = MeasureSmallDimen.DIMEN_X04.value),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = productModel.title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Medium
                    )
                )
                Spacer(modifier = Modifier.height(MeasureSmallDimen.DIMEN_X04.value))
                Text(
                    text = productModel.price.toCurrency(),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyMedium
                )
                Badge(
                    modifier = Modifier.clip(roundedShapes.small),
                    containerColor = if(productModel.condition is ConditionProduct.New) {
                        green200
                    } else {
                        orange200
                    },
                    contentColor = if(productModel.condition is ConditionProduct.New) {
                        green800
                    } else {
                        orange800
                    }
                ) {
                    Text(
                        productModel.condition.value,
                        style = MaterialTheme.typography.labelSmall,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(2.dp)
                    )
                }
            }
        },
        dimensionParams = DimensionParams(
            width = null,
            height = MeasureLargeDimen.DIMEN_X15.value
        ),
        onTap = onTap
    )
}

@Composable
@Preview
fun ProductItemPreview() {
    ProductItem(
        ProductModel(
            id = "1",
            title = "Iphone XR ",
            price = 5,
            availableQuantity = 1,
            condition = ConditionProduct.Used,
            thumbnail = ""
        )
    )
}