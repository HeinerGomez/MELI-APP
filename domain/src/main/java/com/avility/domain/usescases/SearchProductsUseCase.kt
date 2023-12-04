package com.avility.domain.usescases

import com.avility.domain.model.ProductModel
import com.avility.domain.repository.ProductRepository
import com.avility.shared.core.constants.Constants
import com.avility.shared.core.constants.Resource
import com.avility.shared.R
import timber.log.Timber
import javax.inject.Inject

/**
 * [SearchProductsUseCase] to handle the search of product by his name
 *
 * @author Heiner Gómez
 * @param [productRepository] to connect with the data
 */
class SearchProductsUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {

    suspend operator fun invoke(query: String): Resource<List<ProductModel>?> {
        var resourceResult: Resource<List<ProductModel>?> = Resource.Error(
            R.string.generic_error
        )

        runCatching {
            productRepository.getResultForSearch(query, Constants.INITIAL_OFFSET)
        }.onFailure {
            Timber.e(it)
            resourceResult = Resource.Error(R.string.generic_error)
        }.onSuccess {
            resourceResult = Resource.Success(it)
        }

        return resourceResult
    }
}