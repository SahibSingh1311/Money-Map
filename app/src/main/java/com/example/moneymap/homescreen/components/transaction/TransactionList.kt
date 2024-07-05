package com.example.moneymap.homescreen.components.transaction

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moneymap.R
import com.example.moneymap.data.model.ExpenseEntity
import com.example.moneymap.data.model.ExpenseType
import com.example.moneymap.viewmodel.HomeViewModel

@Composable
fun TransactionList(viewModel: HomeViewModel, list: List<ExpenseEntity>, modifier: Modifier) {
    LazyColumn(modifier = modifier.padding(horizontal = 16.dp)) {
        item {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Recent Transaction", fontSize = 20.sp)
                Text(
                    text = "See All",
                    fontSize = 16.sp,
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
        }
        items(list) {
            TransactionItem(
                title = it.title,
                amount = it.amount.toString(),
                icon = viewModel.getItemIcon(it),
                date = it.date.toString(),
                color = if (it.type == ExpenseType.INCOME) Color.Green else Color.Red
            )
        }
    }
}
