package com.revature.waitroom

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.revature.waitroom.ui.theme.WaitRoomTheme

class LogIn : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Composable
fun login() {
    val context=LocalContext.current
    var text by remember { mutableStateOf("") }
    TextField(value = text, modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth(),
        onValueChange = { text = it }, label = { Text("Enter Username") },
        placeholder = { Text("Username") })

    var pword by remember { mutableStateOf("") }
    TextField(value = pword, modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth(),
        onValueChange = { pword = it }, label = { Text("Enter Password") },
        placeholder = { Text("Password") })

    Button(onClick = {context.startActivity(Intent(context,Menu::class.java))},
        modifier=Modifier.padding(16.dp))
    {
        Text(text="Log In")
//            Context.startActivity(Intent
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
login()
}