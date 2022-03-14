package com.revature.waitroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.revature.waitroom.ui.theme.WaitRoomTheme

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
                    libraryPage()
                }
            }
        }
    }
}

@Composable
fun libraryPage() {
    TopAppBar(title={Text("How-to Video Library")},
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ })
                {
                Icon(Icons.Filled.Menu, contentDescription=null)
                }
        }
    )
    Column{
        
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    WaitRoomTheme {
        libraryPage()
    }
}