package com.avility.meli.repository

import com.avility.data.mappers.toModel
import com.avility.data.remote.dto.SellerDto
import com.avility.domain.model.SellerModel
import com.avility.domain.repository.SellerRepository
import com.squareup.moshi.Moshi

class FakeSellerRepository : SellerRepository {

    private val moshi = Moshi.Builder()
        .build()

    override suspend fun getSellerById(id: Long): SellerModel {
        val adapter = moshi.adapter(SellerDto::class.java)

        val data = adapter.fromJson(
            this::class.java.classLoader?.getResource("seller_data.json")?.readText().orEmpty()
        )?.toModel()

        val sellerFound = if(data?.id?.toLong() == id) {
            data
        } else {
            null
        }

        return sellerFound!!
    }
}