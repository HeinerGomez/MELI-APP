package com.avility.meli.usescases

import com.avility.domain.usescases.GetSellerUseCase
import com.avility.meli.repository.FakeSellerRepository
import com.avility.shared.core.constants.Resource
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetSellerUseCaseTest {

    private lateinit var getSellerUseCase: GetSellerUseCase
    private lateinit var fakeSellerRepository: FakeSellerRepository

    @Before
    fun setup() {
        fakeSellerRepository = FakeSellerRepository()
        getSellerUseCase = GetSellerUseCase(fakeSellerRepository)
    }

    @Test
    fun `When the getSellerUseCase is called with a valid sellerId, it should return a Resource Success object with the found seller`() {
        // Give
        val sellerId = 353486933L

        // When
        val resultResource = runBlocking {
            getSellerUseCase.invoke(sellerId)
        }

        // Then
        assert(resultResource is Resource.Success)
        assert(resultResource.data != null)
    }

    @Test
    fun `When the getSellerUseCase is called with an invalid sellerId, it should return a Resource Error object with the corresponding error`() {
        // Give
        val sellerId = 0L

        // When
        val resultResource = runBlocking {
            getSellerUseCase.invoke(sellerId)
        }

        // Then
        assert(resultResource is Resource.Error)
        assert(resultResource.data == null)
    }
}