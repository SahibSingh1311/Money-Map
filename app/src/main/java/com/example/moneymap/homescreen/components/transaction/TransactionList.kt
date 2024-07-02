package com.example.moneymap.homescreen.components.transaction

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moneymap.R

@Composable
fun TransactionList(modifier: Modifier) {
    Column(modifier = modifier.padding(horizontal = 16.dp)) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Recent Transaction", fontSize = 20.sp)
            Text(
                text = "See All",
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }
        TransactionItem(
            title = "Netflix",
            amount = "-$ 10.00",
            icon = R.drawable.ic_netflix,
            date = "Today",
            color = Color.Red
        )

        TransactionItem(
            title = "Upwork",
            amount = "+$ 150.00",
            icon = R.drawable.ic_upwork,
            date = "Today",
            color = Color.Green
        )
        TransactionItem(
            title = "Paypal",
            amount = "-$ 95.00",
            icon = R.drawable.ic_paypal,
            date = "Today",
            color = Color.Red
        )
        TransactionItem(
            title = "Youtube",
            amount = "+$ 120.00",
            icon = R.drawable.ic_youtube,
            date = "Today",
            color = Color.Green
        )
    }
}
