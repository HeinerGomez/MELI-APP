package com.avility.data.remote

import com.avility.data.remote.dto.ProductDto
import com.avility.data.remote.dto.SearchResponseDto
import com.avility.data.remote.dto.SellerDto
import com.avility.shared.core.constants.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MeliAPI {
    /**
     * Se encarga de la busqueda de productos
     */
    @GET("sites/${Constants.DEFAULT_SITE_ID}/search")
    suspend fun getResultsOfSearch(
        @Query("q") query: String,
        @Query("offset") offset: Int
    ): SearchResponseDto

    /**
     * Se encarga de buscar un producto en concreto de una busqueda mas general
     */
    @GET("items/{item_id}")
    suspend fun getItemFromSearch(
        @Path("item_id") itemId: String
    ): ProductDto

    /**
     * Se encarga de obtener un vendedor en base a su id
     */
    @GET("users/{seller_id}")
    suspend fun getConcreteSeller(
        @Path("seller_id") sellerId: Int
    ): SellerDto
}