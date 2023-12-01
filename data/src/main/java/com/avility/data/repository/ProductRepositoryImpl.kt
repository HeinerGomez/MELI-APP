package com.avility.data.repository

import com.avility.data.mappers.toModel
import com.avility.data.remote.MeliAPI
import com.avility.domain.model.BasicLocationModel
import com.avility.domain.model.DetailProductModel
import com.avility.domain.model.ProductModel
import com.avility.domain.model.ReputationLevel
import com.avility.domain.model.SellerModel
import com.avility.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: MeliAPI
) : ProductRepository {

    override suspend fun getResultForSearch(query: String, offset: Int): List<ProductModel> {
        return api.getResultsOfSearch(query, offset).results.map { it.toModel() }
    }

    override suspend fun getItemFromSearch(itemId: String): DetailProductModel {
        return DetailProductModel("", 0, "", 0, "", 0, emptyList(), 0,
            emptyList(), BasicLocationModel(
                "",
                ""
            )
        )
    }

    override suspend fun getConcreteSeller(sellerId: Int): SellerModel {
        return SellerModel(
            0,
            "",
            ReputationLevel.UnKnow
        )
    }
}