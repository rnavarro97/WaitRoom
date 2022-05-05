package com.revature.waitroom.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users",primaryKeys = ["username"])
data class User(

    @ColumnInfo(name="username")
    var username:String="",

    @ColumnInfo(name = "password")
    var password:String=""
    )
