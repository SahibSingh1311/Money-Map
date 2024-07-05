package com.example.moneymap.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.moneymap.data.dao.ExpenseDao
import com.example.moneymap.data.model.ExpenseCategory
import com.example.moneymap.data.model.ExpenseEntity
import com.example.moneymap.data.model.ExpenseType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [ExpenseEntity::class], version = 1)
abstract class ExpenseDataBase : RoomDatabase() {
    abstract fun expenseDao(): ExpenseDao

    companion object {
        const val DATABASE_NAME = "expense_database"

        @JvmStatic
        fun getDatabase(context: Context): ExpenseDataBase {
            return Room.databaseBuilder(
                context,
                ExpenseDataBase::class.java,
                DATABASE_NAME
            ).addCallback(object : Callback(){
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    initBasicData(context)
                }

                fun initBasicData(context: Context){
                    CoroutineScope(Dispatchers.IO).launch {
                        val dao = getDatabase(context).expenseDao()
                        dao.insertExpense(ExpenseEntity(1,"Salary", 123.45, System.currentTimeMillis(),ExpenseCategory.INCOME,ExpenseType.INCOME))
                        dao.insertExpense(ExpenseEntity(2,"Fuel", 10.20, System.currentTimeMillis(),ExpenseCategory.FOOD,ExpenseType.EXPENSE))
                        dao.insertExpense(ExpenseEntity(3,"Fuel", 10.20, System.currentTimeMillis(),ExpenseCategory.TRAVEL,ExpenseType.EXPENSE))
                        dao.insertExpense(ExpenseEntity(4,"Fuel", 10.20, System.currentTimeMillis(),ExpenseCategory.GAMES,ExpenseType.EXPENSE))
                        dao.insertExpense(ExpenseEntity(5,"Fuel", 10.20, System.currentTimeMillis(),ExpenseCategory.FINANCE,ExpenseType.EXPENSE))
                        dao.insertExpense(ExpenseEntity(6,"Fuel", 10.20, System.currentTimeMillis(),ExpenseCategory.TRANSPORTATION,ExpenseType.EXPENSE))
                        dao.insertExpense(ExpenseEntity(7,"Fuel", 10.20, System.currentTimeMillis(),ExpenseCategory.MISCELLANEOUS,ExpenseType.EXPENSE))
                        dao.insertExpense(ExpenseEntity(8,"Fuel", 10.20, System.currentTimeMillis(),ExpenseCategory.INSURANCE,ExpenseType.EXPENSE))
                        dao.insertExpense(ExpenseEntity(9,"Fuel", 10.20, System.currentTimeMillis(),ExpenseCategory.MEDICAL,ExpenseType.EXPENSE))
                        dao.insertExpense(ExpenseEntity(10,"Fuel", 10.20, System.currentTimeMillis(),ExpenseCategory.GIFTS,ExpenseType.EXPENSE))
                        dao.insertExpense(ExpenseEntity(11,"Fuel", 10.20, System.currentTimeMillis(),ExpenseCategory.EDUCATION,ExpenseType.EXPENSE))
                        dao.insertExpense(ExpenseEntity(12,"Fuel", 10.20, System.currentTimeMillis(),ExpenseCategory.SHOPPING,ExpenseType.EXPENSE))
                        dao.insertExpense(ExpenseEntity(13,"Fuel", 10.20, System.currentTimeMillis(),ExpenseCategory.HOUSING,ExpenseType.EXPENSE))
                        dao.insertExpense(ExpenseEntity(14,"Fuel", 10.20, System.currentTimeMillis(),ExpenseCategory.ENTERTAINMENT,ExpenseType.EXPENSE))
                    }
                }
            }).build()
        }
    }
}