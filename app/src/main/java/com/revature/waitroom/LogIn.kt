package com.revature.waitroom

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.revature.waitroom.ui.theme.WaitRoomTheme

class LogIn : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
             login()
        }
    }
}

@Composable
fun login() {
    val context=LocalContext.current
    Column {
        Text("Enter username", modifier = Modifier.absoluteOffset(x = 16.dp))
        var text = remember { mutableStateOf("") }
        TextField(value = text.value, modifier = Modifier.padding(16.dp), onValueChange = {
            text.value = it
        })
        Text("Enter password", modifier = Modifier.absoluteOffset(x = 16.dp))
        var text1 = remember { mutableStateOf(TextFieldValue("")) }
        TextField(value = text1.value, modifier = Modifier
            .padding(16.dp), onValueChange = {
            text1.value = it
        })
        Button(onClick = {
            Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show()
            context.startActivity(Intent(context,Menu::class.java))
        }) {
            Text("Finish")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
login()
}