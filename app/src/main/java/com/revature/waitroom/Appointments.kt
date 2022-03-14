package com.revature.waitroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.revature.waitroom.ui.theme.WaitRoomTheme

class Appointments : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaitRoomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Appointment()
                }
            }
        }
    }
}

@Composable
fun Appointment() {
    var date by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }
    Column{
        Row{
            Column {
                TextField(value = date, modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                    onValueChange = { date = it }, label = { Text("Enter appointment date") },
                    placeholder = { Text("Appointment Date") })

                TextField(value = time, modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                    onValueChange = { time = it }, label = { Text("Enter appointment time") },
                    placeholder = { Text("Appointment time") })
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {
    WaitRoomTheme {
        Appointment()
    }
}