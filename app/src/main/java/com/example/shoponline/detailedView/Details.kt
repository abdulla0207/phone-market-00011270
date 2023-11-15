package com.example.shoponline.detailedView

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoponline.R


@Composable
internal fun ProductImage(picture: Int) {
    Image(

        painter = painterResource(id = picture),
        contentDescription = stringResource(id = R.string.image_content_desc_title),
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(300.dp)
            .clip(RoundedCornerShape(10.dp)),
    )
}
@Composable
internal fun Title(title: String){
    Text(
        text = title,
        color = Color.Black,
        fontSize = 17.sp,
        fontFamily = FontFamily.Monospace,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold
    )
}

@Composable
internal fun Price(price: Double){
    Text(
        text = stringResource(id = R.string.price_label, price),
        modifier = Modifier.padding(bottom = 2.dp),
        color = Color.Black,
        fontSize = 17.sp,
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold
    )
}

@Composable
internal fun Phone(contactPhone: String){
    Text(
        text = contactPhone,
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        fontSize = 17.sp,
        fontFamily = FontFamily.Monospace
    )
}

@Composable
internal fun Description(description: String){
    Text(
        text = description,
        color = Color.Black,
        fontSize = 18.sp,
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold
    )
}

@Composable
internal fun DeleteButton(onClick: ()->Unit){
    Button(
        onClick = { onClick() },
        modifier = Modifier
            .width(120.dp)
            .height(80.dp)
            .padding(vertical = 16.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.back_button_color)))
    {
        Text(text = stringResource(id = R.string.delete_text), color = Color.White, fontSize = 20.sp )
    }
}