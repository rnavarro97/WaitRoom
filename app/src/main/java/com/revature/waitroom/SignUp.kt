package com.revature.waitroom

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.revature.waitroom.ui.theme.WaitRoomTheme
import com.revature.waitroom.ui.theme.is_long_enough

class SignUp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaitRoomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    signUp()
                }
            }
        }
    }
}

@Composable
fun signUp() {
    Column {
        val context = LocalContext.current
        Column {
            Text("Create username", modifier = Modifier.absoluteOffset(x = 16.dp))
            var text = remember { mutableStateOf("") }
            TextField(value = text.value, modifier = Modifier.padding(16.dp), onValueChange = {
                text.value = it
            })
            Text("Create password", modifier = Modifier.absoluteOffset(x = 16.dp))
            var text1 = remember { mutableStateOf("") }
            BasicTextField(value = text1.value, modifier = Modifier
                .padding(16.dp), onValueChange = {
                text1.value = it
            }, visualTransformation = PasswordVisualTransformation())
            Button(onClick = {
                if(is_long_enough(text.value,text1.value)==true)
                {
                    Toast.makeText(context, "Signup successful", Toast.LENGTH_SHORT).show()
                    context.startActivity(Intent(context, Menu::class.java))
                }
                else
                {
                    if(text.value.length==0) {
                        Toast.makeText(context, "Please enter a username", Toast.LENGTH_SHORT)
                            .show()
                    }
                    else{
                        Toast.makeText(context, "Please enter a long enough password", Toast.LENGTH_SHORT)
                            .show()
                    }
                }

            }) {
                Text("Sign up")
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    WaitRoomTheme {
        signUp()
    }
}