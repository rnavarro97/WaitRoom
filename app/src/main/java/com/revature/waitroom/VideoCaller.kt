package com.revature.waitroom

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement.Bottom
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.text.PlaceholderVerticalAlign.Companion.Bottom
import androidx.compose.ui.tooling.preview.Preview
import com.revature.waitroom.ui.theme.WaitRoomTheme

class VideoCaller : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaitRoomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    VideoCall()
                }
            }
        }
    }
}

@Composable
fun VideoCall() {
    Column{
        Text(text = "Still dealing with the same problem here." +
                "\nAt least we have a few buttons to show for" +
                "\n it, that being the \"end call\" key.",
//    TextAlign= Layout.Alignment.Bottom
        )

        FloatingActionButton(onClick = { /*TODO*/ },
                content= {Icon(Icons.Default.Call,
                    contentDescription = null)})
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview9() {
    WaitRoomTheme {
        VideoCall()
    }
}