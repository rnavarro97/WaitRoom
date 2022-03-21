package com.revature.waitroom

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.revature.waitroom.ui.theme.WaitRoomTheme
import kotlinx.coroutines.launch
import java.util.*

class DocList : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaitRoomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    docList()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun docList() {
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
                Button(onClick = {context.startActivity(Intent(context,VideoLibrary::class.java))}, Modifier.fillMaxWidth()) {
                    Text("Tutorial Library")
                }
            }
        },
        topBar = {
            TopAppBar(
                title = { Text("Documents") },
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
                items(count = 5)
                {
                    Divider()
                    ListItem(
                        text = { Text("Document Name") },
                        icon = {
                            Icon(
                                Icons.Default.List,
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
fun DefaultPreview8() {
    WaitRoomTheme {
        docList()
    }
}