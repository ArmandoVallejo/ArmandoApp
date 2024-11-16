package com.example.armandoapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun HomeScreen (navController: NavController){
    Column (
        modifier = Modifier
            .fillMaxSize()
    ){
        Text(text = "This is the HomeScreen")
        Button(onClick = {navController.navigate("menu")}) {
            Text(text = "MenuScreen")
        }
        Button(onClick = {navController.navigate("components")}) {
            Text(text = "ComponentScreen")
        }
    }
}