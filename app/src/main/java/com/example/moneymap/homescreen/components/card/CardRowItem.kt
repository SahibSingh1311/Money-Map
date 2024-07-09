package com.example.moneymap.homescreen.components.card

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardRowItem(title: String, amount: String, @DrawableRes icon: Int, modifier: Modifier) {
    Column(modifier = modifier) {
        Row {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = title,
                fontSize = 16.sp,
                color = Color.White
            )
        }
        Text(
            text = amount,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}
