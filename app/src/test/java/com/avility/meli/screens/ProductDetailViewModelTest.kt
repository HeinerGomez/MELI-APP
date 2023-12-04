package com.avility.meli.screens

import androidx.lifecycle.SavedStateHandle
import com.avility.domain.model.DetailProductModel
import com.avility.domain.model.SellerModel
import com.avility.domain.usescases.GetProductDetailUseCase
import com.avility.domain.usescases.GetSellerUseCase
import com.avility.meli.rules.TestDispatcherRule
import com.avility.presentation.screens.product_detail.ProductDetailState
import com.avility.presentation.screens.product_detail.ProductDetailViewModel
import com.avility.shared.core.constants.Constants
import com.avility.shared.core.constants.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.anyLong
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class ProductDetailViewModelTest {

    @get:Rule
    val dispatcherRule = TestDispatcherRule()

    private lateinit var getProductDetailUseCase: GetProductDetailUseCase
    private lateinit var getSellerUseCase: GetSellerUseCase
    private lateinit var detailProductModelMock: DetailProductModel
    private lateinit var sellerModelMock: SellerModel
    private lateinit var savedStateHandleMock: SavedStateHandle

    @Before
    fun setup() {
        getProductDetailUseCase = mock(GetProductDetailUseCase::class.java)
        getSellerUseCase = mock(GetSellerUseCase::class.java)
        detailProductModelMock = mock(DetailProductModel::class.java)
        sellerModelMock = mock(SellerModel::class.java)

        val productId = "MCO658946356"
        savedStateHandleMock = SavedStateHandle().apply {
            set(Constants.PARAM_PRODUCT_ID, productId)
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `When the viewModel is instantiated, it should return a valid state`() = runTest {
        // Given
        val successResultDetailProduct: Resource<DetailProductModel?> = Resource.Success(detailProductModelMock)
        val successResultSeller: Resource<SellerModel?> = Resource.Success(sellerModelMock)

        val productId = savedStateHandleMock.get<String>(Constants.PARAM_PRODUCT_ID).orEmpty()

        `when`(getProductDetailUseCase.invoke(productId)).thenReturn(
            successResultDetailProduct
        )

        `when`(getSellerUseCase.invoke(anyLong())).thenReturn(
            successResultSeller
        )

        // When
        val viewModel = ProductDetailViewModel(
            getProductDetailUseCase,
            getSellerUseCase,
            savedStateHandleMock
        )
        advanceUntilIdle()

        // Then
        val expectedState = ProductDetailState(
            isLoading = false,
            product = detailProductModelMock,
            seller = sellerModelMock,
            errorMessage = null
        )

        assertEquals(
            expectedState,
            viewModel.uiState.value
        )
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `When the viewModel is instantiated, forcing an error, it should return a state with the corresponding error`() = runTest {
        // Given
        val resourceMessage = 1
        val errorResultDetailProduct: Resource<DetailProductModel?> = Resource.Error(resourceMessage)
        val errorResultSeller: Resource<SellerModel?> = Resource.Error(resourceMessage)

        val productId = savedStateHandleMock.get<String>(Constants.PARAM_PRODUCT_ID).orEmpty()

        `when`(getProductDetailUseCase.invoke(productId)).thenReturn(
            errorResultDetailProduct
        )

        `when`(getSellerUseCase.invoke(anyLong())).thenReturn(
            errorResultSeller
        )

        // When
        val viewModel = ProductDetailViewModel(
            getProductDetailUseCase,
            getSellerUseCase,
            savedStateHandleMock
        )
        advanceUntilIdle()

        // Then
        val expectedState = ProductDetailState(
            isLoading = false,
            product = null,
            seller = null,
            errorMessage = resourceMessage
        )

        assertEquals(
            expectedState,
            viewModel.uiState.value
        )
    }
}