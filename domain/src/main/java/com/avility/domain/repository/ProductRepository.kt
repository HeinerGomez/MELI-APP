package com.avility.domain.repository

import com.avility.domain.model.DetailProductModel
import com.avility.domain.model.ProductModel
import com.avility.domain.model.SellerModel

interface ProductRepository {

    suspend fun getResultForSearch(query: String, offset: Int): List<ProductModel>

    suspend fun getItemFromSearch(itemId: String): DetailProductModel
}