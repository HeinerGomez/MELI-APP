package com.avility.data.repository

import com.avility.data.mappers.toDetailModel
import com.avility.data.mappers.toModel
import com.avility.data.remote.MeliAPI
import com.avility.domain.model.DetailProductModel
import com.avility.domain.model.ProductModel
import com.avility.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: MeliAPI
) : ProductRepository {

    override suspend fun getResultForSearch(query: String, offset: Int): List<ProductModel> {
        return api.getResultsOfSearch(query, offset).results.map { it.toModel() }
    }

    override suspend fun getItemFromSearch(itemId: String): DetailProductModel {
        val productDto = api.getItemFromSearch(itemId)
        return productDto.toDetailModel()
    }
}