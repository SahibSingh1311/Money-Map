package com.example.moneymap.addexpense.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moneymap.R
import com.example.moneymap.Utils
import com.example.moneymap.addexpense.components.dropdown.ExpenseCategoryDropDown
import com.example.moneymap.addexpense.components.dropdown.ExpenseTypeDropDown
import com.example.moneymap.data.model.ExpenseCategory
import com.example.moneymap.data.model.ExpenseEntity
import com.example.moneymap.data.model.ExpenseType
import java.util.Date


@Composable
fun DataForm(modifier: Modifier, onAddExpenseClick: (model: ExpenseEntity) -> Unit) {
    val categoryList = listOf(
        ExpenseCategory.MISCELLANEOUS,
        ExpenseCategory.FOOD,
        ExpenseCategory.GIFTS,
        ExpenseCategory.GAMES,
        ExpenseCategory.TRAVEL,
        ExpenseCategory.INCOME,
        ExpenseCategory.ENTERTAINMENT,
        ExpenseCategory.HOUSING,
        ExpenseCategory.EDUCATION,
        ExpenseCategory.FINANCE,
        ExpenseCategory.SHOPPING,
        ExpenseCategory.MEDICAL,
        ExpenseCategory.INSURANCE,
        ExpenseCategory.TRANSPORTATION
    )

    val context = LocalContext.current

    val typeList = listOf(
        ExpenseType.EXPENSE,
        ExpenseType.INCOME
    )

    var name by remember {
        mutableStateOf("")
    }

    var amount by remember {
        mutableStateOf("")
    }

    var date by remember {
        mutableLongStateOf(0L)
    }

    var dateDialogVisibility by remember {
        mutableStateOf(false)
    }

    var category by remember {
        mutableStateOf(ExpenseCategory.MISCELLANEOUS)
    }

    var type by remember {
        mutableStateOf(ExpenseType.EXPENSE)
    }

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .shadow(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .padding(16.dp)
    ) {

        //Transaction type drop down
        Text(text = stringResource(R.string.transaction_type), fontSize = 14.sp, color = Color.Gray)
        Spacer(modifier = Modifier.size(4.dp))
        ExpenseTypeDropDown(category = typeList,
            selectedItem = {
                type = it
            })
        Spacer(modifier = Modifier.size(8.dp))

        //Transaction Title input text field
        Text(text = stringResource(R.string.transaction_title), fontSize = 14.sp, color = Color.Gray)
        Spacer(modifier = Modifier.size(4.dp))
        TextField(
            placeholder = { Text(text = stringResource(id = R.string.transaction_title))},
            value = name,
            onValueChange = { name = it },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Sentences),
            singleLine = true,
            isError = name.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(8.dp))

        //Transaction Amount input text field
        Text(text = stringResource(R.string.transaction_amount), fontSize = 14.sp, color = Color.Gray)
        Spacer(modifier = Modifier.size(4.dp))
        TextField(
            placeholder = { Text(text = stringResource(R.string.transaction_amount_placeholder))},
            value = amount,
            onValueChange = { amount = it },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done),
            singleLine = true,
            isError = name.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(8.dp))

        //Transaction Category drop down menu
        Text(text = stringResource(R.string.transaction_category), fontSize = 14.sp, color = Color.Gray)
        Spacer(modifier = Modifier.size(4.dp))
        ExpenseCategoryDropDown(category = categoryList,
            selectedItem = {
                category = it
            })
        Spacer(modifier = Modifier.size(8.dp))

        //Transaction Date Picker
        Text(text = stringResource(R.string.transaction_date), fontSize = 14.sp, color = Color.Gray)
        Spacer(modifier = Modifier.size(4.dp))
        TextField(
            value = if (date == 0L)  "" else Utils.formatDate(date),
            onValueChange = { },
            placeholder = { Text(text = Utils.formatDate(Date()))},
            modifier = Modifier
                .fillMaxWidth()
                .clickable { dateDialogVisibility = true },
            enabled = false
        )

        Button(onClick = {
            val model = ExpenseEntity(
                null,
                name,
                amount.toDoubleOrNull() ?: 0.0,
                Utils.formatDate(date),
                category,
                type
            )
            if(model.title.isNotEmpty()) {
                onAddExpenseClick(model)
            } else{
                Toast.makeText(context,
                    context.getString(R.string.transaction_warning),Toast.LENGTH_LONG).show()
            }
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = stringResource(R.string.transaction_add_expense_button), fontSize = 14.sp, color = Color.White)
        }
    }
    if (dateDialogVisibility) {
        ExpenseDatePickerDialogue(onDateSelected = {
            date = it
            dateDialogVisibility = !dateDialogVisibility
        }, onDismiss = {
            dateDialogVisibility = !dateDialogVisibility
        })
    }
}