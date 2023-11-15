package com.example.shoponline.detailedView

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoponline.MainActivity
import com.example.shoponline.R


@Composable
fun DetailedProductDescr(
    productId: String,
    viewModel: DetailedViewModel = DetailedViewModel(productId),
) {
    val product by viewModel.productData.observeAsState()
    val context = LocalContext.current
    if (product != null) {
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(bottom = 50.dp)) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(colorResource(id = R.color.purple_500))
            )
            {
                Button(onClick = {
                    context.startActivity(Intent(context, MainActivity::class.java))
                }) {
                    Image(painter = painterResource(id = R.drawable.ic_baseline_arrow_back_ios_new_24),
                        contentDescription = stringResource(id = R.string.go_back_arrow),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(50.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .padding(10.dp, 10.dp, 0.dp, 0.dp))
                }
            }
            Column(
                modifier = Modifier.padding(50.dp, 20.dp, 50.dp, 0.dp)
            ) {
                ProductImage(R.drawable.iphone14pro)
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                TitleNames(word = stringResource(id = R.string.product))
                Title(title = product!!.name)
                Spacer(modifier = Modifier.height(30.dp))
                TitleNames(word = stringResource(id = R.string.price))
                Price(price = product!!.price)
                Spacer(modifier = Modifier.height(30.dp))
                TitleNames(word = stringResource(id = R.string.contacts))
                Phone(contactPhone = product!!.contactPhone)
                TitleNames(word = stringResource(id = R.string.description))
                Description(description = product!!.description)
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    if (product!!.Status.lowercase() == "active") {
                        Button(
                            onClick = {
                                viewModel.deleteProductFrom(productId)
                                context.startActivity(Intent(context, MainActivity::class.java))
                                Toast.makeText(context, R.string.product_sold, Toast.LENGTH_SHORT).show()
                                      },
                            modifier = Modifier
                                .width(120.dp)
                                .height(80.dp)
                                .padding(vertical = 16.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.purple_500))
                        ) {
                            Text(text = stringResource(id = R.string.buy_button_title))
                        }
                    } else {
                        Text(text = stringResource(id = R.string.item_sold_title), fontSize = 25.sp)
                    }
                }
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    DeleteButton {
                        viewModel.deleteProductFrom(productId)
                        context.startActivity(Intent(context, MainActivity::class.java))
                    }
                }
            }
        }

    }
}


@Composable
private fun TitleNames(word: String) {
    Text(
        text = word,
        fontSize = 25.sp,
        fontFamily = FontFamily.Monospace,
    )
}