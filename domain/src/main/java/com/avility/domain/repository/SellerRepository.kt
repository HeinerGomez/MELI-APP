package com.avility.domain.repository

import com.avility.domain.model.SellerModel

interface SellerRepository {
    suspend fun getSellerById(id: Long): SellerModel
}