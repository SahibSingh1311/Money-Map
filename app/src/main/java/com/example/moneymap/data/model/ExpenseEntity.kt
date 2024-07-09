package com.example.moneymap.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expense_table")
data class ExpenseEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "amount")
    val amount: Double,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "category")
    val category: ExpenseCategory,
    @ColumnInfo(name = "type")
    val type: ExpenseType
)
