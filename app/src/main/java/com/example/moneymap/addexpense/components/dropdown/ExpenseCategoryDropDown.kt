package com.example.moneymap.addexpense.components.dropdown

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.moneymap.data.model.ExpenseCategory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpenseCategoryDropDown(
    category: List<ExpenseCategory>,
    selectedItem: (item: ExpenseCategory) -> Unit
) {

    var expandedCategory by remember {
        mutableStateOf(false)
    }
    var selectedText by remember {
        mutableStateOf(category[0].name)
    }

    ExposedDropdownMenuBox(
        expanded = expandedCategory,
        onExpandedChange = { expandedCategory = it }
    ) {
        TextField(
            value = selectedText,
            onValueChange = {},
            readOnly = true,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedCategory) },
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
        )

        ExposedDropdownMenu(expanded = expandedCategory, onDismissRequest = { }) {
            category.forEach { item ->
                DropdownMenuItem(
                    text = { Text(text = item.name) },
                    onClick = {
                        selectedText = item.name
                        selectedItem(item)
                        expandedCategory = false

                    })
            }
        }
    }
}