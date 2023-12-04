package com.avility.meli.repository

import com.avility.data.mappers.toDetailModel
import com.avility.data.mappers.toModel
import com.avility.data.remote.dto.ProductDto
import com.avility.data.remote.dto.SearchResponseDto
import com.avility.domain.model.DetailProductModel
import com.avility.domain.model.ProductModel
import com.avility.domain.repository.ProductRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import timber.log.Timber
import java.lang.Exception
import java.lang.reflect.Type

class FakeProductRepository : ProductRepository {

    private val moshi = Moshi.Builder()
        .build()

    override suspend fun getResultForSearch(query: String, offset: Int): List<ProductModel> {
        try {
            val adapter = moshi.adapter(SearchResponseDto::class.java)
            val data = adapter.fromJson(
                this::class.java.classLoader?.getResource("products_data.json")?.readText().orEmpty()
            )?.results ?: emptyList()

            return if (query.isBlank()) {
                emptyList()
            } else {
                data.map { it.toModel() }.filter { it.title.contains(query) }
            }
        } catch (e: Exception) {
            Timber.e(e)
        }

        return emptyList()
    }

    override suspend fun getItemFromSearch(itemId: String): DetailProductModel {
        val adapter = moshi.adapter(ProductDto::class.java)
        val data = adapter.fromJson(
            this::class.java.classLoader?.getResource("detail_product_data.json")?.readText().orEmpty()
        )?.toDetailModel()

        var itemFound = if (data?.id == itemId) {
            data
        } else {
            null
        }

        return itemFound!!
    }
}