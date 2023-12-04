package com.avility.data.repository

import com.avility.data.mappers.toModel
import com.avility.data.remote.MeliAPI
import com.avility.domain.model.SellerModel
import com.avility.domain.repository.SellerRepository
import javax.inject.Inject

/**
 * repository to handle the data related of seller
 *
 * @author Heiner Gómez
 * @param api [MeliAPI] to make requests
 */
class SellerRepositoryImpl @Inject constructor(
    private val api: MeliAPI
) : SellerRepository {

    override suspend fun getSellerById(id: Long): SellerModel {
        return api.getSellerById(id).toModel()
    }
}