package com.example.moneymap.homescreen.components.transaction

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moneymap.R
import com.example.moneymap.Utils
import com.example.moneymap.data.model.ExpenseEntity
import com.example.moneymap.data.model.ExpenseType
import com.example.moneymap.viewmodel.HomeViewModel

@Composable
fun TransactionList(viewModel: HomeViewModel, list: List<ExpenseEntity>, modifier: Modifier) {
    val sortedList = list.sortedByDescending { it.date }
    LazyColumn(modifier = modifier.padding(horizontal = 16.dp)) {
        item {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(text = stringResource(R.string.transaction_list_recent_transactions), fontSize = 20.sp)
            }
        }
        items(sortedList) {
            TransactionItem(
                title = it.title,
                amount = Utils.formatToDecimalValue(it.amount),
                icon = viewModel.getItemIcon(it),
                date = it.date,
                color = if (it.type == ExpenseType.INCOME) Color(0xFF57B41F) else Color(0xFFAC1111)
            )
        }
    }
}
