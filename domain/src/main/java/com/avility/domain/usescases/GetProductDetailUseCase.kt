package com.avility.domain.usescases

import com.avility.domain.model.DetailProductModel
import com.avility.domain.repository.ProductRepository
import com.avility.shared.R
import com.avility.shared.core.constants.Resource
import timber.log.Timber
import javax.inject.Inject

/**
 * [GetProductDetailUseCase] to get the detail of a concrete product
 *
 * @author Heiner Gómez
 * @param [productRepository] to connect with the data
 */
class GetProductDetailUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {

    suspend operator fun invoke(id: String): Resource<DetailProductModel?> {
        var resourceResult: Resource<DetailProductModel?> = Resource.Error(
            R.string.generic_error
        )

        runCatching {
            productRepository.getItemFromSearch(id)
        }.onFailure {
            Timber.e(it)
            resourceResult = Resource.Error(R.string.generic_error)
        }.onSuccess {
            resourceResult = Resource.Success(it)
        }

        return resourceResult
    }
}