package com.revature.waitroom.data

import android.app.Application
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LiveData

class UserRepository(application: Application){
    private var userDao:UserDao
    init {
        val database= UserDatabase.getDatabase(application)
        userDao = database.userDao()
    }
    suspend fun insertUser(user: User):Boolean{
        try {
            userDao.insertUser(user)
        }catch (e:Exception)
        {
           return false
        }
       return true
    }

     fun getSpecifiedUser(name: String): LiveData<User> {
         val liveData = userDao.getUser(name)
         return liveData
     }
}