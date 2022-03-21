package com.revature.waitroom

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.revature.waitroom.ui.theme.WaitRoomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            welcomeScreen()
        }
    }
}


@Composable
fun welcomeScreen(){
    val context=LocalContext.current
    Column(horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center)
    {
        Text("Welcome to WaitRoom", color= Color.Blue, fontSize=30.sp)

        Image(
            painter = painterResource(id = R.drawable.doctoricon),
            contentDescription = null // decorative element
        )

        Button(onClick = {context.startActivity(Intent(context,SignUp::class.java))},
            modifier=Modifier.padding(16.dp)
                .fillMaxWidth())
        {
            Text(text="Sign Up")
//            Context.startActivity(Intent
        }

        Button(onClick = {context.startActivity(Intent(context,LogIn::class.java))},
            modifier=Modifier.padding(16.dp)
                .fillMaxWidth())
        {
            Text(text="Log In")
//            Context.startActivity(Intent
        }



    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    welcomeScreen()
}
