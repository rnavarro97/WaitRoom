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
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import kotlinx.coroutines.launch

class SignUp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        setContent {
            WaitRoomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
     //               signUp(userViewModel)
                }
            }
        }
    }
}

@Composable
fun SignUp(navController: NavController,userViewModel: UserViewModel) {
    val scope= rememberCoroutineScope()
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        val context = LocalContext.current
        Text(text = "Create your account",fontSize = 25.sp)
        Spacer(modifier = Modifier.height(100.dp))
        Column {
            Text("Create username", modifier = Modifier.absoluteOffset(x = 16.dp))
            val text = remember { mutableStateOf("") }
            TextField(value = text.value, modifier = Modifier.padding(16.dp), onValueChange = {
                text.value = it
            })
            Text("Create password", modifier = Modifier.absoluteOffset(x = 16.dp))
            val text1 = remember { mutableStateOf("") }
            TextField(value = text1.value, modifier = Modifier
                .padding(16.dp) , onValueChange = {
                text1.value = it
            }, visualTransformation = PasswordVisualTransformation())
            Button(onClick = {
                if(is_long_enough(text.value,text1.value)==true)
                {
                    Toast.makeText(context, "Signup successful", Toast.LENGTH_SHORT).show()
                    scope.launch {
                            userViewModel.insertUser(User(username=text.value,password=text1.value))
                    }

                    navController.navigate(Screens.Login.route)
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
                Text("Sign up",modifier = Modifier.fillMaxWidth())
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    WaitRoomTheme {
       // signUp()
    }
}