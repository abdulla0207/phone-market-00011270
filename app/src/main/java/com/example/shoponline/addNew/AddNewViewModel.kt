package com.example.shoponline.addNew

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoponline.network.RetrofitInstance
import com.example.shoponline.network.myResponse.MyResponse
import com.example.shoponline.network.product.ProductRequest
import com.example.shoponline.network.product.ProductResponse
import com.example.shoponline.utils.Constants
import kotlinx.coroutines.launch

class AddNewViewModel : ViewModel() {
    val insertProductResp: MutableLiveData<MyResponse> by lazy{
        MutableLiveData<MyResponse>()
    }

    // It takes as the argument the instance that should be saved in the database
    // and sends to the database from RetrofitInstance, by using POST request
    fun saveInsertedProductToDB(productReq: ProductRequest){
        viewModelScope.launch {
            try {
                val response: MyResponse = RetrofitInstance.productService.insertProduct(
                    Constants.STUDENT_ID,
                    productRequest = productReq
                )

                insertProductResp.value = response
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}