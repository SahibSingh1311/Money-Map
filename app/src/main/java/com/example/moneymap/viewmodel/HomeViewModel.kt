package com.example.moneymap.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moneymap.R
import com.example.moneymap.Utils
import com.example.moneymap.data.ExpenseDataBase
import com.example.moneymap.data.dao.ExpenseDao
import com.example.moneymap.data.model.ExpenseCategory
import com.example.moneymap.data.model.ExpenseEntity
import com.example.moneymap.data.model.ExpenseType

class HomeViewModel(dao: ExpenseDao) : ViewModel() {
    val expenses = dao.getAllExpenses()

    fun getBalance(list: List<ExpenseEntity>): String {
        var total = 0.0
        list.forEach {
            if (it.type == ExpenseType.INCOME) {
                total += it.amount
            } else {
                total -= it.amount
            }
        }
        return "$ ${Utils.formatToDecimalValue(total)}"
    }

    fun getTotalExpense(list: List<ExpenseEntity>): String {
        var expense = 0.0
        list.forEach {
            if (it.type == ExpenseType.EXPENSE) {
                expense += it.amount
            }
        }
        return "$ ${Utils.formatToDecimalValue(expense)}"
    }

    fun getTotalIncome(list: List<ExpenseEntity>): String {
        var income = 0.0
        list.forEach {
            if (it.type == ExpenseType.INCOME) {
                income += it.amount
            }
        }
        return "$ ${Utils.formatToDecimalValue(income)}"
    }

    fun getItemIcon(item: ExpenseEntity): Int {
        when (item.category) {
            ExpenseCategory.FOOD -> return R.drawable.food
            ExpenseCategory.TRANSPORTATION -> return R.drawable.transportation
            ExpenseCategory.HOUSING -> return R.drawable.housing
            ExpenseCategory.ENTERTAINMENT -> return R.drawable.entertainment
            ExpenseCategory.SHOPPING -> return R.drawable.shopping
            ExpenseCategory.TRAVEL -> return R.drawable.travel
            ExpenseCategory.EDUCATION -> return R.drawable.education
            ExpenseCategory.FINANCE -> return R.drawable.finance
            ExpenseCategory.GIFTS -> return R.drawable.gifts
            ExpenseCategory.GAMES -> return R.drawable.games
            ExpenseCategory.MEDICAL -> return R.drawable.medical
            ExpenseCategory.INSURANCE -> return R.drawable.insurance
            ExpenseCategory.INCOME -> return R.drawable.income
            else -> return R.drawable.miscellaneous
        }
    }
}

class HomeViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            val dao = ExpenseDataBase.getDatabase(context).expenseDao()

            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}