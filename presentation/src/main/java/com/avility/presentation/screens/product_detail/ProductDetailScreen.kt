package com.avility.presentation.screens.product_detail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.rounded.MilitaryTech
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.avility.domain.model.DetailProductModel
import com.avility.domain.model.SellerModel
import com.avility.presentation.R
import com.avility.shared.R as SharedResource
import com.avility.shared.extensions.toCurrency
import com.avility.shared.ui.components.containers.BaseRowItem
import com.avility.shared.ui.components.containers.MainContainer
import com.avility.shared.ui.components.images.RemoteImage
import com.avility.shared.ui.components.others.LottieInfoScreen
import com.avility.shared.ui.constants.MeasureLargeDimen
import com.avility.shared.ui.constants.MeasureSmallDimen
import com.avility.shared.ui.constants.gray400
import com.avility.shared.ui.constants.gray50
import com.avility.shared.ui.styles.DimensionParams

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    navController: NavController,
    viewModel: ProductDetailViewModel = hiltViewModel()
) {
    val state = viewModel.uiState.value
    MainContainer(
        isLoading = state.isLoading,
        header = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
            )
        },
        headerPadding = false,
        headerColor = Color.Transparent
    ) {
        if (!state.isLoading && state.errorMessage == null) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.primaryContainer)
            ) {
                item {
                    BodyContent(state.product)
                }

                item {
                    HorizontalDivider()
                }

                item {
                    state.seller?.let {
                        SellerInformationSection(
                            sellerModel = it,
                            detailProductModel = state.product
                        )
                    }
                }
            }
        }

        if (state.product == null || state.seller == null) {
            if (!state.isLoading && state.errorMessage != null) {
                LottieInfoScreen(
                    resource = SharedResource.raw.error_alert,
                    message = stringResource(state.errorMessage),
                    contentColor = MaterialTheme.colorScheme.tertiary
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BodyContent(
    detailProductModel: DetailProductModel?
) {
    val pagerState = rememberPagerState(pageCount = {
        detailProductModel?.pictures?.size ?: 0
    })

    BaseRowItem(
        leading = {
            Text(
                modifier = Modifier.padding(MeasureSmallDimen.DIMEN_X03.value),
                text = "${detailProductModel?.condition?.value} | ${detailProductModel?.availableQuantity} ${stringResource(R.string.available_disclaimer)}",
                style = MaterialTheme.typography.labelSmall
            )
        },
        dimensionParams = DimensionParams(
            width = null,
            height = MeasureSmallDimen.DIMEN_X20.value
        ),
        containerColor = gray50,
        withHorizontalPadding = false
    )
    Spacer(modifier = Modifier.height(MeasureSmallDimen.DIMEN_X04.value))
    Text(
        text = detailProductModel?.title.orEmpty(),
        style = MaterialTheme.typography.bodyLarge
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(MeasureLargeDimen.DIMEN_X30.value)
    ) {
        HorizontalPager(pagerState) { currentPage ->
            RemoteImage(
                url = detailProductModel?.pictures?.get(currentPage)?.url.orEmpty(),
                contentScale = ContentScale.Fit
            )
        }
    }
    Spacer(modifier = Modifier.height(MeasureSmallDimen.DIMEN_X06.value))
    Text(
        text = detailProductModel?.price?.toCurrency().orEmpty(),
        style = MaterialTheme.typography.displayMedium
    )
}

@Composable
fun SellerInformationSection(
    sellerModel: SellerModel,
    detailProductModel: DetailProductModel?
) {
    BaseRowItem(
        leading = {
            Text(
                text = stringResource(R.string.information_seller_title),
                style = MaterialTheme.typography.bodyLarge
            )
        },
        dimensionParams = DimensionParams(
            width = null,
            height = MeasureSmallDimen.DIMEN_X25.value
        ),
        withHorizontalPadding = false,
        withVerticalPadding = false
    )
    BaseRowItem(
        leading = {
            Box(
                modifier = Modifier
                    .width(
                        MeasureSmallDimen.DIMEN_X16.value
                    )
                    .wrapContentHeight()
                    .padding(MeasureSmallDimen.DIMEN_X02.value)
            ) {
                Icon(
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = "",
                    tint = gray400
                )
            }
        },
        trailing = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = detailProductModel?.sellerLocation?.city.orEmpty(),
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = sellerModel.name,
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color(sellerModel.reputation.color)
                    )
                )
            }
        },
        trailingArrangement = Arrangement.Start,
        leadingWeight = 0.1f,
        trailingWeight = 0.9f,
        dimensionParams = DimensionParams(
            width = null,
            height = MeasureSmallDimen.DIMEN_X25.value
        ),
        withHorizontalPadding = false,
        withVerticalPadding = false
    )
    BaseRowItem(
        leading = {
            Box(
                modifier = Modifier
                    .width(
                        MeasureSmallDimen.DIMEN_X16.value
                    )
                    .wrapContentHeight()
                    .padding(MeasureSmallDimen.DIMEN_X02.value)
            ) {
                Icon(
                    imageVector = Icons.Rounded.MilitaryTech,
                    contentDescription = "",
                    tint = Color(sellerModel.reputation.color)
                )
            }
        },
        trailing = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = sellerModel.reputationName?.let {
                        it.uppercase()
                    } ?: stringResource(R.string.unknown_reputation).uppercase(),
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color(sellerModel.reputation.color)
                    )
                )
            }
        },
        trailingArrangement = Arrangement.Start,
        leadingWeight = 0.1f,
        trailingWeight = 0.9f,
        dimensionParams = DimensionParams(
            width = null,
            height = MeasureSmallDimen.DIMEN_X20.value
        ),
        withHorizontalPadding = false,
        withVerticalPadding = false
    )
}