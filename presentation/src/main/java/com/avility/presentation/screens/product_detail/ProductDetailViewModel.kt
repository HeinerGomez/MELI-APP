package com.avility.presentation.screens.product_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.avility.domain.usescases.GetProductDetailUseCase
import com.avility.domain.usescases.GetSellerUseCase
import com.avility.presentation.screens.BaseViewModel
import com.avility.shared.core.constants.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * [ProductDetailViewModel] viewModel to handle the flow of data of detail of product
 *
 * @author Heiner Gómez
 * @param [getProductDetailUseCase] use case to get the detail of a product
 * @param [getSellerUseCase] use case to get the seller associated to a concrete product
 * @param [savedStateHandle] to recover the params that arrived for url in the navController
 */
@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val getProductDetailUseCase: GetProductDetailUseCase,
    private val getSellerUseCase: GetSellerUseCase,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<ProductDetailState, ProductDetailAction>(ProductDetailState()) {

    init {
        savedStateHandle.get<String>(Constants.PARAM_PRODUCT_ID)?.let { productId ->
            getDetailData(productId)
        }
    }

    override fun dispatchAction(action: ProductDetailAction) {}

    private fun getDetailData(productId: String) {
        viewModelScope.launch {
            setState(uiState.value.copy(
                isLoading = true
            ))

            // get detail product
            val detailProduct = getProductDetailUseCase(productId)
            setState(uiState.value.copy(
                isLoading = false,
                product = detailProduct.data,
                errorMessage = detailProduct.message
            ))

            detailProduct.data?.let { detailProductModel ->
                detailProductModel.sellerId?.let { sellerId ->
                    // get seller of product
                    val seller = getSellerUseCase(sellerId)

                    setState(uiState.value.copy(
                        isLoading = false,
                        seller = seller.data,
                        errorMessage = detailProduct.message ?: seller.message
                    ))
                }
            }

            setState(uiState.value.copy(
                isLoading = false
            ))
        }
    }
}