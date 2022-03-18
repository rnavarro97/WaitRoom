package com.revature.waitroom.ui.theme

import androidx.compose.runtime.MutableState

fun is_long_enough(username:MutableState<String>,password:MutableState<String>):Boolean
{
    if(username.value.length>0&&password.value.length>5)
    {
        return true
    }
    return false
}