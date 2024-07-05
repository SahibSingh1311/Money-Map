package com.example.moneymap.homescreen.components.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moneymap.R
import com.example.moneymap.ui.theme.GreenTheme

@Composable
fun CardItem(expense: String,
             income: String,
             balance: String,
             modifier: Modifier) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(GreenTheme)
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier.align(Alignment.TopStart)) {
                Text(
                    text = "Total Balance",
                    fontSize = 16.sp,
                    color = Color.White
                )
                Text(
                    text = balance,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Image(
                painter = painterResource(id = R.drawable.dots_menu),
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {

            CardRowItem(
                title = "Income",
                amount = income,
                icon = R.drawable.ic_income,
                modifier = Modifier.align(Alignment.CenterStart)
            )
            CardRowItem(
                title = "Expense",
                amount = expense,
                icon = R.drawable.ic_expense,
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }
    }

}
