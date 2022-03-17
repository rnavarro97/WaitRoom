package com.revature.waitroom

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.revature.waitroom.ui.theme.WaitRoomTheme
import kotlinx.coroutines.launch

class VideoPlayer : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaitRoomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    VideoTranscript()
                }
            }
        }
    }
}

@Composable
fun VideoTranscript() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            Column {
                Button(onClick = {/*TODO*/ }, Modifier.fillMaxWidth()) {
                    Text("Home")
                }
                Button(onClick = {/*TODO*/ }, Modifier.fillMaxWidth()) {
                    Text("Documents")
                }
                Button(onClick = {/*TODO*/ }, Modifier.fillMaxWidth()) {
                    Text("Schedule an Appointment")
                }
            }
        },
        topBar = {
            TopAppBar(
                title = { Text("Video Library") },
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
        content= {

            Card(content = {
                Text(
                    //I'd like it not to be on a background of plain white
                    text = "Here I plan on importing video transcripts" +
                            "\nto the app, either from an external or" +
                            "\ninternal source. It has not been decided." +
                            "\nWhat we need most help with now is a media" +
                            "\ndisplay module, similar to the pdf viewer" +
                            "\nbut for videos. I'm currently looking under" +
                            "\nthe search term \"container.\""
                )
            }
//            backgroundColor=MaterialTheme.colors.surface
            )
        }
    )

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview7() {
    WaitRoomTheme {
        VideoTranscript()
    }
}