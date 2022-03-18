package com.revature.waitroom

import android.graphics.pdf.PdfDocument
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.revature.waitroom.data.InfoCards
import com.revature.waitroom.R
import com.revature.waitroom.ui.theme.WaitRoomTheme

class DocEditor : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaitRoomTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DocCard(name = "Micah Holt",
                        description = "He has a common cold." +
                                "He also have a headache and needs to take DayQuil" +
                                "and get plenty of rest")

                }

            }

        }
    }
}

@Composable
fun DocCard(name:String,description:String) {
//    val context = LocalContext.current
//    var patientList:List<InfoCards>
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
                Text(
                    text = name,
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier.padding(bottom = 8.dp),
                    fontSize = 20.sp
                )

                Text(text =description,
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier.padding(bottom = 4.dp),
                    fontSize = 12.sp
                )

//                var name by  rememberSaveable { mutableStateOf("")}
//                TextField(value = name,
//                    onValueChange = {name = it},
//                    textStyle =MaterialTheme.typography.h3,
//                    modifier = Modifier.padding(bottom = 8.dp),
//                    label = { Text(text = "Patient's name:")}
//                )

//                var description by  rememberSaveable { mutableStateOf("")}
//                TextField(value = description,
//                    onValueChange = {description = it},
//                    textStyle =MaterialTheme.typography.body2,
//                    modifier = Modifier.padding(bottom = 4.dp),
//                    label = { Text(text = "Diagnosis:")},
//                    maxLines = 4
//                )
            }
        }

    }
}


//
@Composable
fun PatientPrompt(patientList:List<InfoCards>){
    Scaffold(
        topBar = {
            TopAppBar() {

            }
        }
    ) {

    }
    
}
