package com.revature.waitroom.data

import android.app.Application
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.revature.waitroom.Screens
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

class UserViewModel(application: Application):AndroidViewModel(application) {
    private val repository: UserRepository=UserRepository(application)


    suspend fun insertUser(user: User,navController: NavController) {
         viewModelScope.launch {
             if(!repository.insertUser(user))
             {
                 navController.navigate(Screens.Signup.route)
             }

         }
    }

    fun findUser(name:String): LiveData<User>
    {
        val user=repository.getSpecifiedUser(name)
        return user
    }

    //fun getAllUsers()=repository.allusers
}