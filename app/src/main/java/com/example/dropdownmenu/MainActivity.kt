package com.example.dropdownmenu


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = MaterialTheme.colors.background) {
                HomeScreen()
            }
        }
    }
}

@Composable
fun HomeScreen(){


    var expanded by remember{ mutableStateOf(false)}

    var selectedItem by remember{ mutableStateOf("Select Item")}

    val itemList = listOf(
        "C/C++", "Java", "Kotlin", "Python", "JavaScript", "Dart"
    )

    Column(
        Modifier.fillMaxSize().padding(vertical = 50.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        Alignment.CenterHorizontally
    ){

        Box{
            Button( onClick = { expanded = true} ){
                Row{
                    Text("$selectedItem  ")
                    Icon(Icons.Default.ArrowDropDown,"")
                }
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                itemList.forEach {
                    DropdownMenuItem(
                        onClick = {
                            expanded = false
                            selectedItem = it
                        }
                    ) { Text(it) }
                }
            }
        }

    }

}