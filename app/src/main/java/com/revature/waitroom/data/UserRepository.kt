package com.revature.waitroom.data

import android.app.Application
import androidx.lifecycle.LiveData

class UserRepository(application: Application){
    private var userDao:UserDao
    init {
        val database= UserDatabase.getDatabase(application)
        userDao = database.userDao()
    }
    suspend fun insertUser(user: User){
        userDao.insertUser(user)
    }

     fun getSpecifiedUser(name: String): LiveData<User> {
         val liveData = userDao.getUser(name)
         return liveData
     }
}