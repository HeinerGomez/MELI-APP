package com.avility.meli.usescases

import com.avility.domain.repository.ProductRepository
import com.avility.domain.usescases.SearchProductsUseCase
import com.avility.meli.repository.FakeProductRepository
import com.avility.shared.core.constants.Resource
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class SearchProductsUseCaseTest {

    private lateinit var searchProductsUseCase: SearchProductsUseCase
    private lateinit var productFakeRepository: ProductRepository

    @Before
    fun setup() {
        productFakeRepository = FakeProductRepository()
        searchProductsUseCase = SearchProductsUseCase(productFakeRepository)
    }

    @Test
    fun `When the searchProductsUseCase is called with an empty query, it should return a Resource Success object with an empty list or null`() {
        // Given
        val query = ""

        // When
        val resultResource = runBlocking {
            searchProductsUseCase.invoke(query)
        }

        // Then
        assert(resultResource is Resource.Success)
        assert(resultResource.data.isNullOrEmpty())
    }

    @Test
    fun `When the searchProductsUseCase is called with a query that has no matches, it should return a Resource Success object with an empty list or null`() {
        // Given
        val query = "InvalidQuery"

        // When
        val resultResource = runBlocking {
            searchProductsUseCase.invoke(query)
        }

        // Then
        assert(resultResource is Resource.Success)
        assert(resultResource.data.isNullOrEmpty())
    }

    @Test
    fun `When the searchProductsUseCase is called with a valid query, it should return a Resource Success object with a non-empty list`() {
        // Given
        val query = "iPhon"

        // When
        val resultResource = runBlocking {
            searchProductsUseCase.invoke(query)
        }

        // Then
        assert(resultResource is Resource.Success)
        assert(resultResource.data?.size!! > 0)
    }
}