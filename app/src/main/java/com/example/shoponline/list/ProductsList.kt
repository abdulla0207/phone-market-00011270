package com.example.shoponline.list

import android.Manifest
import android.content.Intent
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.FloatingActionButton
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoponline.R
import com.example.shoponline.addNew.AddNewActivity
import com.example.shoponline.models.Product

@Composable
fun ProdsList(
    onProductClick: (String) -> Unit = {},
    viewModel: ListViewModel = ListViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    )
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(colorResource(id = R.color.purple_500))
        )
        {
            Text(
                text = stringResource(id = R.string.products_nav_tab_title),
                fontSize = 29.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 10.dp, top = 10.dp, 0.dp, 0.dp)
            )
        }
        val context = LocalContext.current
        Box(modifier = Modifier.fillMaxSize()) {

            val movies by viewModel.productsLiveData.observeAsState()

            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(0.dp, 0.dp, 0.dp, 70.dp)
            ) {
                movies?.let {
                    items(items = it.toList(), itemContent = { item ->
                        Product(product = item, onProductClick)
                    })
                }
            }
            FloatingActionButton(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(0.dp, 0.dp, 0.dp, 70.dp),
                onClick = {
                    //redirects to AddProject Page
                    context.startActivity(Intent(context, AddNewActivity::class.java))
                }) {
                Text(
                    stringResource(id = R.string.list_add_new_title),
                    modifier = Modifier.padding(15.dp, 5.dp),
                    color = colorResource(id = R.color.teal_700)
                )
            }
        }
    }


}

@Composable
fun Product(product: Product, onProductClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(100.dp, 10.dp, 100.dp, 0.dp)
            .clickable {
                onProductClick(product.id.toString())
            }
    ) {
        ProductImage(picture = R.drawable.iphone14pro)
        Title(title = product.name)
        Spacer(Modifier.weight(1f))
        Price(price = product.price)
    }
}

