package com.revature.waitroom

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.revature.waitroom.ui.theme.WaitRoomTheme
import kotlinx.coroutines.launch

class VideoLibrary : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaitRoomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    vidList()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun vidList() {
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
                    Button(onClick = {context.startActivity(Intent(context,DateAndTimePicker::class.java))}, Modifier.fillMaxWidth()) {
                        Text("Appointment Schedule")
                    }
                    Button(onClick = {context.startActivity(Intent(context,DocList::class.java))}, Modifier.fillMaxWidth()) {
                        Text("Documents")
                    }
                }
            },
            topBar = {
                TopAppBar(
                    title = { Text("Tutorial Library") },
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
            content = { innerPadding ->
                LazyColumn(contentPadding = innerPadding) {
                    items(count = 30)
                    {
                        Divider()
                        ListItem(
                            text = { Text("Video Title Here") },
                            icon = {
                                Icon(
                                    Icons.Filled.PlayArrow,
                                    contentDescription = null,
                                    modifier = Modifier.size(40.dp)
                                )
                            }
                        )
                    }
                }
            }
        )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    WaitRoomTheme {
        vidList()
    }
}