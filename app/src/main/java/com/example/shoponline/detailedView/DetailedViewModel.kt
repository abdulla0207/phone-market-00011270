package com.example.shoponline.detailedView

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoponline.models.Product
import com.example.shoponline.network.RetrofitInstance
import com.example.shoponline.network.myResponse.MyItemResponse
import com.example.shoponline.network.myResponse.MyResponse
import com.example.shoponline.network.product.ProductResponse
import com.example.shoponline.utils.Constants
import kotlinx.coroutines.launch

class DetailedViewModel(productId: String): ViewModel() {

    val productData: MutableLiveData<Product> by lazy{
        MutableLiveData<Product>()
    }

    init {
        getProductById(productId)
    }

    private fun getProductById(productId: String){
        viewModelScope.launch {
            try {

                val response: MyItemResponse<ProductResponse> = RetrofitInstance.productService.getProductById(
                    productId, Constants.STUDENT_ID
                )

                if(response.data != null){
                    productData.value = Product(
                        response.data.id,
                        response.data.name,
                        response.data.price,
                        response.data.contactPhone,
                        response.data.Status,
                        response.data.isFavorite,
                        response.data.description
                    )
                }

                val ee = productData.value
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

    fun deleteProductFrom(productId: String){
        viewModelScope.launch {
            try{
                val deleteResponse: MyResponse = RetrofitInstance.productService.deleteProductById(
                    productId,
                    Constants.STUDENT_ID
                )
                Log.d("Delete_response", deleteResponse.toString())
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}