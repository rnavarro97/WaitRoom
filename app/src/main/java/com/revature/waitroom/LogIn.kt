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
import com.revature.waitroom.ui.theme.is_long_enough

class LogIn : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
             Login()
        }
    }
}

@Composable
fun Login() {
    val context=LocalContext.current
    Column {
        Text("Enter username", modifier = Modifier.absoluteOffset(x = 16.dp))
        var text = remember { mutableStateOf("") }
        TextField(value = text.value, modifier = Modifier.padding(16.dp), onValueChange = {
            text.value = it
        })
        Text("Enter password", modifier = Modifier.absoluteOffset(x = 16.dp))
        var text1 = remember { mutableStateOf("")}
        TextField(value = text1.value, modifier = Modifier
            .padding(16.dp), onValueChange = {
            text1.value = it
        })
        Button(onClick = {
            if(is_long_enough(text,text1) ==true)
            {
                Toast.makeText(context, "Signup successful", Toast.LENGTH_SHORT).show()
                context.startActivity(Intent(context, Menu::class.java))
            }
            else
            {
                Toast.makeText(context, "The username or password is incorrect", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text("Finish")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
Login()
}