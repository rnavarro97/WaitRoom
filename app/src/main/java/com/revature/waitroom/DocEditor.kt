package com.revature.waitroom

import android.graphics.pdf.PdfDocument
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.revature.waitroom.ui.theme.WaitRoomTheme

class DocEditor : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Composable
fun DocCard() {
    val context = LocalContext.current

    Card (
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.padding(8.dp)) {
              var name by  rememberSaveable { mutableStateOf("")}
                TextField(value = name,
                    onValueChange = {name = it},
                    textStyle =MaterialTheme.typography.h3,
                    modifier = Modifier.padding(bottom = 8.dp),
                    label = { Text(text = "Patient's name:")}
                )

                var description by  rememberSaveable { mutableStateOf("")}
                TextField(value = description,
                    onValueChange = {description = it},
                    textStyle =MaterialTheme.typography.body2,
                    modifier = Modifier.padding(bottom = 4.dp),
                    label = { Text(text = "Diagnosis:")},
                    maxLines = 4
                )
            }
        }

    }




}

