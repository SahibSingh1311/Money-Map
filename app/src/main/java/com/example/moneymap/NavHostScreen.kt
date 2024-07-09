package com.example.moneymap

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moneymap.addexpense.AddExpense
import com.example.moneymap.homescreen.HomeScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavHostScreen() {

    val navController = rememberNavController()
    val HOME = "/home"
    val ADD = "/add"

    NavHost(navController = navController, startDestination = HOME) {
        composable(route = HOME) {
            HomeScreen(navController)
        }

        composable(route = ADD) {
            AddExpense(navController)
        }
    }
}