package com.example.armandoapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun MenuScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
    ){
        Text(text = "This is the Menu Screen")
        Button(onClick = {navController.navigate("home")}) {
            Text(text = "HomeScreen")
        }
        Button(onClick = {navController.navigate("components")}) {
            Text(text = "ComponentScreen")
        }
        Button(onClick = {navController.navigate("mapsHome")}) {
            Text(text = "MapsScreen")
        }
        Button(onClick = {navController.navigate("biometrics")}) {
            Text(text = "BiometricsScreen")
        }
        Button(onClick = {navController.navigate("internet")}) {
            Text(text = "InternetScreen")
        }
        Button(onClick = {navController.navigate("camera")}) {
            Text(text = "CameraScreen")
        }
        Button(onClick = {navController.navigate("contact")}) {
            Text(text = "ContactScreen")
        }

    }
}