package com.revature.waitroom

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.revature.waitroom.data.User
import com.revature.waitroom.data.UserViewModel
import com.revature.waitroom.ui.theme.WaitRoomTheme
import com.revature.waitroom.ui.theme.is_long_enough
import com.revature.waitroom.ui.theme.is_this
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LogIn : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        setContent {
      //       Login(userViewModel)
        }
    }
}

@Composable
fun Login(userViewModel: UserViewModel) {
    val context=LocalContext.current
    var scope=rememberCoroutineScope()
   // val allusers=userViewModel.getAllUsers()
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Login",fontSize = 25.sp)
        Spacer(modifier = Modifier.height(100.dp))
        Text("Enter username", modifier = Modifier.absoluteOffset(x = 16.dp))
        val text = remember { mutableStateOf("") }
        TextField(value = text.value, modifier = Modifier.padding(16.dp), onValueChange = {
            text.value = it
        })
        Text("Enter password", modifier = Modifier.absoluteOffset(x = 16.dp))
        val text1 = remember { mutableStateOf("")}
        TextField(value = text1.value, modifier = Modifier
            .padding(16.dp) , onValueChange = {
            text1.value = it
        }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation()
        )
        Button(onClick = {
           //     val users= allusers?.filter { it.username==text.value }
                val liveuser = userViewModel.findUser(text.value)
                liveuser.observeForever { user->
                    if (user.username == text.value && user.password == text1.value) {
                        Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show()
                        context.startActivity(Intent(context, Menu::class.java))
                    } else {
                        Toast.makeText(
                            context,
                            "The password is incorrect",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }




        }) {
            Text("Finish")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
//Login()
}