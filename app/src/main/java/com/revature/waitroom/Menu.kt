package com.revature.waitroom

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.revature.waitroom.ui.theme.WaitRoomTheme

class Menu : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OpenMenu()
        }
    }
}

@Composable
fun OpenMenu() {

    val context = LocalContext.current
    Column(){
//        Button(onClick={
//            context.startActivity(Intent(context,Appointments::class.java))}) //should have an appointment class
//        {
//            Text(text="Appointment Schedule")
//        }
//        Button(onClick={
//            context.startActivity(Intent(context,DocumentViewer::class.java))}) //should have an document viewer class
//        {
//            Text(text="Document Viewer")
//        }
//        Button(onClick={
//            context.startActivity(Intent(context,VideoLibrary::class.java))}){
//            Text(text = "Video Library")
//        } //should have a How-To class
//

    Column() {
        Button(
            onClick = { context.startActivity(Intent(context, Appointments::class.java)) },
            modifier = Modifier.padding(16.dp)
        )
        {
            Text(text = "Appointment Schedule")
        }



        Button(
            onClick = { context.startActivity(Intent(context, DocList::class.java)) },
            modifier = Modifier.padding(16.dp)
        )
        {
            Text(text = "Document Viewer")
        }
        Button(
            onClick = { context.startActivity(Intent(context, VideoLibrary::class.java)) },
            modifier = Modifier.padding(16.dp)
        )

        {
            Text(text = "Tutorial Library")
        }
    }

}}

