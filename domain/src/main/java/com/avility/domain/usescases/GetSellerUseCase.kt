package com.avility.domain.usescases

import com.avility.domain.model.SellerModel
import com.avility.domain.repository.SellerRepository
import com.avility.shared.R
import com.avility.shared.core.constants.Resource
import timber.log.Timber
import javax.inject.Inject

class GetSellerUseCase @Inject constructor(
    private val sellerRepository: SellerRepository
) {

    suspend operator fun invoke(id: Long): Resource<SellerModel?> {
        var resourceResult: Resource<SellerModel?> = Resource.Error(
            R.string.generic_error
        )

        runCatching {
            sellerRepository.getSellerById(id)
        }.onFailure {
            Timber.e(it)
            resourceResult = Resource.Error(R.string.generic_error)
        }.onSuccess {
            resourceResult = Resource.Success(it)
        }

        return resourceResult
    }

}