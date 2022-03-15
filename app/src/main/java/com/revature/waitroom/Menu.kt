package com.revature.waitroom

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.revature.waitroom.ui.theme.WaitRoomTheme

class Menu : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            openMenu()
        }
    }
}

@Composable
fun openMenu() {
    val context=LocalContext.current
    Column(){
        Button(onClick = {context.startActivity(Intent(context,Appointments::class.java))},
            modifier=Modifier.padding(16.dp))
        {
            Text(text="Appointment Schedule")
        }
        Button(onClick = {context.startActivity(Intent(context,DocList::class.java))},
            modifier=Modifier.padding(16.dp))
        {
            Text(text="Document Viewer")
        }
        Button(onClick = {context.startActivity(Intent(context,VideoLibrary::class.java))},
            modifier=Modifier.padding(16.dp))
        {
            Text(text="Video Library")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    WaitRoomTheme {
        openMenu()
    }
}