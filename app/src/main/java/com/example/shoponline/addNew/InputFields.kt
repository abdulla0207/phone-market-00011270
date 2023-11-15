package com.example.shoponline.addNew

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoponline.MainActivity
import com.example.shoponline.R

@Composable
internal fun ProductNameInput(name: String, onNameChange: (String) -> Unit) {
    OutlinedTextField(
        value = name,
        onValueChange = { onNameChange(it) },
        textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        label = {
            Text(stringResource(id = R.string.add_new_product_title))
        },
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.text_field_background))
            .border(width = 1.dp, color = Color.Black)
    )
}

@Composable
internal fun ProductPriceInput(price: String, onPriceChange: (String) -> Unit) {
    OutlinedTextField(
        value = price,
        onValueChange = { onPriceChange(it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        label = {
            Text(text = stringResource(id = R.string.add_price_title))
        },
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.text_field_background))
            .border(width = 1.dp, color = Color.Black),
    )
}

@Composable
internal fun PhoneNumberInput(phoneNum: String, onPhoneNumChange: (String) -> Unit) {
    OutlinedTextField(
        value = phoneNum,
        onValueChange = { onPhoneNumChange(it) },
        label = {
            Text(text = stringResource(id = R.string.add_phone_number_example_title))
        },
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.text_field_background))
            .border(width = 1.dp, color = Color.Black),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
    )
}

@Composable
internal fun DescriptionInput(description: String, onDescrChange: (String) -> Unit){
    OutlinedTextField(
        value = description,
        onValueChange = {onDescrChange(it)},
        label = {
            Text(text = stringResource(id = R.string.descritption_title))
        },
        modifier = Modifier
            .fillMaxWidth().height(100.dp)
            .background(colorResource(id = R.color.text_field_background))
            .border(width = 1.dp, color = Color.Black),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )
}

@Composable
internal fun AddButton(onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        modifier = Modifier
            .width(120.dp)
            .height(80.dp)
            .padding(vertical = 16.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.add_button_color)))
    {
        Text(text = stringResource(id = R.string.save_button_title), fontSize = 20.sp)
    }
}

@Composable
internal fun BackButton(context: Context){
    Button(
        onClick = { context.startActivity(Intent(context, MainActivity::class.java)) },
        modifier = Modifier
            .width(120.dp)
            .height(80.dp)
            .padding(vertical = 16.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.back_button_color))
    ) {
        Text(text = stringResource(id = R.string.back_button_title), fontSize = 20.sp)
    }
}