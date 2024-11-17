package com.example.armandoapp

import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.os.Bundle
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import com.example.armandoapp.ui.theme.ArmandoAppTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.armandoapp.biometrics.views.BiometricsScreen
import com.example.armandoapp.internet.NetworkMonitor
import com.example.armandoapp.maps.viewModel.SearchViewModel
import com.example.armandoapp.maps.views.HomeView
import com.example.armandoapp.maps.views.MapsSearchView
import com.example.armandoapp.ui.screens.Components
import com.example.armandoapp.ui.screens.HomeScreen
import com.example.armandoapp.ui.screens.LoginScreen
import com.example.armandoapp.ui.screens.MenuScreen
import android.Manifest
import com.example.armandoapp.camera.CameraScreen
import com.example.armandoapp.contacts_calendar.ContactScreen

//import androidx.navigation.compose.NavHostController

class MainActivity : AppCompatActivity() {

    private lateinit var wifiManager: WifiManager  // Para gestionar el Wi-Fi
    private lateinit var connectivityManager: ConnectivityManager  // Para gestionar las conexiones de red
    private lateinit var networkMonitor: NetworkMonitor  // Clase que monitorea el estado de la red

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val viewModel: SearchViewModel by viewModels()

        wifiManager = getSystemService(WIFI_SERVICE) as WifiManager
        connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager

        networkMonitor = NetworkMonitor(wifiManager, connectivityManager, this)

        setContent {
            ComposeMultiScreenApp(searchVM = viewModel, this, networkMonitor)

           /* Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
            ){
                CustomText()
                Picture()
                Content1()
                Content2()
               // Text(text = "Simple Text")
                //ModifierExample()
                //ModifierExample2()
                //ModifierExample3()
            }


            //Layouts
            /*Column{
                Text(text="First Row")
                Text(text="Second Row")
                Text(text="Third Row")
                Row{
                    Text(text="TEXT 1")
                    Text(text="TEXT 2")
                    Text(text="TEXT 3")
                }
                Box{
                    Text(text="label 1")
                    Text(text="label 2")
                }
                Greeting(name="World!")
            }*/
            */
        }


    }
    fun requestPermissionsIfNeeded() {
        val permissions = listOf(
            Manifest.permission.ACCESS_FINE_LOCATION,  // Permiso para la ubicación precisa
            Manifest.permission.ACCESS_COARSE_LOCATION  // Permiso para la ubicación aproximada
        ).filter {
            // Verificamos si alguno de los permisos no ha sido concedido
            ContextCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED
        }

        // Si falta algún permiso, solicitamos los permisos necesarios
        if (permissions.isNotEmpty()) {
            requestPermissionsLauncher.launch(permissions.toTypedArray())
        }
    }

    private val requestPermissionsLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions())
        { permissions ->
            // Verificamos si los permisos de ubicación fueron concedidos
            if (permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true ||
                permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true
            ) {
                // Si los permisos son concedidos, mostramos un mensaje
                Toast.makeText(this, "Permisos necesarios concedidos", Toast.LENGTH_SHORT).show()
            } else {
                // Si no se conceden, mostramos un mensaje de error
                Toast.makeText(this, "Permisos necesarios no concedidos", Toast.LENGTH_SHORT).show()
            }
        }
}

@Composable
fun ComposeMultiScreenApp( searchVM: SearchViewModel, activity: AppCompatActivity, networkMonitor: NetworkMonitor){
    val navController = rememberNavController()
    Surface(color=Color.White){
        SetupNavGraph(navController = navController, searchVM, activity, networkMonitor)
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController, searchVM: SearchViewModel, activity: AppCompatActivity, networkMonitor: NetworkMonitor){
    val context = LocalContext.current
    NavHost(navController = navController, startDestination="login"){
        composable("menu"){ MenuScreen(navController) }
        composable("home"){ HomeScreen(navController) }
        composable("components"){Components(navController)}
        composable("login"){LoginScreen(navController)}
        composable("biometrics"){BiometricsScreen(navController, activity)}
        composable("internet"){networkMonitor.NetworkMonitorScreen(navController)}
        composable("mapsHome"){ HomeView(navController = navController, searchVM = searchVM)}
        composable("camera"){CameraScreen(context = context, navController)}
        composable("contact"){ContactScreen(navController)}
        composable("MapsSearchView/{lat}/{long}/{address}", arguments = listOf(
            navArgument("lat") { type = NavType.FloatType },
            navArgument("long") { type = NavType.FloatType },
            navArgument("address") { type = NavType.StringType }
        )) {
            // Obtención de los argumentos con valores predeterminados en caso de que falten
            val lat = it.arguments?.getFloat("lat") ?: 0.0
            val long = it.arguments?.getFloat("long") ?: 0.0
            val address = it.arguments?.getString("address") ?: ""
            MapsSearchView(lat.toDouble(), long.toDouble(), address)
            }


    }
}



/*@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArmandoAppTheme {
        Greeting("Armando")
    }
}



//@Preview(showBackground = true)
@Composable
fun ModifierExample(){
    Column(
        modifier = Modifier.padding(24.dp)
    ){
        Text(text = "Hello World")
    }
}

//@Preview(showBackground = true)
@Composable
fun ModifierExample2(){
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
            .clickable(onClick = { clickAction() })
    ){
        Text(text = "Hello World")
    }
}

//@Preview(showBackground = true)
@Composable
fun ModifierExample3(){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp)
            .background(Color.Magenta)
            .border(width = 2.dp, color = Color.Green)
            .width(200.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {
        Text(text = "Item 1")
        Text(text = "Item 2")
        Text(text = "Item 3")
        Text(text = "Item 4")
        Text(text = "Item 5")
    }

}

//@Preview(showBackground = true)
@Composable
fun CustomText(){
    Column {
        Text(
            stringResource(R.string.hello_world_text),
            color = colorResource(R.color.purple_500),
            fontSize = 28.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold

        )
        val gradientColors = listOf(Cyan, Blue, Red)

        Text(
            stringResource(R.string.hello_world_text),
            style = TextStyle(brush = Brush.linearGradient(colors = gradientColors))

        )
    }
}

//@Preview(showBackground = true)
@Composable
fun Picture(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(),
            painter = painterResource(R.drawable.rym),
            contentDescription = "An image of Rick and Morty",
            contentScale = ContentScale.Fit

        )
    }
}

//@Preview(showBackground = true)
@Composable
fun Content1(){
    Card(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(5.dp)
    ){
        Text(text="This is a title",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            painter = painterResource(id = R.drawable.rym),
            contentDescription = "Rick and Morty Wallpaper",
            contentScale = ContentScale.Crop
        )
        Text(stringResource(R.string.text_card),
            lineHeight = 18.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(10.dp)
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun Content2(){
    Card(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(5.dp)
    ){
        Row{
            Image(
                modifier = Modifier
                    .width(200.dp)
                    .padding(
                        0.dp, 15.dp
                    ),

                painter = painterResource(id = R.drawable.rym),
                contentDescription = "Rick and Morty Wallpaper",
                contentScale = ContentScale.Fit
            )
            Column {
                Text(text="This is a title",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(10.dp)
                )
                Text(stringResource(R.string.text_card),
                    maxLines = 5,
                    lineHeight = 18.sp,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier
                        .padding(10.dp)
                )

            }

        }



    }
}

@Preview(showBackground = true)
@Composable
fun BoxExample(){
    Box(
        modifier = Modifier
            .background(Color.DarkGray)
            .fillMaxWidth()
            .padding(5.dp)
    ){
        Image(painterResource(R.drawable.rym),
            contentDescription = "Rick and Morty image",
            contentScale = ContentScale.FillBounds
        )
       Row (
           modifier = Modifier
               .fillMaxWidth()
               .padding(0.dp, 150.dp),
           horizontalArrangement = Arrangement.Center

       ){
           Icon(
               Icons.Filled.AccountBox,
               contentDescription = "Icon Add Circle"
           )
           Text(
               text="Text",
           )

       }
    }
}

@Preview(showBackground = true)
@Composable
fun BoxExample2(){
    Box(
        modifier = Modifier
            .background(Color.Magenta)
            .padding(5.dp)
            .size(250.dp)
    ){
        Text(text = "TopStart", Modifier.align(Alignment.TopStart))
        Text(text = "TopEnd", Modifier.align(Alignment.TopEnd))
        Text(text = "CenterStart", Modifier.align(Alignment.CenterStart))
        Text(text = "Center", Modifier.align(Alignment.Center))
        Text(text = "CenterEnd", Modifier.align(Alignment.CenterEnd))
        Text(text = "BottomStart", Modifier.align(Alignment.BottomStart))
        Text(text = "BottomEnd", Modifier.align(Alignment.BottomEnd))

    }
}

fun clickAction(){
    println("Column Clicked")
}*/

