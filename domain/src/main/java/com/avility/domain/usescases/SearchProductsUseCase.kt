package com.avility.domain.usescases

import com.avility.domain.model.ProductModel
import com.avility.domain.repository.ProductRepository
import com.avility.shared.core.constants.Constants
import com.avility.shared.core.constants.Resource
import kotlinx.coroutines.delay
import timber.log.Timber
import javax.inject.Inject

class SearchProductsUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {

    suspend operator fun invoke(query: String): Resource<List<ProductModel>?> {
        var resourceResult: Resource<List<ProductModel>?> = Resource.Error(Constants.GENERIC_ERROR)

        runCatching {
            productRepository.getResultForSearch(query, Constants.INITIAL_OFFSET)
        }.onFailure {
            Timber.e(it)
            // TODO call utils to assign the correct message error
            resourceResult = Resource.Error(Constants.GENERIC_ERROR)
        }.onSuccess {
            resourceResult = Resource.Success(it)
        }

        return resourceResult
    }
}