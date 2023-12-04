package com.avility.meli.screens

import com.avility.domain.model.ProductModel
import com.avility.domain.usescases.SearchProductsUseCase
import com.avility.meli.rules.TestDispatcherRule
import com.avility.presentation.screens.product_list.ProductListAction
import com.avility.presentation.screens.product_list.ProductListState
import com.avility.presentation.screens.product_list.ProductListViewModel
import com.avility.shared.core.constants.Resource
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.Assert.assertEquals
import org.mockito.Mockito.anyString
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class ProductListViewModelTest {

    @get:Rule
    val dispatcherRule = TestDispatcherRule()

    private lateinit var searchProductsUseCase: SearchProductsUseCase
    private lateinit var productListViewModel: ProductListViewModel

    @Before
    fun setup() {
        searchProductsUseCase = mock(SearchProductsUseCase::class.java)
        productListViewModel = ProductListViewModel(searchProductsUseCase)
    }

    @Test
    fun `When the dispatchAction of the viewModel is called with the UpdateQueryValue action and a valid query, it should return a state with the updated query`() = runTest {
        // Given
        val successResult = Resource.Success<List<ProductModel>?>(emptyList())
        val validQuery = "iPho"

        `when`(searchProductsUseCase.invoke(validQuery)).thenReturn(
            successResult
        )

        // When
        productListViewModel.dispatchAction(ProductListAction.UpdateQueryValue(validQuery))
        advanceUntilIdle()

        // Then
        val expectedState = ProductListState(
            isLoading = false,
            data = emptyList(),
            querySearch = validQuery,
            errorMessage = null
        )

        assertEquals(
            expectedState,
            productListViewModel.uiState.value
        )
    }

    @Test
    fun `When the dispatchAction of the viewModel is called with the Search action and a valid query, it should return a state with the data`() = runTest {
        // Given
        val data = listOf(mock(ProductModel::class.java))
        val successResult = Resource.Success<List<ProductModel>?>(
            data
        )

        val validQuery = "iPho"

        `when`(searchProductsUseCase.invoke(validQuery)).thenReturn(
            successResult
        )

        // When
        productListViewModel.dispatchAction(ProductListAction.UpdateQueryValue(validQuery))
        productListViewModel.dispatchAction(ProductListAction.Search)
        advanceUntilIdle()

        // Then
        val expectedState = ProductListState(
            isLoading = false,
            data = data,
            querySearch = validQuery,
            errorMessage = null
        )

        assertEquals(
            expectedState,
            productListViewModel.uiState.value
        )
    }

    @Test
    fun `When the dispatchAction of the viewModel is called with the Search action, forcing a failure, it should return a state with the corresponding error`() = runTest {
        // Given
        val errorResource = 1
        val errorResult = Resource.Error<List<ProductModel>?>(errorResource)
        val invalidSearch = anyString()

        `when`(searchProductsUseCase.invoke(invalidSearch)).thenReturn(
            errorResult
        )

        // When
        productListViewModel.dispatchAction(ProductListAction.UpdateQueryValue(invalidSearch))
        productListViewModel.dispatchAction(ProductListAction.Search)
        advanceUntilIdle()

        // Then
        val expectedState = ProductListState(
            isLoading = false,
            data = emptyList(),
            querySearch = invalidSearch,
            errorMessage = errorResource
        )

        assertEquals(
            expectedState,
            productListViewModel.uiState.value
        )
    }
}