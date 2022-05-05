package com.revature.waitroom.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

class UserViewModel(application: Application):AndroidViewModel(application) {
    private val repository: UserRepository=UserRepository(application)


    suspend fun insertUser(user: User) {
         viewModelScope.launch {
             repository.insertUser(user)
         }
    }

    fun findUser(name:String): LiveData<User>
    {
        val user=repository.getSpecifiedUser(name)
        return user
    }

    //fun getAllUsers()=repository.allusers
}