package com.example.shoponline.addNew

import android.content.Intent
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.shoponline.MainActivity
import com.example.shoponline.R
import com.example.shoponline.network.product.ProductRequest

@Composable
fun AddNewProduct(viewModel: AddNewViewModel = AddNewViewModel()) {

    //variables that will hold inputs
    var name = remember {
        mutableStateOf("")
    }
    var price = remember {
        mutableStateOf("")
    }
    var contactPhone = remember {
        mutableStateOf("")
    }
    var description = remember {
        mutableStateOf("")
    }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(15.dp)
            .verticalScroll(
                rememberScrollState()
            )
    ) {
        ProductNameInput(name = name.value, onNameChange = { name.value = it })
        Spacer(modifier = Modifier.height(10.dp))
        ProductPriceInput(price = price.value, onPriceChange = { price.value = it })
        Spacer(modifier = Modifier.height(10.dp))
        PhoneNumberInput(
            phoneNum = contactPhone.value,
            onPhoneNumChange = { contactPhone.value = it })
        Spacer(modifier = Modifier.height(10.dp))
        DescriptionInput(description = description.value, onDescrChange = {description.value = it})
        Spacer(modifier = Modifier.height(10.dp))

        val successMsg = stringResource(id = R.string.add_new_saved_msg)
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            AddButton {
                // Validation result
                val validationResult: Int? = validation(name.value, price.value.toDouble(), contactPhone.value)
                // If inputs are correct, then it creates an instance of ProductRequest class and send the instance to
                // the insertProduct function
                if (validationResult == null) {
                    viewModel.saveInsertedProductToDB(
                        ProductRequest(
                            name.value,
                            price.value.toDouble(),
                            contactPhone.value,
                            "SOLD",
                            false,
                            description.value
                        )
                    )
                    context.startActivity(Intent(context, MainActivity::class.java))
                    val toast = Toast.makeText(context, successMsg, Toast.LENGTH_SHORT)
                    toast.setGravity(Gravity.CENTER, 0, 0)
                    toast.show()
                } else {

                    val toast = Toast.makeText(context, context.getString(validationResult), Toast.LENGTH_SHORT)
                    toast.setGravity(Gravity.CENTER, 0, 0)
                    toast.show()
                }
            }
            BackButton(context)
        }
    }
}

private fun validation(
    name: String,
    price: Double,
    phoneNumber: String
): Int? {
    if (name.isBlank() || phoneNumber.isBlank())
        return R.string.name_phone_empty

    val regex = Regex("[+]998[0-9]{9}")
    if (!phoneNumber.matches(regex))
        return R.string.phone_number_format_mismatch

    if (price <= 0)
        return R.string.price_validation

    return null
}

