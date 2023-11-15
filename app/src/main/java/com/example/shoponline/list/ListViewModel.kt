package com.example.shoponline.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoponline.models.Product
import com.example.shoponline.network.RetrofitInstance
import com.example.shoponline.network.myResponse.MyListResponse
import com.example.shoponline.network.product.ProductResponse
import com.example.shoponline.utils.Constants
import kotlinx.coroutines.launch

class ListViewModel : ViewModel(){

    val productsLiveData: MutableLiveData<List<Product>> by lazy{
        MutableLiveData<List<Product>>()
    }

    init {
        getProductListFromDB()
    }

    fun getProductListFromDB(){
        viewModelScope.launch {
            try {
                val response: MyListResponse<ProductResponse> = RetrofitInstance.productService.getAllProducts("00011270")
                val productsResponse = response.data

                if(productsResponse != null){
                    val listProducts = mutableListOf<Product>()

                    for(productResponse in productsResponse){
                        listProducts.add(
                            Product(
                                productResponse.id,
                                productResponse.name,
                                productResponse.price,
                                productResponse.contactPhone,
                                productResponse.Status,
                                productResponse.isFavorite,
                                productResponse.description
                                )
                        )
                    }
                    productsLiveData.value = listProducts
                }
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }


}