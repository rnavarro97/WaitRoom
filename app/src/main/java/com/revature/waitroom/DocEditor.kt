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
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
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
                    val cardList:List<InfoCards>

                    val navController = rememberNavController()
                    NavHost(navController = navController,
                        startDestination = DocCard(name = "Name Entry",
                            description = "Diagnosis: Details"))
                    {

                    }
                }

            }

        }
    }
}

@Composable
fun DocCard(name:String,description:String):String {
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
            }
        }

    }
  return name
}


//
@Composable
fun PatientPrompt(navController: NavController){
    val patientList:List<InfoCards> = listOf()

    Scaffold(
        topBar = {
           TopAppBar(backgroundColor = MaterialTheme.colors.primary,
               title = { Text(text = "Patient Notes")} //Change to Patient Note List later
           )
        }
    ) {
        LazyColumn(modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ){
           item {
               Row (
                   modifier = Modifier
                       .fillMaxWidth()
                       .wrapContentHeight()
                       .padding(vertical = 25.dp)
               ){
                   Text(text = "Patient Card Note View",
                       style = MaterialTheme.typography.h1,
                       fontSize = 40.sp
                   )
               }
           }
            items(patientList)
            {patient->
                //BasicTextField ->patient.name
                var text = rememberSaveable{ mutableStateOf("") }
                TextField(value = patient.name,
                    onValueChange = {patient.name = it},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    modifier = Modifier.padding(bottom = 8.dp),
                    label = { Text(text = "Patient's name:")},
                    maxLines = 1
                )
                //BasicTextField ->patient.description
                var text1 = rememberSaveable { mutableStateOf("")}
                TextField(value = patient.description,
                    onValueChange = {patient.description = it},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    modifier = Modifier.padding(bottom = 4.dp), 
                    label = { Text(text = "Diagnosis:")},
                    maxLines = 4
                )
                var card:String =DocCard(patient.name, patient.description)
                Button(onClick = { navController.navigate(card)}) {
                    Text("Submit Information")
                }


            }
        }
    }
    
}

