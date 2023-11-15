package com.example.shoponline.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoponline.R
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
internal fun ProductImage(picture: Int) {
    Image(

        painter = painterResource(id = picture),
        contentDescription = stringResource(id = R.string.image_content_desc_title),
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(190.dp)
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
        fontSize = 13.sp,
        fontFamily = FontFamily.Monospace
    )
}
