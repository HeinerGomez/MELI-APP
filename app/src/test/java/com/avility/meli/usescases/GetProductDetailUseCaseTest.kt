package com.avility.meli.usescases

import com.avility.domain.repository.ProductRepository
import com.avility.domain.usescases.GetProductDetailUseCase
import com.avility.meli.repository.FakeProductRepository
import com.avility.shared.core.constants.Resource
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetProductDetailUseCaseTest {

    private lateinit var getProductDetailUseCase: GetProductDetailUseCase
    private lateinit var productFakeRepository: ProductRepository

    @Before
    fun setup() {
        productFakeRepository = FakeProductRepository()
        getProductDetailUseCase = GetProductDetailUseCase(productFakeRepository)
    }

    @Test
    fun `When the getProductDetailUseCase is called with a valid productId, it should return a Resource Success object with the found item`() {
        // Give
        val itemId = "MCO658946356"

        // When
        val resultResource = runBlocking {
            getProductDetailUseCase.invoke(itemId)
        }

        // Then
        assert(resultResource is Resource.Success)
        assert(resultResource.data != null)
    }

    @Test
    fun `When the getProductDetailUseCase is called with an invalid productId, it should return a Resource Error object with the corresponding error`() {
        // Give
        val itemId = "INVALID_CODE"

        // When
        val resultResource = runBlocking {
            getProductDetailUseCase.invoke(itemId)
        }

        // Then
        assert(resultResource is Resource.Error)
        assert(resultResource.message != null)
    }
}