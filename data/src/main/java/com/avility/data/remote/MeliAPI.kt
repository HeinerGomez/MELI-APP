package com.avility.data.remote

import com.avility.data.remote.dto.ProductDto
import com.avility.data.remote.dto.SearchResponseDto
import com.avility.data.remote.dto.SellerDto
import com.avility.shared.core.constants.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MeliAPI {

    @GET("sites/${Constants.DEFAULT_SITE_ID}/search")
    suspend fun getResultsOfSearch(
        @Query("q") query: String,
        @Query("offset") offset: Int
    ): SearchResponseDto

    @GET("items/{item_id}")
    suspend fun getItemFromSearch(
        @Path("item_id") itemId: String
    ): ProductDto

    @GET("users/{seller_id}")
    suspend fun getSellerById(
        @Path("seller_id") sellerId: Long
    ): SellerDto
}