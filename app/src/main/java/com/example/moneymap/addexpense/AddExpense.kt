package com.example.moneymap.addexpense

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.moneymap.R
import com.example.moneymap.addexpense.components.DataForm
import com.example.moneymap.rememberImeState
import com.example.moneymap.viewmodel.AddExpenseViewModel
import com.example.moneymap.viewmodel.AddExpenseViewModelFactory
import kotlinx.coroutines.launch

@Composable
fun AddExpense(navController: NavController) {

    val HOME = "/home"

    val viewModel =
        AddExpenseViewModelFactory(LocalContext.current).create(AddExpenseViewModel::class.java)

    val coroutineScope = rememberCoroutineScope()
    Surface(modifier = Modifier.fillMaxSize()) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {

            val (nameRow, card, topBar) = createRefs()

            val imeState = rememberImeState()

            val scrollState = rememberScrollState()

            LaunchedEffect(key1 = imeState.value) {
                if (imeState.value) {
                    scrollState.animateScrollTo(scrollState.maxValue, tween(300))
                }
            }

            Image(painter = painterResource(id = R.drawable.ic_topbar),
                contentDescription = null,
                modifier = Modifier.constrainAs(topBar) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })

            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp, start = 16.dp, end = 16.dp)
                .constrainAs(nameRow) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {
                Text(
                    text = stringResource(R.string.add_expense_header),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.TopCenter)
                )
                Image(
                    painter = painterResource(id = R.drawable.dots_menu),
                    contentDescription = stringResource(R.string.content_description_menu),
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = stringResource(R.string.content_description_back),
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .clickable { navController.navigate(HOME) }
                )
            }
            DataForm(modifier = Modifier
                .padding(top = 60.dp)
                .constrainAs(card) {
                    top.linkTo(nameRow.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .verticalScroll(scrollState), onAddExpenseClick = {
                coroutineScope.launch {
                    if (viewModel.addExpense(it)) {
                        navController.popBackStack()
                    }
                }
            })
        }
    }
}

@Composable
@Preview(showBackground = true)
fun AddExpensePreview() {
    AddExpense(rememberNavController())
}
