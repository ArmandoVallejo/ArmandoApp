package com.example.armandoapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Switch
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Components(navController: NavController){
    var component by remember{ mutableStateOf("") }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState=drawerState, //current state of drawer
        //drawer content
        drawerContent = {
            ModalDrawerSheet {
                Text("Menu", modifier = Modifier.padding(16.dp))
                HorizontalDivider()
                NavigationDrawerItem(label = { Text("Content 1")},
                    selected = false,
                    onClick = {
                        component = "Content1"
                        scope.launch { 
                            drawerState.apply { 
                                close()
                            }
                            
                        }
                    }
                )
                NavigationDrawerItem(label = { Text("Content 2")},
                    selected = false,
                    onClick = {
                        component = "Content2"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }

                        }
                    }
                )
                NavigationDrawerItem(label = { Text("Buttons")},
                    selected = false,
                    onClick = {
                        component = "Buttons"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }

                        }
                    }
                )
                NavigationDrawerItem(label = { Text("FloatingActionButtons")},
                    selected = false,
                    onClick = {
                        component = "FloatingActionButtons"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }

                        }
                    }
                )
                NavigationDrawerItem(label = { Text("Chips")},
                    selected = false,
                    onClick = {
                        component = "Chips"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }

                        }
                    }
                )
                NavigationDrawerItem(label = { Text("Progress")},
                    selected = false,
                    onClick = {
                        component = "Progress"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }

                        }
                    }
                )
                NavigationDrawerItem(label = { Text("Sliders")},
                    selected = false,
                    onClick = {
                        component = "Sliders"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }

                        }
                    }
                )
                NavigationDrawerItem(label = { Text("Switches")},
                    selected = false,
                    onClick = {
                        component = "Switches"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }

                        }
                    }
                )
                NavigationDrawerItem(label = { Text("Badges")},
                    selected = false,
                    onClick = {
                        component = "Badges"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }

                        }
                    }
                )
                NavigationDrawerItem(label = { Text("TimePickerExamples")},
                    selected = false,
                    onClick = {
                        component = "TimePickerExamples"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }

                        }
                    }
                )
                NavigationDrawerItem(label = { Text("DatePickerExamples")},
                    selected = false,
                    onClick = {
                        component = "DatePickerExamples"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }

                        }
                    }
                )

                }
            
        }

    ) {
        //screen content
        Column {
            when(component){
                "Content1" -> {
                    Content1()
                }
                "Content2" ->{
                    Content2()
                }
                "Buttons" ->{
                    Buttons()
                }
                "FloatingActionButtons" ->{
                    FloatingButtons()
                }
                "Chips" ->{
                    Chips()
                }
                "Progress" ->{
                    Progress()
                }
                "Sliders" ->{
                    Sliders()
                }
                "Switches" ->{
                    Switches()
                }
                "Badges" ->{
                    Badges()
                }
                "TimePickerExamples"->{
                    TimePickerExamples()
                }
                "DatePickerExamples"->{
                    DatePickerExamples()
                }

            }
        }

    }

}

@Composable
fun Content1(){
    Text(text = "Content 1")
}

@Composable
fun Content2(){
    Text(text = "Content 2")
}

@Composable
fun Buttons(){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ){
        Button(onClick = {}) {
            Text("Filled")
        }
        FilledTonalButton(onClick = {}) {
            Text("Tonal")
        }
        OutlinedButton(onClick = {}) {
            Text("Outlined")
        }
        ElevatedButton(onClick = {}) {
            Text("Elevated")
        }
        TextButton(onClick = {}) {
            Text("Text")
        }
    }
}

@Composable
fun FloatingButtons(){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        FloatingActionButton(onClick = {}){
            Icon(Icons.Filled.Add, "")
        }
        SmallFloatingActionButton(onClick = {}){
            Icon(Icons.Filled.Add, "")
        }
        LargeFloatingActionButton(onClick = {}){
            Icon(Icons.Filled.Add, "")
        }
        ExtendedFloatingActionButton(
            onClick = {},
            icon = {Icon(Icons.Filled.Add, "")},
            text = {Text(text = "Extended FAB")}
        )

    }
}

@Preview(showBackground = true)
@Composable
fun Chips(){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        AssistChip(
            onClick = {},
            label = { Text("Asssist Chip")},
            leadingIcon = {
                Icon(Icons.Filled.AccountBox, "",
                    Modifier.size(AssistChipDefaults.IconSize))
            }
        )

        var selected by remember { mutableStateOf(false) }

        FilterChip(
            selected=selected,
            onClick = {selected = !selected},
            label = { Text("Filter Chip")},
            leadingIcon = {
                if (selected){
                    Icon(Icons.Filled.AccountBox, contentDescription = "asd")
                }
                 else{
                    null
                }
            }
        )

        InputChipExample("Dismiss", {})


    }
}

@Composable
fun InputChipExample(
    text: String,
    onDismiss: () -> Unit
){
    var enabled by remember { mutableStateOf(true)}
    if(!enabled) return

    InputChip(
        label = { Text(text)},
        selected = enabled,
        onClick = {
            onDismiss()
            enabled = !enabled
        },
        avatar ={
            Icon(
                Icons.Filled.Person,
                contentDescription="",
                Modifier.size(InputChipDefaults.AvatarSize)

            )
        },
        trailingIcon ={
            Icon(
                Icons.Filled.Close,
                contentDescription="",
                Modifier.size(InputChipDefaults.AvatarSize)

            )
        }
    )

}

@Composable
fun Progress(){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ){
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth()
        )
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp)
        )
    }
}

@Composable
fun Sliders(){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ){
        var sliderPosition by remember{ mutableStateOf(50f) }
        Column {
            Slider(
                value = sliderPosition,
                onValueChange = {sliderPosition=it},
                steps = 10,
                valueRange = 0f..100f
            )
            Text(
                text = sliderPosition.toString(),
                modifier=Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
            )
        }

    }
}

@Composable
fun Switches(){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ){
        var checked by remember{ mutableStateOf(true) }
        Switch(
            checked=checked,
            onCheckedChange = {
                checked = it
            }
        )

        var checked2 by remember{ mutableStateOf(true) }
        Switch(
            checked=checked2,
            onCheckedChange = {
                checked2 = it
            },
            thumbContent = if(checked2){
                { Icon(
                    Icons.Filled.Close,
                    contentDescription="",
                    Modifier.size(InputChipDefaults.AvatarSize)
                )
                }
            }
            else{
                null
            }
        )

        var checked3 by remember{ mutableStateOf(true) }
        Checkbox(checked = checked3,onCheckedChange = {checked3=it})

    }
}

@Composable
fun Badges(){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ){
        var itemCount by remember { mutableStateOf(0) }

        BadgedBox(
            badge= {
                if(itemCount>0){
                    Badge(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ){
                        Text(text = "$itemCount")
                    }
                }
            }
        ) {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "Shopping cart"
            )
        }
        Button(
            onClick = {itemCount++}
        ){
          Text(text = "Add item")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialExample(
) {
    val currentTime = Calendar.getInstance()

    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = true,
    )
    Column {
        TimePicker(
            state = timePickerState
        )

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerDocked() {
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    val selectedDate = datePickerState.selectedDateMillis?.let {
        convertMillisToDate(it)
    } ?: ""

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = selectedDate,
            onValueChange = { },
            label = { Text("DOB") },
            readOnly = true,
            trailingIcon = {
                IconButton(onClick = { showDatePicker = !showDatePicker }) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Select date"
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
        )

        if (showDatePicker) {
            Popup(
                onDismissRequest = { showDatePicker = false },
                alignment = Alignment.TopStart
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = 64.dp)
                        .shadow(elevation = 4.dp)
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(16.dp)
                ) {
                    DatePicker(
                        state = datePickerState,
                        showModeToggle = false
                    )
                }
            }
        }
    }
}

fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}





@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputExample(

) {
    val currentTime = Calendar.getInstance()

    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = true,
    )

    Column {
        TimeInput(
            state = timePickerState
        )
    }
}



@Composable
fun TimePickerExamples(){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ){
        DialExample()
        InputExample()
    }
}

@Composable
fun DatePickerExamples(){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ){
        DatePickerDocked()
    }
}




