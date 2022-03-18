package com.revature.waitroom

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.revature.waitroom.ui.theme.WaitRoomTheme
import kotlinx.coroutines.launch
import kotlin.text.Typography

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
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val context=LocalContext.current
    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            Column {
                Button(onClick = {context.startActivity(Intent(context,Menu::class.java))}, Modifier.fillMaxWidth()) {
                    Text("Home")
                }
                Button(onClick = {context.startActivity(Intent(context,DocList::class.java))}, Modifier.fillMaxWidth()) {
                    Text("Documents")
                }
                Button(onClick = {context.startActivity(Intent(context,VideoLibrary::class.java))}, Modifier.fillMaxWidth()) {
                    Text("Video Library")
                }
            }
        },
        topBar = {
            TopAppBar(
                title = { Text("Set an Appointment") },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            scope.launch { scaffoldState.drawerState.open() }
                        }
                    ) {
                        Icon(Icons.Filled.Menu, contentDescription = "Localized description")
                    }
                }
            )
        },

        content = {
            Column {
                Text(text="Enter Appointment Date and Time",
                style = MaterialTheme.typography.h5)
                TextField(value = date, modifier = Modifier
                    .padding(16.dp)
                    /*.fillMaxWidth()*/,
                    onValueChange = { date = it }, label = { Text("Enter appointment date") },
                    placeholder = { Text("Appointment Date") })

                TextField(value = time,
                    modifier = Modifier
                        .padding(16.dp)
                    /*.fillMaxWidth()*/,
                    onValueChange = { time = it }, label = { Text("Enter appointment time") },
                    placeholder = { Text("Appointment time") }
                )

                Button(onClick = {}, modifier=Modifier.padding(16.dp)) {Text("Enter")

                }
            }

        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {
    WaitRoomTheme {
        Appointment()
    }
}