package com.revature.waitroom.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM Users WHERE username == :name")
    fun getUser(name:String) :LiveData<User>

    @Query("SELECT * From Users")
    fun getAllUsers() :LiveData<List<User>>
}