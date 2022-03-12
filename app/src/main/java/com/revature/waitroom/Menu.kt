package com.revature.waitroom

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
    Column(){
        Button(onClick={
            Log.d("Button Clicked",
            "Clicking Button")})
        {
            Text(text="Appointment Schedule")
        }
        Button(onClick={
            Log.d("Button Clicked",
                "Clicking Button")})
        {
            Text(text="Document Viewer")
        }
        Button(onClick={
            Log.d("Button Clicked",
                "Clicking Button")})
        {
            Text(text="How-To")
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