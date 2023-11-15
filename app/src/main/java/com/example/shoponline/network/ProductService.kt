package com.example.shoponline.network

import com.example.shoponline.network.myResponse.MyItemResponse
import com.example.shoponline.network.myResponse.MyListResponse
import com.example.shoponline.network.myResponse.MyResponse
import com.example.shoponline.network.product.ProductRequest
import com.example.shoponline.network.product.ProductResponse
import retrofit2.http.*

interface ProductService {
    // Request Functions (Fetching and Inserting)

    @GET("records/all")
    suspend fun getAllProducts(
        @Query("student_id") student_id: String
    ): MyListResponse<ProductResponse>

    @POST("records")
    suspend fun insertProduct(
        @Query("student_id") student_id: String,
        @Body productRequest: ProductRequest
    ): MyResponse

    @GET("records/{record_id}")
    suspend fun getProductById(
        @Path("record_id") record_id: String,
        @Query("student_id") student_id: String
    ): MyItemResponse<ProductResponse>


    @DELETE("records/{record_id}")
    suspend fun deleteProductById(
        @Path("record_id") record_id: String,
        @Query("student_id") student_id: String,
    ): MyResponse
}